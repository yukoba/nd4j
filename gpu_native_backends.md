---
title: 
layout: default
---

# Swapping GPU and Native Backends

To select between GPUs and native CPUs for your backend processing, you'll need to change the dependencies in ND4J's POM file. Your selection will affect both ND4J and, if you're using it, [Deeplearning4j](http://deeplearning4j.org/).

Every project in Maven needs a Project Object Model, or POM, in the root directory. It's an XML file with information and configuration details that Maven uses to build the project.

After you include this API dependency in your pom.xml

        <dependency>
         <groupId>org.nd4j</groupId>
         <artifactId>nd4j-api</artifactId>
         <version>0.0.3.5.5.1</version>
        </dependency>

You'll need to choose between Jblas for native or Jcuda (using CUDA for GPUs).

__Jblas__:

        <dependency>
           <groupId>org.nd4j</groupId>
           <artifactId>nd4j-jblas</artifactId>
           <version>0.0.3.5.5.1</version>
        </dependency>

The current version of __Jcuda__ requires you to specify your ```html 
<font color="red">OS</font> ``` and CUDA version (supporting versions 5.5, 6.0 and 6.5). For example, if you are runnin in Windows 64 and have CUDA v6.0 installed, you need to define the _artifactId_ as:

        <dependency>
         <groupId>org.nd4j</groupId>
         <artifactId>nd4j-jcublas-windows64-6.0</artifactId>
         <version>0.0.3.5.5.1</version>
        </dependency>

You can replace the _artifactId_ depending to your preference:

|                                 | CUDA v5.5                  | CUDA v6.0                  | CUDA v6.5                  |
| ------------------------------- |:--------------------------:| --------------------------:|---------------------------:|
| Linux 32 and 64, and Windows 32 | nd4j-jcublas-5.5           | nd4j-jcublas-6.0           | nd4j-jcublas-6.5           |
| Windows 64                      | nd4j-jcublas-windows64-5.5 | nd4j-jcublas-windows64-6.0 | nd4j-jcublas-windows64-6.5 |
| OSX                             | _not supported_            | nd4j-jcublas-osx-6.0       | nd4j-jcublas-osx-6.5       |

And that's it. Switching to GPUs means typing two additional letters in your POM.
