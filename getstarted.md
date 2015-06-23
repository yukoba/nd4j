---
layout: page
title: "Get started with ND4J in Minutes"
description: "Follow our video and install a Java development environment ready for N-Dimensional Array Algebra with ND4J"
---
{% include JB/setup %}

To get started with ND4J and DL4J, please read the following:

1. [Prerequisites](#prereq) 
3. [Integrated Development Environment](#ide) 
4. [Github](#github)(Optional)
5. [Next Steps](#next-steps)

## <a id="prereq"> Prerequisites </a>

System configuation requirements:

* [Java 7](#java) 
* [Scala 2.10.4](#scala)
* [Maven 3.2.5](#maven)
* [Canova 0.0.0.2](#canova)

Distributed systems using Spark requirements: 

* [Spark 1.3.0](https://spark.apache.org/downloads.html) _(package type = Pre-built for Hadoop 1.X)_

GPU(s) requirements:

* [Cuda 7](http://docs.nvidia.com/cuda/index.html#axzz3dlfIdQjP)

## <a id="java">Java 7</a>

Java is the main interface and networking language of ND4J, because it's used for everything from distributed cloud-based systems with thousands of nodes, to low-memory IoT devices. It's a "write once, run anywhere" language.

To test which version of Java you have (and whether you have it at all), type the following into your command line:

		java -version

ND4J and DL4J require **Java 7**, so if you have an older or newer version, please reinstall.

If you don't have Java 7 installed on your machine, download the [Java Development Kit (JDK) here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). The download will vary by operating system. For newer Macs, you'll want the file on the first line to mention Mac OS X (the number after *jdk-7u* increments with each update). It will look something like this:

		Mac OS X x64 185.94 MB -  jdk-7u79-macosx-x75.dmg

## <a id="scala">Scala</a>

You can work with ND4J via a [Scala API](http://nd4j.org/scala.html). Scala is a multiparadigm language with a strong static type system that runs on the JVM. As such, Scala has functional programming features similar to Scheme and Haskell as well as OOP features like Java, and its structure keeps programs concise. You can use Java libraries with Scala. There are neural net examples you can run written in Scala, and it's required for the Spark implementation.

To test which version of Scala you have (and whether you have it at all), type the following into your command line:

		scala -version

To install Scala, please visit the [Scala download page](http://www.scala-lang.org/download/2.10.4.html).

## <a id="maven">Maven</a>

Maven is an automated build tool for Java projects (among its other [uses](http://maven.apache.org/what-is-maven.html)). It locates the latest version of ND4J and DL4J project libraries (.jar files) and downloads them automatically. 

We've written a slightly more in-depth [introduction to Maven for non-Java programmers](http://deeplearning4j.org/maven.html) here. Maven lets you to install both ND4J and Deeplearning4j projects easily. It works well with Integrated Development Environments (IDEs) such as IntelliJ.

To check if Maven is installed in your machine, enter the following into the command line:

		mvn --version

Instructions to install Maven are [here](https://maven.apache.org/download.cgi). Download the compressed file containing Maven's latest stable version. 

![Alt text](../img/maven_downloads.png) 

Lower on the same page, follow the instructions specific to your operating system; e.g. *"Unix-based Operating Systems (Linux, Solaris and Mac OS X)."* They look like this:

![Alt text](../img/maven_OS_instructions.png) 

## <a id="ide">Integrated Development Environment: IntelliJ</a>

An Integrated Development Environment ([IDE](http://encyclopedia.thefreedictionary.com/integrated+development+environment)) will allow you to work with our API and build your nets with a few clicks. We suggest using **IntelliJ**, which works with your installed version of Java and communicates with [Maven](#maven) to handle the dependencies. 

The free community edition of [IntelliJ](https://www.jetbrains.com/idea/download/) has installation instructions. While we prefer that, [Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html) and [Netbeans](http://wiki.netbeans.org/MavenBestPractices) are two other popular IDEs. 

## Starting a New ND4J Project

To create a new ND4J project within IntelliJ, just put the right dependencies in your project's POM.xml file. With those in place, Maven will be able to build ND4J for you. Pasting the right dependencies into your POM amounts to installing ND4J -- no other install is necessary!

Select `maven-archetype-quickstart`. 

![Alt text](../img/new_maven_project.png) 

The images below will walk you through the windows of the IntelliJ New Project Wizard using Maven. First, name your group and artifact. If you're building a deeplearning4j project, you'll want org.deeplearning4j in the GroupID slot; if the project is simply for ND4J, you'll want org.nd4j, and so on. The artifact can be any name you choose.

![Alt text](../img/maven2.png) 

Click through the following screen with "Next", and on the screen after that, name your project ("ND4J-test", for example) and hit finish. Now go into your POM.xml file within the root of the new ND4J project in IntelliJ. 

Update the POM file with the dependences you'll need. These will vary depending on whether you're running on CPUs or GPUs. 

The default backend for CPUs is ([Jblas](http://en.wikipedia.org/wiki/Jblas:_Linear_Algebra_for_Java)). You can paste that into  the `<dependencies> ... </dependencies>` section of your POM like this:

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-jblas</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>
	 
If you do this, Maven will automatically install the required libraries and you should be able to run ND4J.

ND4J's version is a variable here. It will refer to another line higher in the POM, in the <properties> ... </properties> section, specifying the nd4j version and appearing similar to this:

		<nd4j.version>0.0.3.5.5.3</nd4j.version>

The number of the version will vary as we progress with new releases. Make sure you check the latest version available on Maven Central. The backend does not have to be Jblas; it can be switched to Netlib Blas, or to Jcublas for GPUs. That's explained on our [dependencies](../dependencies.html) page, alongside more advanced configuration changes. The same page also explains how to check on the [latest version](http://search.maven.org/#search%7Cga%7C1%7Cnd4j) of the libraries.

Open App.java file that is created with every new Intellij project, and start writing code between the curly brackets you see after **public static void main( String[] args )**. 

Many of the classes will appear in red, since you haven't imported the right packages, but IntelliJ will add those packages automatically to the top of your file. Lookup the appropriate hot keys based on your OS to help automatically load the packages. 

You can now create a new Java file within IntelliJ, and start using ND4J's API for distributed linear algebra. (See our [intro](http://nd4j.org/introduction.html) for a couple beginning operations. ND4J in IntelliJ has **autocomplete**, so starting a new line with any letter will show you a list of all ND4J commands including that letter.) 

## <a id="canova">Canova</a>

[Canova](https://github.com/deeplearning4j/Canova) is a general vectorization lib we built for machine-learning tools. It vectorizes raw data into usable vector formats like svmLight, libsvm and ARFF, which our neural nets can work with.

### Installing Canova

Take the same steps to install [Canova](http://search.maven.org/#search%7Cga%7C1%7Ccanova-parent) using Maven that you followed for ND4J. 

### Installing Deeplearning4j

Deeplearning4j versions should be specified in the same way you did for ND4J, which the version in properties and the variable in the dependencies. 

The DL4J dependencies you add to the POM will vary with the nature of your project. In addition to the core dependency, given below, you may also want to install deeplearning4j-cli for the command-line interface, deeplearning4j-scaleout for running parallel on Hadoop or Spark, and others as needed... A full list will come up by searching for *deeplearning4j* on Maven Central.

		   <dependency>
		     <groupId>org.deeplearning4j</groupId>
		     <artifactId>deeplearning4j-core</artifactId>
		     <version>${deeplearning4j.version}</version>
		   </dependency>

More information on installing Deeplearning4j is available on its [Getting Started page](http://deeplearning4j.org/gettingstarted.html).

## <a id="github">GitHub (Optional)</a>

[Github](http://en.wikipedia.org/wiki/GitHub) is a web-based [Revision Control System](http://en.wikipedia.org/wiki/Revision_control), _the [de facto host](http://opensource.com/life/12/11/code-hosting-comparison) for open source projects_.

**You are not required to install GitHub**. If you're planning to contribute to the ND4J or [DeepLearning4J](https://github.com/SkymindIO/deeplearning4j) projects by fixing bugs and committing code, you will need git and GitHub. (Thanks in advance btw :)

### Installing Git &/or GitHub (Optional)

Type the following into your command line to verify you have git.

		git --version 

Just check the list of applications installed on your computer for GitHub.

To use GitHub, first install [git](https://git-scm.herokuapp.com/book/en/v2/Getting-Started-Installing-Git) if you do not have it already. Then setup a [Github account](https://github.com/join). Download GitHub for [Mac](https://mac.github.com/), [Windows](https://windows.github.com/), etc. Once installed, clone ND4J or DL4J, enter this command into your terminal (Mac) or Git Shell (Windows):

      git clone https://github.com/SkymindIO/nd4j
      git clone https://github.com/SkymindIO/deeplearning4j
      
You might also want to clone our examples so you can mess around with ND4J or DL4J's pre-built samples:
      
      git clone https://github.com/SkymindIO/nd4j-examples
      git clone https://github.com/SkymindIO/dl4j-examples
      
Another way to get the source code is by clicking on the "[download ZIP](https://github.com/SkymindIO/nd4j/archive/master.zip)" button from the [ND4J GitHub page](https://github.com/SkymindIO/nd4j). Then unzip the file (you can use [7-zip](http://www.7-zip.org/download.html) to do that).

Maven can be used in conjunction with Git to ensure that ND4J, Canova and Deeplearning4j build correctly. To make sure you have the most recent, working version of these libraries, you can *cd* into their root directories and enter the following command into your prompt:

		mvn clean install -DskipTests -Dmaven.javadoc.skip=true

Running a clean install on ND4J, Canova and Deeplearning4j, in that order, is a good way to get the most recent bug fixes and features. 

## <a id="next-steps">Next Steps</a>

Now you're ready to run the [examples](introduction.html). We recommend that you launch your IDE, load the ND4J project and open the examples subdirectory. Locate an example in the file tree on the lefthand side of the IntelliJ window, right click on it, and select the green arrow for "Run" on the drop-down menu. 

If everything was installed correctly, you should see numbers appear as the program output at the bottom of the IntelliJ window. Please use these as a sandbox to start experimenting.  

Once you're comfortable with the examples, you might want to change the dependencies defined in the POM files. Learn how to change the [dependencies here](gpu_native_backends.html).

For questions or feedback, join us on our [Google Groups Forum](https://groups.google.com/forum/#!forum/nd4j).

## Useful links

* [ND4J Github repository](https://github.com/deeplearning4j/nd4j)
* [ND4J Maven Repository](http://mvnrepository.com/artifact/org.nd4j)
* [DeepLearning4j.org](http://deeplearning4j.org/)
* [DeepLearning4j Github repository](https://github.com/deeplearning4j/deeplearning4j)
* [DeepLearning4j Maven Repository](http://mvnrepository.com/artifact/org.deeplearning4j)
