---
title: 
layout: default
---

# Swapping GPU and Native Backends

To select between GPUs and native CPUs for your backend processing, you'll need to change the dependencies in ND4J's POM file. Your selection will affect both ND4J and, if you're using it, [Deeplearning4j](http://deeplearning4j.org/).

Every project in Maven needs a Project Object Model, or POM, in the root directory. It's an XML file with information and configuration details that Maven uses to build the project.

After you include this API dependency in your pom.xml

        <dependency>
         <artifactId>nd4j</artifactId>
         <groupId>org.nd4j</groupId>
         <artifactId>nd4j-api</artifactId>
         <version>0.0.3.5.2</version>
        </dependency>

You'll need to choose between Jblas for native or Cuda for GPUs.

Jblas:

        <dependency>
           <artifactId>nd4j</artifactId>
           <groupId>org.nd4j</groupId>
           <artifactId>nd4j-jblas</artifactId>
           <version>0.0.3.5.2</version>
        </dependency>

Jcuda:

        <dependency>
         <artifactId>nd4j</artifactId>
         <groupId>org.nd4j</groupId>
         <artifactId>nd4j-jcublas</artifactId>
         <version>0.0.3.5.2</version>
        </dependency>

And that's it. Switching to GPUs means typing two additional letters in your POM.
