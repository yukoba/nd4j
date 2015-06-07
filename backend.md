---
layout: page
title: "ND4J Backends: How They Work"
description: "Linear Algebra Backends Jblas, Netlib Blas, Jcublas"
---
{% include JB/setup %}

ND4J works atop so-called backends, or linear-algebra libraries, such as Jblas, Netlib Blas and Jcublas (GPUs), which you can select by pasting the [right dependency into your project's POM.xml file](http://nd4j.org/dependencies.html). 

A Java [ServiceLoader](https://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html), which is baked into the language itself, tells Java that the backend exists. It's not necessary to concern yourself with how ND4J backends load and perform other basic functions, but you can explore [how ND4J loads and selects backends, according to your OS, here](https://github.com/deeplearning4j/nd4j/blob/master/nd4j-api/src/main/java/org/nd4j/linalg/factory/Nd4jBackend.java).

The core configurations for each backend are specified in a properties file. Using Jblas as an example, this post will quickly explain each line in the [*nd4j-jblas.properties* file here](https://github.com/deeplearning4j/nd4j/blob/master/nd4j-jblas/src/main/resources/nd4j-jblas.properties).

<script src="http://gist-it.appspot.com/https://github.com/deeplearning4j/nd4j/blob/master/nd4j-jblas/src/main/resources/nd4j-jblas.properties?slice=18:35"></script>

Let's step through this line by line with some brief comments:

    //points to array class for real numbers
    real.class.double = org.nd4j.linalg.jblas.NDArray 
    
    //points to array class for complex numbers
    complex.class.double = org.nd4j.linalg.jblas.complex.ComplexNDArray 
    
    //defines the default data type as a float
    dtype = float  
    
    //again points to appropriate class
    complex.double.class = org.nd4j.linalg.jblas.complex.ComplexDouble 
    
    // Blas wrappers let you speak to the underlying linalg subprocesses.
    blas.ops = org.nd4j.linalg.jblas.BlasWrapper 
    
    //this factory creates NDArrays for Jblas
    ndarrayfactory.class = org.nd4j.linalg.jblas.JblasNDArrayFactory  
    
    //f stands for fortran, with column-major arrays. 
    //the alternative is c, which is row-major
    ndarray.order = f 
    resourcemanager_state = false 
    
    // the databufferfactory will differ if you use of cpus or gpus...
    databufferfactory = org.nd4j.linalg.api.buffer.factory.DefaultDataBufferFactory 
    
    //memory allocation can use arrays for storage with "heap".
    //it uses raw byte buffers/netty with "direct".
    alloc = heap 
    
    //fft specifies which fast-fourier transform impl to use
    fft = org.nd4j.linalg.fft.DefaultFFTInstance

You can see most of the classes the properties config file lines map to in this snapshot of nd4j-jblas's unfurled directory structure. 

![Alt text](../img/nd4j_backend_config.png)

A few more points:

* Regardless of the backend you choose, you use the same ND4J API for everything, including GPUs and distributed systems. 
* You can override all properties in the above file from the command line using *mvn -D$your_parameter_here*.
* **Backend prioritization**: You can include multiple backends on the classpath. If you do, ND4J will run on as many as GPUs as you have available, exhaust them, and then start adding CPUs, allowing you to operate on mixed hardware. 
* C programmers engaged in numerical or scientific computing may ask (with a touch of disdain ;) why we built a Java API over several backends. This architecture allows us to largely abstract away the hardware, while optimizing for it under the hood. Software engineers writing in Java or Scala can build scalable numerical software once, and then deploy on multiple platforms, knowing that we've done the work of lower-level optimization, and that their algorithms will work on servers, desktops and Android phones. Another advantage is that you can build your own backends, test them in isolation, and benefit from a higher-level language. 

## nd4j-benchmark

The [nd4j-benchmark project](https://github.com/deeplearning4j/nd4j-benchmark) on Github is dedicated to running benchmarks on ND4J matrix operations.

Run:

        org.nd4j.linalg.benchmark.app.BenchmarkRunnerApp -n $YOUR NUMBER OF TRIALS -r csv of fully qualified path of trials you want to run *(e.g. org.nd4j.linalg.benchmark.app.BenchmarkRunnerApp)*

##Command-Line Example 

Here's a general matrix multiplication (Gemm) example already included in the *nd4j-perf* module:

            java -cp lib/* org.nd4j.linalg.benchmark.app.BenchmarkRunnerApp -n 10k -r                 org.nd4j.linalg.benchmark.gemm.GemmBenchmarkPerformer,org.nd4j.linalg.benchmark.gemm.GemmBenchmarkPerformer

Notice we specify gemm twice. This is just to demonstrate how you would run multiple classes.

##IntelliJ

You can also run this in IntelliJ with an [app configuration](https://www.jetbrains.com/idea/help/creating-and-editing-run-debug-configurations.html).

Specify *org.nd4j.linalg.benchmark.app.BenchmarkRunnerApp* as the main class, and specify your arguments in program arguments.

#Heap Space

If you need more heap space (in your VM arguments), add:

        -XmxMAX_HEAP_SPACE -XmsMINHEAP_SPACE
        
        -Xmx2g -Xms2g

#Flags

**-r** If you leave -r off, it will run every benchmark on the class path

To run one or more particular backends, just include them in your POM.xml file (the default combination right now is jcublas vs jblas).

**-n** number of trials

#Custom OpRunners

1) Create a class extending BaseBenchmarkPerformer (similar to what we did in the copy benchmark). 
2) Create an associated OpRunner. 
3) Pass that custom OpRunner in to your new benchmaker performer.
4) The BenchmarkRunnerApp will automatically pick those classes up and run them for you.
