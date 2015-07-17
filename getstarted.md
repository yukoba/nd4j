---
layout: page
title: "Get started with ND4J in Minutes"
description: "Install a Java development environment ready for N-Dimensional Array Algebra with ND4J"
---
{% include JB/setup %}

This is a multistep install. We highly recommend you join our [Gitter Live Chat](https://gitter.im/deeplearning4j/deeplearning4j) if you have questions or feedback, so we can walk you through it. If you're feeling anti-social or brashly independent, you're still welcome to lurk and learn. 

To get started with ND4J and DL4J, please read the following:

1. [Prerequisites](#prereq) 
3. [Integrated Development Environment](#ide) 
4. [Github](#github) 
5. [Dev Tools](#devtools)
5. [Next Steps](#next-steps)

## <a id="prereq"> Prerequisites </a>

System configuration requirements:

* [Java 7 or above](#java) 
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

The images below will walk you through the windows of the IntelliJ New Project Wizard using Maven. First, name your group and artifact as you please.

![Alt text](../img/maven2.png) 

Click through the following screen with "Next", and on the screen after that, name your project ("ND4J-test", for example) and hit finish. Now go into your POM.xml file within the root of the new ND4J project in IntelliJ. 

Update the POM file with the dependences you'll need. These will vary depending on whether you're running on CPUs or GPUs. 

The default backend for CPUs is ([Jblas](http://en.wikipedia.org/wiki/Jblas:_Linear_Algebra_for_Java)). You can paste that into  the `<dependencies> ... </dependencies>` section of your POM like this:

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-jblas</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>

ND4J's version is a variable here. It will refer to another line higher in the POM, in the `<properties> ... </properties>` section, specifying the nd4j version and appearing similar to this:

		<nd4j.version>0.0.3.5.5.3</nd4j.version>

The number of the version will vary as we progress with new releases. Make sure you check the latest version available on Maven Central. If you paste in the right dependency and nd4j version, Maven will automatically install the required libraries and you should be able to run ND4J.

The backend does not have to be Jblas; it can be switched to Netlib Blas, or to Jcublas for GPUs. That's explained on our [dependencies](../dependencies.html) page, alongside more advanced configuration changes. The same page also explains how to check on the [latest version](http://search.maven.org/#search%7Cga%7C1%7Cnd4j) of the libraries.

You can now create a new Java file within IntelliJ, and start using ND4J's API for distributed linear algebra. 

Open App.java file that is created with every new Intellij project, and start writing code between the curly brackets you see after **public static void main( String[] args )**. 

Many of the classes will appear in red, since you haven't imported the right packages, but IntelliJ will add those packages automatically to the top of your file. Lookup the appropriate hot keys based on your OS to help automatically load the packages. 

(See our [intro](http://nd4j.org/introduction.html) for a couple beginning operations. ND4J in IntelliJ has **autocomplete**, so starting a new line with any letter will show you a list of all ND4J commands including that letter.) 

## <a id="canova">Canova</a>

[Canova](https://github.com/deeplearning4j/Canova) is a general vectorization lib we built for machine-learning tools. It vectorizes raw data into usable vector formats like *svmLight*, *libsvm* and *ARFF*, which our neural nets can work with.

### Installing Canova

Take the same steps using Maven to install [Canova](http://search.maven.org/#search%7Cga%7C1%7Ccanova-parent) that you followed for ND4J. 

### Installing Deeplearning4j

Deeplearning4j versions should be specified in the same way you did for ND4J, with the version hard-coded in the properties section of the POM, and the version variable cited in each dependency. 

The DL4J dependencies you add to the POM will vary with the nature of your project. 

In addition to the core dependency, given below, you may also want to install deeplearning4j-cli for the command-line interface, deeplearning4j-scaleout for running parallel on Hadoop or Spark, and others as needed. A full list can be seen by searching for *deeplearning4j* on Maven Central.

		   <dependency>
		     <groupId>org.deeplearning4j</groupId>
		     <artifactId>deeplearning4j-core</artifactId>
		     <version>${deeplearning4j.version}</version>
		   </dependency>

More information on installing Deeplearning4j is available on its [Getting Started page](http://deeplearning4j.org/gettingstarted.html).

## <a id="github">GitHub</a>

[Github](http://en.wikipedia.org/wiki/GitHub) is a web-based [Revision Control System](http://en.wikipedia.org/wiki/Revision_control), _the [de facto host](http://opensource.com/life/12/11/code-hosting-comparison) for open source projects_.

If you're planning to contribute to the ND4J or [DeepLearning4J](https://github.com/deeplearning4j/deeplearning4j) projects by fixing bugs and committing code, you will need git and GitHub. (Thanks in advance btw :)

Type the following into your command line to verify you have git.

		git --version 

Just check the list of applications installed on your computer for GitHub.

Install [git](https://git-scm.herokuapp.com/book/en/v2/Getting-Started-Installing-Git) if you do not have it already. Then setup a [Github account](https://github.com/join). Download GitHub for [Mac](https://mac.github.com/), [Windows](https://windows.github.com/), etc. Once installed, clone ND4J or DL4J, enter this command into your console:

    git clone https://github.com/deeplearning4j/nd4j
    git clone https://github.com/deeplearning4j/Canova
    git clone https://github.com/deeplearning4j/deeplearning4j

You might also want to clone our examples so you can mess around with ND4J or DL4J's pre-built samples (the version will vary):

    git clone https://github.com/deeplearning4j/dl4j-0.0.3.3-examples

Another way to get the source code is by clicking on the "[download ZIP](https://github.com/deeplearning4j/nd4j/archive/master.zip)" button from the [ND4J GitHub page](https://github.com/deeplearning4j/nd4j). Then unzip the file (you can use [7-zip](http://www.7-zip.org/download.html) to do that).

Maven can be used in conjunction with Git to ensure that ND4J, Canova and Deeplearning4j build correctly. To make sure you have the most recent, working version of these libraries, you can *cd* into their root directories and enter the following command into your prompt:

		mvn clean install -DskipTests -Dmaven.javadoc.skip=true

Running a clean install on ND4J, Canova and Deeplearning4j, in that order, is a good way to get the most recent bug fixes and features. 

## <a id="devtools">Dev Tools for C on OSX, Windows & Linux</a>

To compile certain ND4J dependencies on Windows or a Linux OS, you will need to install some dev tools for C, including gcc. To check if you have *gcc*, enter *gcc -v* on your terminal or command prompt.

###OSX

Some versions of the [Apple developer tool Xcode](https://developer.apple.com/xcode/downloads/) will install *gcc* for you. If you don't already have gcc, enter *brew install gcc* into your command prompt.

###Windows

Windows users may need to install [Visual Studio Community 2013](https://www.visualstudio.com/en-us/products/visual-studio-community-vs.aspx), which is free. You will need to add its path to your PATH environment variable manually. The path will look something like this: *C:\Program Files (x86)\Microsoft Visual Studio 12.0\VC\bin*

Type "cl" into your CMD. You may get a message informing you that certain .dll files are missing. Make sure that your VS/IDE folder is in the path (see above). If your CMD returns usage info for "cl", then it's in the right place. 

(*In addition, the include path for [Java CPP](https://github.com/bytedeco/javacpp) doesn't always work on Windows. One workaround is to take the the header files from the include directory of Visual Studio, and put them in the include directory of the Java Run-Time Environment (JRE), where Java is installed. This will affect files such as standardio.h.*)

###Linux

With Linux, Ubuntu and Centos users will need to follow two separate sets of instructions:

###Ubuntu

For Ubuntu, first type:

		sudo apt-get update

Then you'll need to run a version of this command:

		sudo apt-get install linux-headers-$(uname -r) build-essential

*$(uname -r)* will vary according to your Linux version. To get your Linux version, open a new window of your terminal and enter this command:

		uname -r

You will see something like this -- *3.2.0-23-generic*. Whatever you see, copy and paste it into the first line of script in place of *$(uname -r)*. Then insert one space and type *build-essential*. Watch out for typos. You can press tab to complete any command. 

###Centos

Enter the following in your terminal (or ssh session) as a root user:

		yum groupinstall 'Development Tools'

After that, you should see a lot of activity and installs on the terminal. To verify that you have, for example, *gcc*, enter this line:

		gcc --version

For more complete instructions, [go here](http://www.cyberciti.biz/faq/centos-linux-install-gcc-c-c-compiler/). 

## <a id="next">Next Steps</a>

Now you're ready to run the [examples](introduction.html). We recommend that you launch your IDE, load the ND4J project and open the examples subdirectory. Locate an example in the file tree on the lefthand side of the IntelliJ window, right click on it, and select the green arrow for "Run" on the drop-down menu. 

If everything was installed correctly, you should see numbers appear as the program output at the bottom of the IntelliJ window. Please use these as a sandbox to start experimenting.  

Once you're comfortable with the examples, you might want to change the dependencies defined in the POM files. Learn how to change the [dependencies here](gpu_native_backends.html).

## Useful links

* [ND4J Github repository](https://github.com/deeplearning4j/nd4j)
* [ND4J Maven Repository](http://mvnrepository.com/artifact/org.nd4j)
* [DeepLearning4j.org](http://deeplearning4j.org/)
* [DeepLearning4j Github repository](https://github.com/deeplearning4j/deeplearning4j)
* [DeepLearning4j Maven Repository](http://mvnrepository.com/artifact/org.deeplearning4j)
