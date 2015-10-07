package org.nd4j.linalg.api.parallel.bufferops.api;

import org.apache.commons.math3.util.Pair;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.ops.IndexAccumulation;

/**
 * Created by agibsonccc on 10/7/15.
 */
public interface IndexAccumulationDataBufferTask {
    Pair<Double,Integer> doTask();

    org.nd4j.linalg.api.parallel.bufferops.IndexAccumulationDataBufferTask getSubTask(IndexAccumulation op, int threshold, int n, DataBuffer x, DataBuffer y,
                                                                                      int offsetX, int offsetY, int incrX, int incrY, int elementOffset, boolean outerTask);
}
