---
layout: page
title: "Getting Started"
description: ""
---
{% include JB/setup %}

* ND4J requires [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).


If you are using maven, you need to specify 2 dependencies. One is the api:
                
                 <dependency>
                   <groupId>org.nd4j</groupId>
                   <artifactId>nd4j-api</artifactId>
                   <version>${nd4j.version}</version>
               </dependency>
             
  This is the core implementation that handles most of the interop of the different implementations.
  
  You then need one of the backends.  Nd4j supports several backends which range from cuda to different native implementations. The reason for this is that while there are several different blas implementations on the jvm, none of them support a matlab/numpy like interface. Either that or they are in pure java (which for more computational applications can cause problems) See the [downloads](http://nd4j.org/downloads.html) page for more of an explanation on available backends.
  
 The available backends right now are:
    
    Jblas: 
    
               <dependency>
                   <groupId>org.nd4j</groupId>
                   <artifactId>nd4j-jblas</artifactId>
                   <version>${nd4j.version}</version>
               </dependency>
  
     Net lib blas:
      
      
              <dependency>
                   <groupId>org.nd4j</groupId>
                   <artifactId>nd4j-api</artifactId>
                   <version>${nd4j.version}</version>
               </dependency>
      
     Jcublas (cuda/GPUs):
     
     
             <dependency>
                   <groupId>org.nd4j</groupId>
                   <artifactId>nd4j-jcublas</artifactId>
                   <version>${nd4j.version}</version>
               </dependency>
  
  

##Not Maven

See our [http://nd4j.org/downloads.html](downloads) page.

You can then manually import the jar files in to [eclipse](http://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse) or [intellij](http://stackoverflow.com/questions/1051640/correct-way-to-add-lib-jar-to-an-intellij-idea-project), [netbeans](http://gpraveenkumar.wordpress.com/2009/06/17/abc-to-import-a-jar-file-in-netbeans-6-5/).



###Working with the source

If you want to develop for nd4j, git clone the software and use maven as follows:

mvn clean install -DskipTests -Dmaven.javadoc.skip=true


**NEXT STEP**: Now you're ready to run the examples cited in our [documentation](../elementwise.html).

Here's our [Github repo](https://github.com/SkymindIO/nd4j), or you can access the core through [Maven](http://maven.apache.org/download.cgi).
