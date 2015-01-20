---
title: 
layout: default
---

# Swapping of JCublas (GPU) backend

To select between GPUs and native CPUs for your backend processing, you'll need to change the dependencies in ND4J's POM file. Your selection will affect both ND4J and, if you're using it, [Deeplearning4j](http://deeplearning4j.org/).

Check our [dependencies page](dependencies.html) for instructions about how to find and configure the POM file.

The current version of __Jcuda__ requires you to specify your <font color="#FF6600">OS</font> and <font color="#00CC00">CUDA version</font> (supporting versions 5.5, 6.0 and 6.5). For example, if you're running on <font color="#FF6600">Windows-64</font> and have <font color="#00CC00">CUDA v6.0</font> installed, then you need to define the _artifactId_ as:

        <dependency>
         <groupId>org.nd4j</groupId>
         <artifactId>nd4j-jcublas-windows64-6.0</artifactId>
         <version>${nd4j.version}</version>
        </dependency>

You can replace the `<artifactId> ... </artifactId>`, depending on your preference:

|                                 | <font color="#00CC00">CUDA v5.5</font>                  | <font color="#00CC00">CUDA v6.0</font>                  | <font color="#00CC00">CUDA v6.5</font>                  |
| ------------------------------- |:--------------------------:| --------------------------:|---------------------------:|
| <font color="#FF6600">Linux 32 and 64, and Windows 32</font> | nd4j-jcublas-<font color="#00CC00">5.5</font>           | nd4j-jcublas-<font color="#00CC00">6.0</font>           | nd4j-jcublas-<font color="#00CC00">6.5</font>           |
| <font color="#FF6600">Windows 64</font>                      | nd4j-jcublas-<font color="#FF6600">windows64</font>-<font color="#00CC00">5.5</font> | nd4j-jcublas-<font color="#FF6600">windows64</font>-<font color="#00CC00">6.0</font> | nd4j-jcublas-<font color="#FF6600">windows64</font>-<font color="#00CC00">6.5</font> |
| <font color="#FF6600">OSX</font>                             | _not supported_            | nd4j-jcublas-<font color="#FF6600">osx</font>-<font color="#00CC00">6.0</font>       | nd4j-jcublas-<font color="#FF6600">osx</font>-<font color="#00CC00">6.5</font>       |

And that's it. Switching to GPUs means typing two additional letters in your POM.
