---
layout: page
title: "Getting Started"
description: ""
---
{% include JB/setup %}

### How to configure the POM file

Maven is able to automatically install the required dependencies, which in our case will be the ND4J-API, and the JBLAS backend (that you can switch to Netlib Blas or [JCUBLAS](gpu_native_backends.html) for GPUs). Go to your root directory; e.g. nd4j or deeplearning4j and take a look at the [pom.xml file](https://maven.apache.org/pom.html). It should look like this:

![Alt text](../img/nd4j_pom_before.png) 

You will need to add dependencies within the `<dependencies> ... </dependincies>` section. You will find all three by searching for them on: <a href="http://search.maven.org/#search%7Cga%7C1%7Cnd4j-jblas">search.maven.org</a>. Click on the "latest version" on this screen. From there, you want to copy the dependency information:

![Alt text](../img/nd4j_maven.png)

And paste it into the "dependencies" section of your pom.xml, which should end up looking like this in IntelliJ:

![Alt text](../img/nd4j_pom_after.png) 

For your POM, you need to specify two dependencies, which are detailed in the [Readme](https://github.com/SkymindIO/nd4j/blob/master/README.md).

The API, for one:

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-api</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>

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
