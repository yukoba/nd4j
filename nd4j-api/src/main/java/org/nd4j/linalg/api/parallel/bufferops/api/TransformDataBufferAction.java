package org.nd4j.linalg.api.parallel.bufferops.api;

import org.nd4j.linalg.api.buffer.DataBuffer;

/**
 * Created by agibsonccc on 10/7/15.
 */
public interface TransformDataBufferAction {
    /**
     * Does the actual task
     */
    void doTask();

    org.nd4j.linalg.api.parallel.bufferops.TransformDataBufferAction getSubTask(int threshold, int n, DataBuffer x, DataBuffer y, DataBuffer z,
                                                                                int offsetX, int offsetY, int offsetZ, int incrX, int incrY, int incrZ);
}
