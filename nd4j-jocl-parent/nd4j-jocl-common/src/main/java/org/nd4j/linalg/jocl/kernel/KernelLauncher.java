/*
 * JCudaUtils - Utilities for JCuda 
 * http://www.jcuda.org
 *
 * Copyright (c) 2010 Marco Hutter - http://www.jcuda.org
 * 
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package org.nd4j.linalg.jocl.kernel;

import org.jocl.*;
import org.nd4j.linalg.jocl.context.ContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


/**
 * This is a kernel launcher along the same
 * concept as the kernel launcher in jcuda.
 *
 * This simplifies the process of launching a kernel with the
 * jocl api.
 *
 * @author Adam Gibson
 */
public class KernelLauncher {




    /**
     * The logger used in this class
     */
    private static final Logger logger = LoggerFactory.getLogger(KernelLauncher.class.getName());



    /**
     * The number of the device which should be used by the
     * KernelLauncher
     */
    private  cl_device_id deviceNumber;

    private cl_platform_id platform;

    private cl_command_queue queue;


    /**
     * Set the number (index) of the device which should be used
     * by the KernelLauncher
     *
     * @param number The number of the device to use
     * @throws JoclException If number < 0 or number >= deviceCount
     */
    public  void setDeviceNumber(cl_device_id number) {
        deviceNumber = number;
    }


    public cl_command_queue getQueue() {
        return queue;
    }



    public cl_device_id getDeviceNumber() {
        return deviceNumber;
    }

    public cl_platform_id getPlatform() {
        return platform;
    }

    public void setPlatform(cl_platform_id platform) {
        this.platform = platform;
    }

    /**
     * Create a new KernelLauncher which may be used to execute the
     * specified function which is loaded from the PTX- or CUBIN
     * (CUDA binary) file with the given name.
     *
        *
     * @param moduleFileName The name of the PTX- or CUBIN file
     * @param functionName The name of the function
     * @return The KernelLauncher for the specified function
     * @throws JoclException If the PTX- or CUBIN may not be loaded,
     * or the specified function can not be obtained.
     */
    public static KernelLauncher load(
            String moduleFileName, String functionName,cl_platform_id platform,cl_device_id device,cl_command_queue queue) {
        KernelLauncher kernelLauncher = new KernelLauncher();
        byte moduleData[] = loadData(moduleFileName);
        kernelLauncher.setDeviceNumber(device);
        kernelLauncher.setPlatform(platform);

        kernelLauncher.initModule(moduleData);
        kernelLauncher.initFunction(functionName);
        return kernelLauncher;
    }



    /**
     * Load the data from the file with the given name and returns
     * it as a 0-terminated byte array
     *
     * @param fileName The name of the file
     * @return The data from the file
     */
    private static byte[] loadData(String fileName)
    {
        InputStream inputStream = null;
        try
        {
            inputStream= new FileInputStream(new File(fileName));
            return loadData(inputStream);
        }
        catch (FileNotFoundException e)
        {
            throw new JoclException(
                    "Could not open '"+fileName+"'", e);
        }
        finally
        {
            if (inputStream != null)
            {
                try
                {
                    inputStream.close();
                }
                catch (IOException e)
                {
                    throw new JoclException(
                            "Could not close '"+fileName+"'", e);
                }
            }
        }
    }

    /**
     * Reads the data from the given inputStream and returns it as
     * a 0-terminated byte array.
     *
     * @param inputStream The inputStream to read
     * @return The data from the inputStream
     */
    private static byte[] loadData(InputStream inputStream)
    {
        ByteArrayOutputStream baos = null;
        try
        {
            baos = new ByteArrayOutputStream();
            byte buffer[] = new byte[8192];
            while (true)
            {
                int read = inputStream.read(buffer);
                if (read == -1)
                {
                    break;
                }
                baos.write(buffer, 0, read);
            }
            baos.write('\0');
            baos.flush();
            return baos.toByteArray();
        }
        catch (IOException e)
        {
            throw new JoclException(
                    "Could not load data", e);
        }
        finally
        {
            if (baos != null)
            {
                try
                {
                    baos.close();
                }
                catch (IOException e)
                {
                    throw new JoclException(
                            "Could not close output", e);
                }
            }
        }

    }



    /**
     * The context which was used to create this instance
     */
    private cl_context context;

    /**
     * The module which contains the function
     */
    private cl_program module;

    /**
     * The function which is executed with this KernelLauncher
     */
    private cl_kernel function;


    /**
     * Private constructor. Instantiation only via the static
     * methods.
     */
    private KernelLauncher() {
        initialize();
    }

    /**
     * Initializes this KernelLauncher. This method will try to
     * initialize the JCuda driver API. Then it will try to
     * attach to the current CUDA context. If no active CUDA
     * context exists, then it will try to create one, for
     * the device which is specified by the current
     * deviceNumber.
     *
     * @throws JoclException If it is neither possible to
     * attach to an existing context, nor to create a new
     * context.
     */
    private void initialize() {
        context = ContextHolder.getInstance().getContext(platform,deviceNumber);
    }




