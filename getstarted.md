---
layout: page
title: "Getting Started"
description: ""
---
{% include JB/setup %}

ND4J requires [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

If you're using [Maven](http://search.maven.org/#search%7Cga%7C1%7Cnd4j), a build automation tool used for Java projects, you need to specify two dependencies. The API, like so:
                
                 <dependency>
                   <groupId>org.nd4j</groupId>
                   <artifactId>nd4j-api</artifactId>
                   <version>${nd4j.version}</version>
                 </dependency>
             
This is the core implementation that handles most of the interop.

You'll also need to specify a backend dependency. 

ND4J supports several backends, ranging from Cuda to different native implementations. While there are several Blas implementations on the JVM, none of them support a Matlab/Numpy-like interface. See our [downloads](http://nd4j.org/downloads.html) page for a more thorough explanation on the backends available.
    
## Jblas

                 <dependency>
                   <groupId>org.nd4j</groupId>
                   <artifactId>nd4j-jblas</artifactId>
                   <version>${nd4j.version}</version>
                 </dependency>
  
## Net lib Blas:
 
                 <dependency>
                   <groupId>org.nd4j</groupId>
                   <artifactId>nd4j-api</artifactId>
                   <version>${nd4j.version}</version>
                 </dependency>
      
## Jcublas (Cuda/GPUs):
     
                 <dependency>
                   <groupId>org.nd4j</groupId>
                   <artifactId>nd4j-jcublas</artifactId>
                   <version>${nd4j.version}</version>
                 </dependency>

##Bypassing Maven

See our [downloads](http://nd4j.org/downloads.html) page.

You can then manually import the jar files in to [Eclipse](http://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse) or [Intellij](http://stackoverflow.com/questions/1051640/correct-way-to-add-lib-jar-to-an-intellij-idea-project), [Netbeans](http://gpraveenkumar.wordpress.com/2009/06/17/abc-to-import-a-jar-file-in-netbeans-6-5/).

###Working with source

If you want to develop for ND4J, just git clone the software and use Maven as follows:

                 mvn clean install -DskipTests -Dmaven.javadoc.skip=true

**NEXT STEP**: Now you're ready to run the examples cited in our [documentation](../elementwise.html).

Here's our [Github repo](https://github.com/SkymindIO/nd4j), or you can access the core through [Maven](http://maven.apache.org/download.cgi).
