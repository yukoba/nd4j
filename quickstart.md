---
layout: page
title: "Quickstart: Run ND4J Examples in Minutes"
description: ""
---
{% include JB/setup %}

* First, test which version of Java you have (and whether you have it at all), by typing the following into the command line:

		java -version

* If you don't have Java 7 installed on your machine, download the [Java Development Kit (JDK) here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). The download will vary by operating system. For newer Macs, you'll want the file on the first line to mention Mac OS X (the number after *jdk-7u* increments with each update). It will look something like this:

		Mac OS X x64 185.94 MB -  jdk-7u67-macosx-x64.dmg

* Due to our reliance on Jblas for CPUs, native bindings for Blas are required.

		OSX
		Already Installed
		
		Fedora/RHEL
		yum -y install blas

		Ubuntu
		apt-get install libblas* (credit to @sujitpal)

		Windows
		See http://icl.cs.utk.edu/lapack-for-windows/lapack/

* Next, git clone the ND4J examples:

		git clone https://github.com/SkymindIO/nd4j-examples

You can then manually import the Maven project into an IDE such as  [Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html),  [Intellij](https://www.jetbrains.com/idea/help/importing-project-from-maven-model.html) or [Netbeans](http://wiki.netbeans.org/MavenBestPractices).

* Open up the nd4j-examples project in your IDE, find the ElementWiseOperationExample.java file and press run. 

By this point, you should have scientific computing for the JVM up and running. Congratulations. (If you haven't, please [let us know](https://groups.google.com/forum/#!forum/nd4j)!)

**NEXT STEP**: Once you've explored all our examples, you'll want to get the whole code base running by following the instructions on our [Getting Started page](../getstarted.html).
