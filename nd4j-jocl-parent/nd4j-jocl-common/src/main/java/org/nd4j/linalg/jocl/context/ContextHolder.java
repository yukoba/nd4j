package org.nd4j.linalg.jocl.context;

import com.google.common.collect.*;
import org.jocl.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A multithreaded version derived from the cuda launcher util
 * by the authors of jcuda.
 *
 * This class handles managing cuda contexts
 * across multiple devices and threads.
 *
 *
 * @author Adam Gibson
 */
public class ContextHolder {
    private Table<cl_device_id,String,cl_context> deviceToThreadAndContext = HashBasedTable.create();
    private Map<cl_platform_id,List<cl_device_id>> platformToDevice = new HashMap<>();
    private Map<cl_platform_id,Integer> numDevices = new HashMap<>();
    private static ContextHolder INSTANCE;
    private int numPlatforms = 0;
    private ContextHolder(){
        getNumPlatforms();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                for(Table.Cell<cl_device_id,String,cl_context> cell : deviceToThreadAndContext.cellSet()) {
                    CL.clReleaseContext(cell.getValue());
                    CL.clReleaseDevice(cell.getRowKey());
                }
            }
        }));
    }

    public static ContextHolder getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ContextHolder();
        return INSTANCE;
    }


    private void getNumPlatforms() {
        // Obtain the number of platforms
        int numPlatformsArray[] = new int[1];
        CL.clGetPlatformIDs(0, null, numPlatformsArray);
        numPlatforms = numPlatformsArray[0];
        cl_platform_id platforms[] = new cl_platform_id[numPlatforms];
        CL.clGetPlatformIDs(platforms.length, platforms, null);
        for(cl_platform_id platform_id : platforms)
            getNumDevices(platform_id);
    }

    private void getNumDevices(cl_platform_id platform) {
        int count[] = new int[1];
        CL.clGetDeviceIDs(platform,0,1,null,count);
        numDevices.put(platform,count[0]);

        // Obtain a device ID
        cl_device_id devices[] = new cl_device_id[numDevices.get(platform)];
        CL.clGetDeviceIDs(platform, CL.CL_DEVICE_TYPE, numDevices.get(platform), devices, null);
        List<cl_device_id> deviceList = new ArrayList<>();

        for(cl_device_id device : devices) {
            deviceList.add(device);
        }

        platformToDevice.put(platform,deviceList);

    }

    /**
     * Retrieve a context for use with the current thread
     * and the given device
     * @return the t
     */
    public  synchronized cl_context getContext() {
        cl_platform_id platform  = platformToDevice.keySet().iterator().next();
        cl_device_id firstDevice = platformToDevice.get(platform).get(0);
        cl_context ctx = deviceToThreadAndContext.get(firstDevice,Thread.currentThread().getName());
        return ctx;
    }

    /**
     * Retrieve a context for use with the current thread
     * and the given device
     * @param deviceToUse the device to use
     * @return the t
     */
    public  synchronized cl_context getContext(cl_platform_id platform,cl_device_id deviceToUse) {
        Thread currentThread = Thread.currentThread();
        cl_context ctx = deviceToThreadAndContext.get(deviceToUse, currentThread.getName());
        if(ctx == null) {
            ctx = new cl_context();
            for(int device = 0; device < numDevices.get(platform); device++) {
                ctx = initialize(platform,deviceToUse);
                deviceToThreadAndContext.put(deviceToUse,currentThread.getName(),ctx);


            }

        }

        return ctx;
    }


    /**
     * Initializes this KernelLauncher. This method will try to
     * initialize the JCuda driver API. Then it will try to
     * attach to the current CUDA context. If no active CUDA
     * context exists, then it will try to create one, for
     * the device which is specified by the current
     * deviceNumber.

     */
    private cl_context initialize(cl_platform_id platform,cl_device_id device) {
        // Create a context for the selected device
        // Initialize the context properties
        cl_context_properties contextProperties = new cl_context_properties();
        contextProperties.addProperty(CL.CL_CONTEXT_PLATFORM, platform);


        return CL.clCreateContext(
                contextProperties, 1, new cl_device_id[]{device},
                null, null, null);
    }


    public Table<cl_device_id, String, cl_context> getDeviceToThreadAndContext() {
        return deviceToThreadAndContext;
    }

    public void setDeviceToThreadAndContext(Table<cl_device_id, String, cl_context> deviceToThreadAndContext) {
        this.deviceToThreadAndContext = deviceToThreadAndContext;
    }

    public Map<cl_platform_id, List<cl_device_id>> getPlatformToDevice() {
        return platformToDevice;
    }

    public void setPlatformToDevice(Map<cl_platform_id, List<cl_device_id>> platformToDevice) {
        this.platformToDevice = platformToDevice;
    }

    public Map<cl_platform_id, Integer> getNumDevices() {
        return numDevices;
    }

    public void setNumDevices(Map<cl_platform_id, Integer> numDevices) {
        this.numDevices = numDevices;
    }

    public void setNumPlatforms(int numPlatforms) {
        this.numPlatforms = numPlatforms;
    }
}