    /**
     * Create a new KernelLauncher which uses the same module as
     * this KernelLauncher, but may be used to execute a different
     * function. All parameters (grid size, block size, shared
     * memory size and stream) of the returned KernelLauncher
     * will be independent of 'this' one and initially contain
     * the default values.
     *
     * @param functionName The name of the function
     * @return The KernelLauncher for the specified function
     * @throws JoclException If the specified function can not
     * be obtained from the module of this KernelLauncher.
     */
    public KernelLauncher forFunction(String functionName)
    {
        KernelLauncher kernelLauncher = new KernelLauncher();
        kernelLauncher.module = this.module;
        kernelLauncher.initFunction(functionName);
        return kernelLauncher;
    }


    /**
     * Initialize the module for this KernelLauncher by loading
     * the PTX- or CUBIN file with the given name.
     *
     * @param moduleData The data from the PTX- or CUBIN file
     */
    private void initModule(byte moduleData[]) {
        module = CL.clCreateProgramWithSource(context,1,new String[]{new String(moduleData)},null,null);
        CL.clBuildProgram(module,1,null,null,null,null);
    }

    /**
     * Initialize this KernelLauncher for calling the function with
     * the given name, which is contained in the module of this
     * KernelLauncher
     *
     * @param functionName The name of the function
     */
    private void initFunction(String functionName) {
        // Obtain the function from the module
        function = CL.clCreateKernel(module,functionName,null);
        queue =
                CL.clCreateCommandQueue(context, deviceNumber, 0, null);
    }

    /**
     * Returns the module that was created from the PTX- or CUBIN file, and
     * which contains the function that should be executed. This
     * module may also be used to access symbols and texture
     * references. However, clients should not modify or unload
     * the module.
     *
     * @return The CUmodule
     */
    public cl_program getModule() {
        return module;
    }




    public  cl_context context() {
        return context;
    }


    /**
     * Call the function of this KernelLauncher with the current
     * grid size, block size, shared memory size and stream, and
     * with the given arguments.<br />
     * <br />
     * The given arguments must all be either of the type
     * <code>Pointer</code>, or of a primitive type except boolean.
     * Otherwise, a JoclException will be thrown.
     *
     * @param args The arguments for the function call
     * @throws JoclException if an argument with an invalid type
     * was given, or one of the internal functions for setting
     * up and executing the kernel failed.
     */
    public synchronized void call(Object ... args) {

        Pointer kernelParameters[] = new Pointer[args.length];

        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg instanceof Pointer)
            {
                Pointer argPointer = (Pointer)arg;
                Pointer pointer = Pointer.to(argPointer);
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is Pointer");
            }
            else if (arg instanceof Byte)
            {
                Byte value = (Byte)arg;
                Pointer pointer = Pointer.to(new byte[]{value});
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is Byte");
            }
            else if (arg instanceof Short)
            {
                Short value = (Short)arg;
                Pointer pointer = Pointer.to(new short[]{value});
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is Short");
            }
            else if (arg instanceof Integer)
            {
                Integer value = (Integer)arg;
                Pointer pointer = Pointer.to(new int[]{value});
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is Integer");
            }
            else if (arg instanceof Long)
            {
                Long value = (Long)arg;
                Pointer pointer = Pointer.to(new long[]{value});
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is Long");
            }
            else if (arg instanceof Float)
            {
                Float value = (Float)arg;
                Pointer pointer = Pointer.to(new float[]{value});
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is Float");
            }
            else if (arg instanceof Double)
            {
                Double value = (Double)arg;
                Pointer pointer = Pointer.to(new double[]{value});
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is Double");
            }

            else if (arg instanceof double[])
            {
                double[] value = (double[])arg;
                Pointer pointer = Pointer.to(value);
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is double[]");
            }
            else if (arg instanceof float[])
            {
                float[] value = (float[])arg;
                Pointer pointer = Pointer.to(value);
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is float[]");
            }

            else if (arg instanceof int[])
            {
                int[] value = (int[])arg;
                Pointer pointer = Pointer.to(value);
                kernelParameters[i] = pointer;
                logger.info("argument " + i + " type is int[]");
            }

            else
            {
                throw new JoclException(
                        "Type " + arg.getClass() + " may not be passed to a function");
            }
        }




        for(int i = 0; i < kernelParameters.length; i++) {
            CL.clSetKernelArg(function,i,Sizeof.cl_mem,kernelParameters[i]);
        }

        // Execute the kernel
        CL.clEnqueueNDRangeKernel(queue, function, 1, null,
                new long[]{kernelParameters.length}, null, 0, null, null);

        CL.clFinish(queue);
        CL.clReleaseCommandQueue(queue);
        CL.clReleaseKernel(function);
        CL.clReleaseProgram(module);
    }


}



