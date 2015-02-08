---
layout: page
title: "ND4J: N-Dimensional Arrays for Java"
tagline: "ND4J is a library for N-Dimensional Array Algebra designed for production environments"
---
{% include JB/setup %}

ND4J is a scientific computing library for the JVM. It is meant to be used in production environments rather than as a research tool, which means routines are designed to run fast with minimum RAM requirements.

**Main features**

* Versatile **n-dimensional array** object
* Multiplatform functionality including GPUs
* Linear algebra and signal processing functions

A usability gap has separated Java, Scala and Clojure programmers from the most powerful tools in data analysis, like [NumPy](http://www.numpy.org/) or [Matlab](http://www.mathworks.com/). With ND4J, intuitive scientific computing tools once limited to the Python community are now open source, distributed and integrated with GPUs on the JVM.

Think [SLF4J](http://www.slf4j.org/). Now imagine Numpy with [Theano](http://deeplearning.net/software/theano/) built in. That's ND4J. It gives engineers in production environments an easy way to port their algorithms and interface with other libraries in the Java and Scala ecosystems. 

##[Click here to get started](getstarted.html), or read on. 

### ND4J Specifics

* Supports GPUs via CUDA and Native via Jblas and Netlib Blas.
* All of this is wrapped in a unifying interface.
* The API mimics the semantics of Numpy, Matlab and scikit-learn.

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
