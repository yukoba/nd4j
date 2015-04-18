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

package org.nd4j.linalg.jocl;


import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.buffer.DoubleBuffer;
import org.nd4j.linalg.api.buffer.FloatBuffer;
import org.nd4j.linalg.api.ndarray.BaseNDArray;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.List;

/**
 * Created by mjk on 8/23/14.
 *
 * @author mjk
 * @author Adam Gibson
 */

public class OpenClNDArray extends BaseNDArray {


    public OpenClNDArray(double[][] data) {
        super(data);

    }

    public OpenClNDArray(int[] shape, DataBuffer buffer) {
        super(shape, buffer);
    }

    /**
     * Create this joclNDArray with the given data and shape and 0 offset
     *
     * @param data     the data to use
     * @param shape    the shape of the joclNDArray
     * @param ordering
     */
    public OpenClNDArray(float[] data, int[] shape, char ordering) {
        super(data, shape, ordering);


    }

    /**
     * @param data     the data to use
     * @param shape    the shape of the joclNDArray
     * @param offset   the desired offset
     * @param ordering the ordering of the joclNDArray
     */
    public OpenClNDArray(float[] data, int[] shape, int offset, char ordering) {
        super(data, shape, offset, ordering);


    }

    /**
     * Construct an joclNDArray of the specified shape
     * with an empty data array
     *
     * @param shape    the shape of the joclNDArray
     * @param stride   the stride of the joclNDArray
     * @param offset   the desired offset
     * @param ordering the ordering of the joclNDArray
     */
    public OpenClNDArray(int[] shape, int[] stride, int offset, char ordering) {
        super(shape, stride, offset, ordering);

    }

    /**
     * Create the joclNDArray with
     * the specified shape and stride and an offset of 0
     *
     * @param shape    the shape of the joclNDArray
     * @param stride   the stride of the joclNDArray
     * @param ordering the ordering of the joclNDArray
     */
    public OpenClNDArray(int[] shape, int[] stride, char ordering) {

        super(shape, stride, ordering);

    }

    public OpenClNDArray(int[] shape, int offset, char ordering) {

        super(shape, offset, ordering);

    }

    public OpenClNDArray(int[] shape) {

        super(shape);

    }

    /**
     * Creates a new <i>n</i> times <i>m</i> <tt>DoubleMatrix</tt>.
     *
     * @param newRows    the number of rows (<i>n</i>) of the new matrix.
     * @param newColumns the number of columns (<i>m</i>) of the new matrix.
     * @param ordering
     */
    public OpenClNDArray(int newRows, int newColumns, char ordering) {
        super(newRows, newColumns, ordering);

    }

    /**
     * Create an joclNDArray from the specified slices.
     * This will go through and merge all of the
     * data from each slice in to one joclNDArray
     * which will then take the specified shape
     *
     * @param slices   the slices to merge
     * @param shape    the shape of the joclNDArray
     * @param ordering
     */
    public OpenClNDArray(List<INDArray> slices, int[] shape, char ordering) {

        super(slices, shape, ordering);

    }

    /**
     * Create an joclNDArray from the specified slices.
     * This will go through and merge all of the
     * data from each slice in to one joclNDArray
     * which will then take the specified shape
     *
     * @param slices   the slices to merge
     * @param shape    the shape of the joclNDArray
     * @param stride
     * @param ordering
     */
    public OpenClNDArray(List<INDArray> slices, int[] shape, int[] stride, char ordering) {
        super(slices, shape, stride, ordering);

    }

    public OpenClNDArray(float[] data, int[] shape, int[] stride, char ordering) {
        super(data, shape, stride, ordering);

    }

    public OpenClNDArray(float[] data, int[] shape, int[] stride, int offset, char ordering) {
        super(data, shape, stride, offset, ordering);

    }

    public OpenClNDArray(DataBuffer data, int[] shape, int[] stride, int offset) {
        super(data, shape, stride, offset);
    }

    public OpenClNDArray(int[] data, int[] shape, int[] strides) {
        super(data, shape, strides);
    }

    public OpenClNDArray(DataBuffer data, int[] shape) {
        super(data, shape);
    }

    public OpenClNDArray(DataBuffer buffer, int[] shape, int offset) {
        super(buffer, shape, offset);
    }

