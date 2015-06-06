---
layout: page
title: "ND4J's Benchmarking Tool"
description: ""
---
{% include JB/setup %}

ND4J can measure and display how long various operations take on any given machine. 

## Tutorial

Here's how you get the numbers:

* In IntelliJ, create a new project. (We'll call this example "AppTest".) 
* Next, you'll add ND4J dependencies to the POM.xml file of the new project. One dependency should be *nd4j-perf*, which contains the benchmarking classes, and the other dependencies will represent the various backends you may want to test; i.e. *nd4j-jblas*, *n4j-netlib-blas*, *nd4j-java* and, finally, *nd4j-jcublas* if you've got GPUs. 
* Within the *properties* tag of the POM, specify the most recent version of nd4j, which you should have installed with your latest *git pull*.
* Your entire POM file should look something like this:

		<?xml version="1.0" encoding="UTF-8"?>
		<project xmlns="http://maven.apache.org/POM/4.0.0"
		         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		    <modelVersion>4.0.0</modelVersion>
		
		    <groupId>AppTest</groupId>
		    <artifactId>AppTest</artifactId>
		    <version>1.0-SNAPSHOT</version>
		
		    <properties>
		        <nd4j.version>0.0.3.5.5.5-SNAPSHOT</nd4j.version>
		    </properties>
		
		    <dependencies>
		        <dependency>
		            <groupId>org.nd4j</groupId>
		            <artifactId>nd4j-jblas</artifactId>
		            <version>${nd4j.version}</version>
		        </dependency>
		        <dependency>
		            <groupId>org.nd4j</groupId>
		            <artifactId>nd4j-perf</artifactId>
		            <version>${nd4j.version}</version>
		        </dependency>
		    </dependencies>
		</project>

* Now Click on IntelliJ's *Run* menu and select *Edit Configurations*. This will open a window with a plus sign on the upper lefthand side. 
![Alt text](../img/benchmarks_1.png)
* Click on that, and select *Application* from the drop-down menu. 
* Next, enter *BenchmarkRunnerApp* in the "Main Class" field. In the "Program Arguments" field, enter the terms *-n 5*. 
* On the bottom right of the same window, first click the "Apply" button, and then "OK".
![Alt text](../img/benchmarks_2.png)
* Finally, go back to the POM of your AppTest project, and click the green Run arrow on the upper right. At the bottom of your screen, a sub-window within IntelliJ's project window should open, and after a while, you will see the benchmarks begin to appear. 

## Results 

* They will look like this:

		== Benchmark: org.nd4j.linalg.benchmark.gemm.GemmBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 21506200 (in milliseconds) 21
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.addirowvector.AddiRowVectorBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 16564210600 (in milliseconds) 16564
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.convolution.ConvolutionBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 11211553600 (in milliseconds) 11211
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.scalar.ScalarBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 278433400 (in milliseconds) 278
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.elementwise.AddiRowVectorBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 82746600 (in milliseconds) 82
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.linearview.LinearViewBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 526400 (in milliseconds) 0
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.fft.FFTBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 838606600 (in milliseconds) 838
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.linearview.getput.GetPutScalarLinearViewBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 2800 (in milliseconds) 0
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.dimensionwise.DimensionWiseBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 440400 (in milliseconds) 0
		====================================================

## Netty

If you have both GPUs and CPUs, you can benchmark on both and contrast the results, using a Jcublas and Jblas backend, respectively. 

With Jcublas, we use a [Netty](http://netty.io/) byte buffer for storage. It's faster to access individual elements stored as zeros and ones than to use a Java array structure. That increase in speed is evident as we benchmark our matrix operations. For many operations, speeds differ by an order of magnitude. 

		== Benchmark: org.nd4j.linalg.benchmark.linearview.LinearViewBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 448555 (in milliseconds) 0
		Backend org.nd4j.linalg.jcublas.JCublasBackend took (in nanoseconds) 366566 (in milliseconds) 0
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.linearview.getput.GetPutScalarLinearViewBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 1724 (in milliseconds) 0
		Backend org.nd4j.linalg.jcublas.JCublasBackend took (in nanoseconds) 272 (in milliseconds) 0
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.scalar.ScalarBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 219017469 (in milliseconds) 219
		Backend org.nd4j.linalg.jcublas.JCublasBackend took (in nanoseconds) 33366182 (in milliseconds) 33
		====================================================
		== Benchmark: org.nd4j.linalg.benchmark.elementwise.AddiRowVectorBenchmarkPerformer ==
		Backend org.nd4j.linalg.jblas.JblasBackend took (in nanoseconds) 57554886 (in milliseconds) 57
		Backend org.nd4j.linalg.jcublas.JCublasBackend took (in nanoseconds) 6393774 (in milliseconds) 6
		====================================================
## Comments

The numbers reported will be specific to your machine, the backend you choose, and the "Program Arguments" you enter. It's good to start with five iterations to test that benchmarks are working, and then increase them. 

All operations are dealing with a matrix with 10,000 rows by 10,000 columns, which flattens to a 100-million length vector. That's not an unrealistic number for real problems, so only matrices of this size or larger will give us meaningful tests. 

The time each operation takes will be reported in both nanoseconds and milliseconds. Some operations will round down to zero milliseconds, while others will take longer. 

The aim of this feature is not to demonstrate that we have the fastest neural nets, but to enable DL4J and ND4J users to show us what's running slow, so we can improve it. These benchmarks obviously measure the speed of single matrix operations, rather than training on, say, ImageNet. 

The more we can optimize these lower-level operations at the heart of neural-net training, the faster they will run in parallel on a distributed system, which is the ideal architecture for DL4J. 
