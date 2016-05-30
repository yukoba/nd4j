package org.nd4j.jita.flow.impl;

import org.nd4j.jita.allocator.Allocator;
import org.nd4j.jita.allocator.enums.AllocationStatus;
import org.nd4j.jita.allocator.enums.CudaConstants;
import org.nd4j.jita.allocator.impl.AllocationPoint;
import org.nd4j.jita.allocator.pointers.cuda.cudaEvent_t;
import org.nd4j.jita.allocator.pointers.cuda.cudaStream_t;
import org.nd4j.jita.allocator.utils.AllocationUtils;
import org.nd4j.jita.conf.Configuration;
import org.nd4j.jita.conf.CudaEnvironment;
import org.nd4j.jita.flow.FlowController;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.jcublas.context.CudaContext;
import org.nd4j.nativeblas.NativeOps;
import org.nd4j.nativeblas.NativeOpsHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author raver119@gmail.com
 */
public class BatchedFlowController implements FlowController {
    private static final Configuration configuration = CudaEnvironment.getInstance().getConfiguration();
    private volatile Allocator allocator;
    private int commandQueue;
    private List<ConcurrentLinkedQueue<cudaEvent_t>> backend = new ArrayList<>();
    protected NativeOps nativeOps = NativeOpsHolder.getInstance().getDeviceNativeOps();
    private static Logger logger = LoggerFactory.getLogger(BatchedFlowController.class);

    @Override
    public void init(Allocator allocator) {
        this.allocator = allocator;
        commandQueue = configuration.getCommandQueueLength();
    }

    @Override
    public void synchronizeToHost(AllocationPoint point) {
        if (point.isConstant())
            return;

        if (!point.isActualOnHostSide() && point.getAllocationStatus() == AllocationStatus.DEVICE) {
            waitTillFinished(point);

            CudaContext context = (CudaContext) allocator.getDeviceContext().getContext();

            if (nativeOps.memcpyAsync(
                    point.getHostPointer().address(),
                    point.getDevicePointer().address(),
                    AllocationUtils.getRequiredMemory(point.getShape()),
                    CudaConstants.cudaMemcpyDeviceToHost,
                    context.getSpecialStream().address()) == 0)
                throw new IllegalStateException("MemcpyAsync D2H failed: [" + point.getDevicePointer().address() + "] -> [" + point.getHostPointer().address() + "]");

            commitTransfer(context.getSpecialStream());
        }
    }

    @Override
    public void waitTillFinished(AllocationPoint point) {
        if (point.getWriteLane() != null && !point.getWriteLane().isDestroyed()) {
            cudaEvent_t event = point.getWriteLane();
            if (event != null && !event.isDestroyed()) {
                event.synchronize();
                event.destroy();
            }
        }
    }

    @Override
    public void registerAction(CudaContext context, INDArray result, INDArray... operands) {

    }

    @Override
    public CudaContext prepareAction(INDArray result, INDArray... operands) {
        CudaContext context = (CudaContext) allocator.getDeviceContext().getContext();

        return context;
    }

    @Override
    public CudaContext prepareAction(AllocationPoint result, AllocationPoint... operands) {
        CudaContext context = (CudaContext) allocator.getDeviceContext().getContext();

        return context;
    }

    @Override
    public void registerAction(CudaContext context, AllocationPoint result, AllocationPoint... operands) {
        Integer deviceId = allocator.getDeviceId();

        cudaEvent_t event = new cudaEvent_t(nativeOps.createEvent());
        backend.get(deviceId).add(event);

        result.setWriteLane(event);

        if (backend.get(deviceId).size() >= commandQueue) {
            cudaEvent_t backEvent = backend.get(deviceId).poll();
            if (backEvent != null && !backEvent.isDestroyed()) {
                backEvent.synchronize();
                backEvent.destroy();
            }
        }
    }

    @Override
    public void waitTillReleased(AllocationPoint point) {

    }

    @Override
    public void commitTransfer(cudaStream_t streamUsed) {
        // no-op
    }
}
