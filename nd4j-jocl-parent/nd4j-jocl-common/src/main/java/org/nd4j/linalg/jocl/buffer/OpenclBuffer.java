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

package org.nd4j.linalg.jocl.buffer;

import org.jocl.cl_mem;
import org.nd4j.linalg.api.buffer.DataBuffer;

import java.nio.ByteBuffer;

/**
 * An opencl buffer
 *
 * @author Adam Gibson
 */
public interface OpenclBuffer extends DataBuffer {

    /**
     * THe pointer for the buffer
     *
     * @return the pointer for this buffer
     */
    public cl_mem pointer();

    /**
     * Allocate the buffer
     */
    public void alloc();

    /**
     * The underlying data buffer
     * @return the underlying data buffer
     */
    public ByteBuffer buff();


    /**
     * Sets the data for this pointer
     * from the data in this pointer
     *
     * @param pointer the pointer to set
     */
    void set(ByteBuffer pointer);


}
