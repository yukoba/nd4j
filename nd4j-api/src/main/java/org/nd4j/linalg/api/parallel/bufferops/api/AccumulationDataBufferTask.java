package org.nd4j.linalg.api.parallel.bufferops.api;

import org.nd4j.linalg.api.buffer.DataBuffer;

/**
 * Created by agibsonccc on 10/7/15.
 */
public interface AccumulationDataBufferTask {
    double doTask();

    org.nd4j.linalg.api.parallel.bufferops.AccumulationDataBufferTask getSubTask(int threshold, int n, DataBuffer x, DataBuffer y,
                                                                                 int offsetX, int offsetY, int incrX, int incrY, boolean outerTask);
}
