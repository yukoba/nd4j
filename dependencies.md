---
layout: page
title: "Dependencies"
description: "Dependencies - How to change backends"
---
{% include JB/setup %}

First, you will need to choose the right dependency for your chips:

![Alt text](../img/backend_table.png) 

## Configuring the POM.xml file

Maven can automatically install the required dependencies once we select one of these backends:

* [Netlib Blas](http://netlib.org/) (and x86)
* [JCUBLAS](gpu_native_backends.html) (for GPUs)
* ND4J-Java 
* JOCL 
 
Go to your root directory -- e.g. nd4j or deeplearning4j -- and inspect the [pom.xml file](https://maven.apache.org/pom.html). You should see one backend defined in the `<dependencies> ... </dependencies>` section. You can switch among:

### x86

        <dependency>
            <groupId>org.nd4j</groupId>
            <artifactId>nd4j-x86</artifactId>
            <version>${nd4j.version}</version>
        </dependency>

### Jblas

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-jblas</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>
  
### [Netlib Blas](http://netlib.org/)
 
	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-netlib-blas</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>

### Jcublas (Cuda/GPUs)

See our [GPU page](gpu_native_backends.html) for the versions you can choose.

### JOCL

JOCL is a WIP. Please see the [source code here](https://github.com/deeplearning4j/nd4j/tree/master/nd4j-jocl-parent).

## Finding and specifying the latest version of the libraries (Advanced)

They can be found on: [search.maven.org](http://search.maven.org/#search%7Cga%7C1%7Cnd4j-jblas). Click on the "latest version" on this screen. From there, you want to copy the dependency information:

![Alt text](../img/nd4j_maven.png)

And paste it into the "dependencies" section of your pom.xml, which should end up looking like this in IntelliJ:

![Alt text](../img/nd4j_pom_after.png) 