    /**
     * Create this joclNDArray with the given data and shape and 0 offset
     *
     * @param data  the data to use
     * @param shape the shape of the joclNDArray
     */
    public OpenClNDArray(float[] data, int[] shape) {
        super(data, shape);
    }

    public OpenClNDArray(float[] data, int[] shape, int offset) {

        super(data, shape, offset);

    }

    /**
     * Construct an joclNDArray of the specified shape
     * with an empty data array
     *
     * @param shape  the shape of the joclNDArray
     * @param stride the stride of the joclNDArray
     * @param offset the desired offset
     */
    public OpenClNDArray(int[] shape, int[] stride, int offset) {

        super(shape, stride, offset);
    }

    /**
     * Create the joclNDArray with
     * the specified shape and stride and an offset of 0
     *
     * @param shape  the shape of the joclNDArray
     * @param stride the stride of the joclNDArray
     */
    public OpenClNDArray(int[] shape, int[] stride) {
        super(shape, stride);
    }

    public OpenClNDArray(int[] shape, int offset) {
        super(shape, offset);
    }

    public OpenClNDArray(int[] shape, char ordering) {
        super(shape, ordering);
    }

    /**
     * Creates a new <i>n</i> times <i>m</i> <tt>DoubleMatrix</tt>.
     *
     * @param newRows    the number of rows (<i>n</i>) of the new matrix.
     * @param newColumns the number of columns (<i>m</i>) of the new matrix.
     */
    public OpenClNDArray(int newRows, int newColumns) {
        super(newRows, newColumns);
    }

    /**
     * Create an joclNDArray from the specified slices.
     * This will go through and merge all of the
     * data from each slice in to one joclNDArray
     * which will then take the specified shape
     *
     * @param slices the slices to merge
     * @param shape  the shape of the joclNDArray
     */
    public OpenClNDArray(List<INDArray> slices, int[] shape) {
        super(slices, shape);
    }

    /**
     * Create an joclNDArray from the specified slices.
     * This will go through and merge all of the
     * data from each slice in to one joclNDArray
     * which will then take the specified shape
     *
     * @param slices the slices to merge
     * @param shape  the shape of the joclNDArray
     * @param stride
     */
    public OpenClNDArray(List<INDArray> slices, int[] shape, int[] stride) {
        super(slices, shape, stride);

    }

    public OpenClNDArray(float[] data, int[] shape, int[] stride) {
        super(data, shape, stride);
    }


    public OpenClNDArray(float[] data, int[] shape, int[] stride, int offset) {
        super(data, shape, stride, offset);
    }

    public OpenClNDArray(float[] data) {
        super(data);
    }


    public OpenClNDArray(OpenClNDArray doubleMatrix) {
        this(new int[]{doubleMatrix.rows, doubleMatrix.columns});
        this.data = dup().data();
    }

    public OpenClNDArray(double[] data, int[] shape, int[] stride, int offset) {
        this.data = Nd4j.createBuffer(data);
        this.stride = stride;
        this.offset = offset;
        init(shape);
    }

    public OpenClNDArray(float[][] floats) {
        super(floats);
    }

    public OpenClNDArray(DataBuffer buffer, int[] shape, int offset, char ordering) {
        super(buffer, shape, offset, ordering);
    }

    public OpenClNDArray() {
    }

    public OpenClNDArray(DataBuffer buffer) {
        super(buffer);
    }

    public OpenClNDArray(DataBuffer buffer, int[] shape, int[] stride, int offset, char ordering) {
        super(buffer, shape, stride, offset, ordering);
    }

    public OpenClNDArray(float[] data, char order) {
        super(data, order);
    }

    public OpenClNDArray(FloatBuffer floatBuffer, char order) {
        super(floatBuffer, order);
    }

    public OpenClNDArray(DataBuffer buffer, int[] shape, int[] strides) {
        super(buffer, shape, strides);
    }

    public OpenClNDArray(double[] data, int[] shape, char ordering) {
        this(new DoubleBuffer(data), shape, 0,ordering);
    }

    public OpenClNDArray(double[] data, int[] shape, int[] stride, int offset, char ordering) {
        super(data, shape, stride, offset, ordering);
    }




}