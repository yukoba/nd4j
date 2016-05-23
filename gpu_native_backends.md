---
layout: page
title: 
description: "GPU - Compatibility for NVIDIA CUDA BLAS, CUBLAS through JCUBLAS"
---

# JCublas Backend for GPUs


You can choose GPUs or native CPUs for your backend linear algebra operations by changing the dependencies in ND4J's POM.xml file. Your selection will affect both ND4J and [Deeplearning4j](http://deeplearning4j.org/). Check our [dependencies page](dependencies.html) for instructions on configuring your POM.xml file.

The current version of __Jcuda__ supports the CUDA versions 5.5, 6.0, 6.5 and 7, and requires you to specify which one you have. For example, if you have CUDA v6.0 installed, then you need to define the _artifactId_ like this:

        <dependency>
         <groupId>org.nd4j</groupId>
         <artifactId>nd4j-cuda-7.5</artifactId>
         <version>${nd4j.version}</version>
        </dependency>

You can replace the `<artifactId> ... </artifactId>`, depending on your preference:

                nd4j-cuda-$CUDA_VERSION (where CUDA_VERSION is one of 7.5)

That's it. 

Check the NVIDIA guides for instructions on setting up CUDA on  [Linux](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-linux/), [Windows](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-microsoft-windows/), and [OSX](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-mac-os-x/).
