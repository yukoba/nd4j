---
layout: page
title: "ND4J: N-Dimensional Arrays for Java"
tagline: "ND4J is a library for N-Dimensional Array Algebra designed for production environments"
---
{% include JB/setup %}

ND4J and ND4S are scientific computing libraries for the JVM. They are meant to be used in production environments, which means routines are designed to run fast with minimum RAM requirements. 

**Main features**

* Versatile **n-dimensional array** object
* Multiplatform functionality including GPUs
* Linear algebra and signal processing functions

A usability gap has separated Java, [Scala](http://nd4j.org/scala.html) and [Clojure](https://github.com/whilo/clj-nd4j) programmers from the most powerful tools in data analysis, like NumPy or Matlab. Libraries like Breeze don't support n-dimensional arrays, or tensors, which are necessary for deep learning and other tasks. ND4J and ND4S are used by national laboratories for tasks such as climatic modeling, which require computationally intensive simulations.  

ND4J brings the intuitive scientific computing tools of the Python community to the JVM in an open source, distributed and GPU-enabled library. In structure, it is similar to [SLF4J](http://www.slf4j.org/). ND4J gives engineers in production environments an easy way to port their algorithms and interface with other libraries in the Java and Scala ecosystems. 

[Click here to get started](getstarted.html), or read on. 

### ND4J/ND4S Specifics

* Supports GPUs via CUDA and Native via Jblas and Netlib Blas.
* Deploys on Android.
* Integrates with Hadoop and Spark.
* [ND4S's API](https://github.com/deeplearning4j/nd4s) mimics the semantics of Numpy.

### Code Example

Create a 2 x 2 NDarray:

    INDArray arr1 = Nd4j.create(new float[]{1,2,3,4},new int[]{2,2});
    System.out.println(arr1);

Output:

    [[1.0 ,3.0]
    [2.0 ,4.0]
    ]

Adding a scalar with in-place operations:

    arr1.addi(1);
    System.out.println(arr1);

Each element is incremented by one:

    [[2.0 ,4.0]
    [3.0 ,5.0]
    ]

Create a second array (_arr2_) and adding it to the first (_arr1_):

    INDArray arr2 = ND4j.create(new float[]{5,6,7,8},new int[]{2,2});
    arr1.addi(arr2);
    System.out.println(arr1);

Output:

    [[7.0 ,11.0]
    [9.0 ,13.0]
    ]

You get the idea. [Now get started](getstarted.html).
