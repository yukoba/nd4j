---
layout: page
title: "Get started with ND4J in Minutes"
description: "Follow our video and install a Java development environment ready for N-Dimensional Array Algebra with ND4J"
---
{% include JB/setup %}

<iframe width="750" height="560" src="//www.youtube.com/embed/aWQsQQoTm9Y" frameborder="0" allowfullscreen></iframe>

To use ND4J, you need to install a few things on your computer:

1. [Java](#java) 
2. [Integrated Development Environment](#ide-for-java) 
3. [Maven](#maven)
4. [Github](#github)
5. [Next Steps](#next-steps)

This tutorial will show you how to perform your own calculations and run a few simple examples, illustrating how ND4J works.

# <a id="java">Java</a>

### What it is

Java is the programming language ND4J is written in. There are 9 million Java developers worldwide. It runs on 3 billion mobile phones and 97 percent of all enterprise desktops, both Windows and OSX. You can use it for distributed cloud-based systems with thousands of nodes, as well as on low-memory IoT devices. It's a "write once, run anywhere" language. That's why we chose it.

### Why you need Java

Java will allow your neural nets to work cross-platform on servers, desktops and mobile devices.

### Is Java already installed?

To test which version of Java you have (and whether you have it at all), type the following into your command line:

		java -version

ND4J requires Java 7, so if you have an older or newer version, you will need to reinstall.

### Installing Java

If you don't have Java 7 installed on your machine, download the [Java Development Kit (JDK) here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). The download will vary by operating system. For newer Macs, you'll want the file on the first line to mention Mac OS X (the number after *jdk-7u* increments with each update). It will look something like this:

		Mac OS X x64 185.94 MB -  jdk-7u67-macosx-x75.dmg

# <a id="ide-for-java">Integrated Development Environment</a>

### What an IDE is

An Integrated Development Environment ([IDE](http://encyclopedia.thefreedictionary.com/integrated+development+environment)) will allow you to work with our API and build your nets with a few clicks. The IDEs suggested here work with your installed version of Java and can communicate with Maven (see below), which takes care of the dependencies for you. Visit ND4J's [dependencies](dependencies.html) page to see how to set up the POM.xml file, and consult the page on [GPUs abnd CPUs](gpu_native_backends.html) page to learn how to swap backends (it's one line of code...).

### Why you need an IDE

You want a hassle-free development environment so that you only need to think about your code. IDEs typically come with Maven support, but we prefer you to install [Maven](#maven) so you can run commands directly as instructed previously.

### Is an IDE already installed?

Just check the list of applications installed on your computer.

### Installing an IDE

We recommend installing [IntelliJ](https://www.jetbrains.com/idea/download/). The free community edition does the job just fine.

[Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html) and [Netbeans](http://wiki.netbeans.org/MavenBestPractices) are two other popular IDEs.

# <a id="maven">Maven</a>

### What it is

Maven is an automated build tool for Java projects (among other [things](http://maven.apache.org/what-is-maven.html)), which locates the latest version of the project libraries (ND4J .jar files) and downloads them automatically to your computer.

### Why you need Maven

Maven will allow you to install both ND4J and Deeplearning4j projects easily. It works well with Integrated Development Environments ([IDE](#ide-for-java)) such as IntelliJ.

(Experienced Java developers who prefer not to work with Maven can find the .jar files in our [downloads](downloads.html) page. For an expert user it might be faster, but also more complicated due to dependencies.)

### Is Maven already installed?

To see if Maven is installed in your machine, enter the following into the command line:

		mvn --version

### Installing Maven

Instructions to install Maven are [here](https://maven.apache.org/download.cgi). Download the compressed file containing Maven's latest stable version.

![Alt text](../img/maven_downloads.png) 

Lower on the same Web page, follow the instructions that pertain to your operating system; e.g. *"Unix-based Operating Systems (Linux, Solaris and Mac OS X)."* They look like this:

![Alt text](../img/maven_OS_instructions.png) 

Now, using your IDE, create a new project. Select `maven-archetype-quickstart`.

![Alt text](../img/new_maven_project.png) 

The images below will walk you through the windows of the IntelliJ New Project Wizard using Maven. First, name your group and artifact.

![Alt text](../img/maven2.png) 

Click through the following screen with "Next", and on the screen after that (below), name your project. ("ND4J", for example...) Now go into your pom.xml file within the root of the new ND4J project in IntelliJ. 

Include the default backend ([Jblas](http://en.wikipedia.org/wiki/Jblas:_Linear_Algebra_for_Java)) in the `<dependencies> ... </dependincies>` section, so Maven can automatically install the required libraries:

	 <dependency>
	   <groupId>org.nd4j</groupId>
	   <artifactId>nd4j-jblas</artifactId>
	   <version>${nd4j.version}</version>
	 </dependency>

If you want to know exactly which version of ND4J you are using, press `Ctrl` and click on `nd4j.version`. This is a neat trick to jump through code in IntelliJ. Keep in mind that the JBLAS backend can be switched to Netlib Blas, or JCUBLAS for GPU use. Check our [dependencies](dependencies.html) page for advanced configuration changes. That page also explains how to check on the [latest version](http://search.maven.org/#search%7Cga%7C1%7Cnd4j) of the libraries.

You can now create a new Java file within IntelliJ, and start using ND4J's API for distributed linear algebra. (See our [intro](http://nd4j.org/introduction.html) if you need inspiration. ND4J in IntelliJ has **autocomplete**, so starting a new line with any letter will show you a list of all ND4J commends including that letter.) 

# <a id="github">GitHub</a>

### What it is

[Github](http://en.wikipedia.org/wiki/GitHub) is a web-based [Revision Control System](http://en.wikipedia.org/wiki/Revision_control), _the [de facto host](http://opensource.com/life/12/11/code-hosting-comparison) for open source projects_.

### Why you (maybe) need Github

If you just want to use the ND4J libraries, **you are not required to install GitHub**. If you're planning to contribute to the ND4J or [DeepLearning4J](https://github.com/SkymindIO/deeplearning4j) projects by fixing bugs and committing code, you will need it. (Thanks in advance btw :)

### Is Github already installed?

Just check the list of applications installed on your computer.

### Installation

Download GitHub for [Mac](https://mac.github.com/), [Windows](https://windows.github.com/), etc. Once installed, to clone ND4J or DL4J, enter this command into your terminal (Mac) or Git Shell (Windows):

      git clone https://github.com/SkymindIO/nd4j
      git clone https://github.com/SkymindIO/deeplearning4j
      
You might also want to clone our examples so you can mess around with ND4J or DL4J's pre-built samples:
      
      git clone https://github.com/SkymindIO/nd4j-examples
      git clone https://github.com/SkymindIO/dl4j-examples
      
Another way to get the source code is by clicking on the "[download ZIP](https://github.com/SkymindIO/nd4j/archive/master.zip)" button from the [ND4J GitHub page](https://github.com/SkymindIO/nd4j). Then unzip the file (you can use [7-zip](http://www.7-zip.org/download.html) to do that).

# <a id="next-steps">Next Steps</a>

Now you're ready to run the [examples](introduction.html). We recommend that you launch your IDE, load the ND4J project and open the examples subdirectory. Locate one in the file tree on the lefthand side of the IntelliJ winow, right click on it, and select the green arrow for "Run" on the drop-down menu. If everything was installed correctly, you should see numbers appear as the program output. Please alter the code to see what you can do with it. 

Once you're comfortable with the examples, you might want to change the dependencies defined in the POM files. Learn how to change the [dependencies here](gpu_native_backends.html).

For questions or feedback, join us on our [Google Groups Forum](https://groups.google.com/forum/#!forum/nd4j).

Useful links:

* [ND4J.org](http://nd4j.org/)
* [ND4J - Github repository](https://github.com/SkymindIO/nd4j)
* [ND4J - Wikipedia](https://en.wikipedia.org/wiki/ND4J)
* [ND4J - API Documentation](http://nd4j.org/apidocs/)
* [ND4J - Maven Repository](http://mvnrepository.com/artifact/org.nd4j)
* [DeepLearning4J.org](http://deeplearning4j.org/)
* [DeepLearning4J - Github repository](https://github.com/SkymindIO/deeplearning4j)
* [DeepLearning4J - Wikipedia](https://en.wikipedia.org/wiki/Deeplearning4j)
* [DeepLearning4J - API Documentation](http://deeplearning4j.org/doc/)
* [DeepLearning4J - Maven Repository](http://mvnrepository.com/artifact/org.deeplearning4j)

