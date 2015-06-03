---
layout: page
title: "ND4J Backends: What They Are, How They Work"
description: "Linear Algebra Backends"
---
{% include JB/setup %}

ND4J works atop so-called backends, or linear-algebra libraries, such as Jblas, Netlib Blas and Jcublas (GPUs), which you can select by pasting the [right dependency into your project's POM.xml file](http://nd4j.org/dependencies.html). 

A Java [ServiceLoader](https://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html), which is baked into the language itself, tells Java that the backend exists. It's not necessary to concern yourself with how ND4J backends load and perform other basic functions, but you can explore [how ND4J loads and selects backends, according to your OS, here](https://github.com/deeplearning4j/nd4j/blob/master/nd4j-api/src/main/java/org/nd4j/linalg/factory/Nd4jBackend.java).

The core configurations for each backend on in a properties file. Using Jblas as an example, this post will quickly explain each line in the [nd4j.properties file here](https://github.com/deeplearning4j/nd4j/blob/master/nd4j-jblas/src/main/resources/nd4j-jblas.properties).

<script src="http://gist-it.appspot.com/https://github.com/deeplearning4j/nd4j/blob/master/nd4j-jblas/src/main/resources/nd4j-jblas.properties?slice=18:35"></script>


![Alt text](../img/IMAGE_NAME.png)
