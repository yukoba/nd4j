/*
 * Copyright 2015 Skymind,Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.nd4j.linalg.jocl.buffer.factory;

import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.buffer.IntBuffer;
import org.nd4j.linalg.api.buffer.factory.DataBufferFactory;
import org.nd4j.linalg.jocl.buffer.OpenClDoubleDataBuffer;
import org.nd4j.linalg.jocl.buffer.OpenClFloatDataBuffer;
import org.nd4j.linalg.jocl.buffer.OpenClIntDataBuffer;
import org.nd4j.linalg.util.ArrayUtil;

/**
 * Created by agibsonccc on 2/14/15.
 */
public class CudaDataBufferFactory implements DataBufferFactory {
    @Override
    public DataBuffer createDouble(int length) {
        return new OpenClDoubleDataBuffer(length);
    }

    @Override
    public DataBuffer createFloat(int length) {
        return new OpenClFloatDataBuffer(length);
    }

    @Override
    public DataBuffer createInt(int length) {
        return new IntBuffer(length);
    }

    @Override
    public DataBuffer createDouble(int[] data) {
        return new OpenClDoubleDataBuffer(ArrayUtil.toDoubles(data));
    }

    @Override
    public DataBuffer createFloat(int[] data) {
        return new OpenClFloatDataBuffer(ArrayUtil.toFloats(data));
    }

    @Override
    public DataBuffer createInt(int[] data) {
        return new OpenClIntDataBuffer(data);
    }

    @Override
    public DataBuffer createDouble(double[] data) {
        return new OpenClDoubleDataBuffer(data);
    }

    @Override
    public DataBuffer createFloat(double[] data) {
        return new OpenClFloatDataBuffer(ArrayUtil.toFloats(data));
    }

    @Override
    public DataBuffer createInt(double[] data) {
        return new IntBuffer(ArrayUtil.toInts(data));
    }

    @Override
    public DataBuffer createDouble(float[] data) {
        return new OpenClDoubleDataBuffer(ArrayUtil.toDoubles(data));
    }

    @Override
    public DataBuffer createFloat(float[] data) {
        return new OpenClFloatDataBuffer(data);
    }

    @Override
    public DataBuffer createInt(float[] data) {
        return new IntBuffer(ArrayUtil.toInts(data));
    }

    @Override
    public DataBuffer createDouble(int[] data, boolean copy) {
        return new OpenClDoubleDataBuffer(ArrayUtil.toDouble(data));
    }

    @Override
    public DataBuffer createFloat(int[] data, boolean copy) {
        return new OpenClFloatDataBuffer(ArrayUtil.toFloats(data));
    }

    @Override
    public DataBuffer createInt(int[] data, boolean copy) {
        return new OpenClIntDataBuffer(data);
    }

    @Override
    public DataBuffer createDouble(double[] data, boolean copy) {
        return new OpenClDoubleDataBuffer(data);
    }

    @Override
    public DataBuffer createFloat(double[] data, boolean copy) {
        return new OpenClFloatDataBuffer(ArrayUtil.toFloats(data));
    }

    @Override
    public DataBuffer createInt(double[] data, boolean copy) {
        return new OpenClIntDataBuffer(ArrayUtil.toInts(data));
    }

    @Override
    public DataBuffer createDouble(float[] data, boolean copy) {
        return new OpenClDoubleDataBuffer(ArrayUtil.toDoubles(data));
    }

    @Override
    public DataBuffer createFloat(float[] data, boolean copy) {
        return new OpenClFloatDataBuffer(data);
    }

    @Override
    public DataBuffer createInt(float[] data, boolean copy) {
        return new OpenClIntDataBuffer(ArrayUtil.toInts(data));
    }
}
