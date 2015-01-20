---
layout: page
title: "Getting Started"
description: ""
---
{% include JB/setup %}

## How to configure the POM file

Maven is able to automatically install the required dependencies once we define the desired backend:

* JBLAS (default)
* [Netlib Blas](http://netlib.org/)
* [JCUBLAS](gpu_native_backends.html) (for GPUs compatibility)
 
Go to your root directory; e.g. nd4j or deeplearning4j and take a look at the [pom.xml file](https://maven.apache.org/pom.html). You should see one backend defined in the `<dependencies> ... </dependincies>` section. You can switch among:

### Jblas

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-jblas</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>
  
### Or [Netlib Blas](http://netlib.org/)
 
	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-api</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>

### Or Jcublas (Cuda/GPUs)

Go to our [GPU page](gpu_native_backends.htms) for that.




## How to find out and specify the latest version of the libraries (advanced)

You will find it by searching for them on: [search.maven.org](http://search.maven.org/#search%7Cga%7C1%7Cnd4j-jblas). Click on the "latest version" on this screen. From there, you want to copy the dependency information:

![Alt text](../img/nd4j_maven.png)

And paste it into the "dependencies" section of your pom.xml, which should end up looking like this in IntelliJ:

![Alt text](../img/nd4j_pom_after.png) 

