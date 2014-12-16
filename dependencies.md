---
layout: page
title: "Getting Started"
description: ""
---
{% include JB/setup %}

### Dependencies

Using Maven to install other software requires you to: 

* Go to your root directory; e.g. nd4j or deeplearning4j.
* Make sure the [pom.xml files](https://maven.apache.org/pom.html) within that directory and each major subdirectory are properly configured. 
* Add dependencies and other information to that POM file (see below).

For your POM, you need to specify two dependencies, which are detailed in the [Readme](https://github.com/SkymindIO/nd4j/blob/master/README.md).

The API, for one:

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-api</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>

You can copy all the dependencies from [one text file](../pomtext.txt), paste them into your POM, and simply comment them in or out.

ND4J-API is the core implementation that handles most of the interop. You'll also need to specify a backend dependency. 

ND4J supports several backends, ranging from Cuda to different native implementations. While there are several Blas implementations on the JVM, none of them support a Matlab/Numpy-like interface, so we had to make one. 

See our [downloads](http://nd4j.org/downloads.html) page for a more thorough explanation on the backends available.
    
### Jblas

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-jblas</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>
  
### Netlib Blas
 
	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-api</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>

### Jcublas (Cuda/GPUs)

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-jcublas</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>
