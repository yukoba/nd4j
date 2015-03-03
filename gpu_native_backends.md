---
layout: page
title: 
description: "GPU - Compatibility for NVIDIA CUDA BLAS, CUBLAS through JCUBLAS"
---

# The JCublas backend (for GPUs) 

You can choose GPUs or native CPUs for your backend processing by changing the dependencies in ND4J's POM.xml file. Your selection will affect both ND4J and, if you're using it, [Deeplearning4j](http://deeplearning4j.org/).

Check our [dependencies page](dependencies.html) for instructions on configuring your POM.xml file.

The current version of __Jcuda__ requires you to specify your <font color="#00CC00">CUDA version</font> (supporting versions 5.5, 6.0 and 6.5). For example, if you have <font color="#00CC00">CUDA v6.0</font> installed, then you need to define the _artifactId_ as:

        <dependency>
         <groupId>org.nd4j</groupId>
         <artifactId>nd4j-jcublas-6.0</artifactId>
         <version>${nd4j.version}</version>
        </dependency>

You can replace the `<artifactId> ... </artifactId>`, depending on your preference:

nd4j-jcublas-$CUDA_VERSION (where CUDA_VERSION is one of 5.5, 6.0, or 6.5)

That's it. Switching to GPUs means changing one line in your POM.xml file.

Check the NVIDIA guides for instructions on setting up CUDA on  [Linux](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-linux/), [Windows](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-microsoft-windows/), and [OSX](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-mac-os-x/).
