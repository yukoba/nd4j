---
layout: page
title: "Getting Started"
description: ""
---
{% include JB/setup %}

In order to use ND4J, you will need to have several tools installed in your machine:

1. [Java](#java) ([download](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html))
2. [An Integrated Development Environment](#ide-for-java) ([download](https://www.jetbrains.com/idea/download/))
3. [Maven](#maven) ([download](https://maven.apache.org/download.cgi))
4. [Github](#github) (download for [Mac](https://mac.github.com/) or [Windows](https://windows.github.com/))

Installing these tools might take a while, so sit tight. This tutorial will guide you until you can run a few simple examples that illustrate how ND4J works.

# <a id="java">Java</a>

### What it is
[Java](http://en.wikipedia.org/wiki/Java_%28programming_language%29) is yor [programming language](http://en.wikipedia.org/wiki/Comparison_of_programming_languages) of choice.

### Why you need it
Java will translate your code into machine code, allowing you to run it.

### Is it already installed?
To test which version of Java you have (and whether you have it at all), type the following into the command line:

		java -version

ND4J requires Java 7, so if you have an older verion, you will need to install a newer one.

### Installation
If you don't have Java 7 installed on your machine, download the [Java Development Kit (JDK) here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). The download will vary by operating system. For newer Macs, you'll want the file on the first line to mention Mac OS X (the number after *jdk-7u* increments with each update). It will look something like this:

		Mac OS X x64 185.94 MB -  jdk-7u67-macosx-x71.dmg

# <a id="ide-for-java">Integrated Development Environment (IDE)</a>

### What it is
An Integrated Development Environment ([IDE](http://encyclopedia.thefreedictionary.com/integrated+development+environment)) will allow you to edit the source code, debug it and build it with a few clicks. The ones suggested here will use your installed version of Java, will talk with GitHub and Maven, which will take care of the dependencies for you. Visit our [dependencies](dependencies.html) page to know how to 'easily' change the dependencies later on.

### Why you need it
You want to set up a hassle-free development environment so that you only worry about your code. IDEs typically come with Maven support, but we prefer you to install [Maven](#3-maven) so you can run commands directly as instructed previously.

### Is it already installed?
Just check your installed programs.

### Installation
We recommend installing [IntelliJ](https://www.jetbrains.com/idea/download/). You will be perfectly fine with the free community edition.

For picky ones, these are some equivalent IDEs: [Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html) or [Netbeans](http://wiki.netbeans.org/MavenBestPractices).

Now you can easily import the ND4J project via [Intellij](http://stackoverflow.com/questions/1051640/correct-way-to-add-lib-jar-to-an-intellij-idea-project) (or again, for picky ones via [Eclipse](http://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse) or [Netbeans](http://gpraveenkumar.wordpress.com/2009/06/17/abc-to-import-a-jar-file-in-netbeans-6-5/)).

# <a id="maven">Maven</a>

### What it is
Maven is an automated build tool for Java projects (among other [things](http://maven.apache.org/what-is-maven.html)), that basically locates the latest version of the libraries (Deeplearning4j .jar files), and downloads them automatically to your computer.

### Why you need it
Maven will allow you to install both ND4J and Deeplearning4j projects easily. It works well with Integrated Development Environments ([IDE](#ide-for-java)) such as IntelliJ.

(If you really know what you are doing, and do not want to install Maven, you can find the .jar files in our [downloads](downloads.html) page. For an expert user it might be faster, but also more complicated due to dependencies.)

### Is it already installed?
To see if Maven is installed in your machine, enter the following into the command line:

		mvn --version

### Installation

Instructions to install Maven are [here](https://maven.apache.org/download.cgi). Download the compressed file containing Maven's latest stable version.

![Alt text](../img/maven_downloads.png) 

Lower on the same Web page, follow the instructions that pertain to your operating system; e.g. *"Unix-based Operating Systems (Linux, Solaris and Mac OS X)."* They look like this:

![Alt text](../img/maven_OS_instructions.png) 

* Now, using your IDE, create a new project:

![Alt text](../img/new_maven_project.png) 

The images below will walk you through the windows of the IntelliJ New Project Wizard using Maven. First, you name your group and artifact.

![Alt text](../img/maven2.png) 

Simply click "Next" on the following screen, and on the screen after that (below), just name your project. ("ND4J" perhaps?) Now you should go into your pom.xml file within the new ND4J project in IntelliJ. It will look something like this:

![Alt text](../img/nd4j_pom_before.png) 

You will need to add dependencies within the <dependencies> section: "nd4j-api" and a linear-algebra backend like "nd4j-jblas" or "nd4j-jcublas", depending on whether you are working with CPUs or GPUs, respectively. You will find all three by searching for them on [Maven's central repository](http://search.maven.org). Click on the "latest version" on this screen. From there, you want to copy the dependency information:

![Alt text](../img/nd4j_maven.png) 

And paste it into the "dependencies" section of your pom.xml, which should end up looking like this:

![Alt text](../img/nd4j_pom_after.png) 

That's it. Once you've pasted the right dependencies into the pom, you're done. You can create a new Java file within IntelliJ and start using ND4J's API to start doing distributed linear algebra. (See our [intro](http://nd4j.org/introduction.html) if you need inspiration.) 

# <a id="github">GitHub</a>

### What it is
[Github](http://en.wikipedia.org/wiki/GitHub) is a web-based [Revision Control System](http://en.wikipedia.org/wiki/Revision_control), _the [de facto host](http://opensource.com/life/12/11/code-hosting-comparison) for open source projects_.

### Why you need it

If you just want to use the ND4J libraries, **you are not required to install GitHub**. If you're planning to contribute to the ND4J or the [DeepLearning4J](https://github.com/SkymindIO/deeplearning4j) project by fixing bugs and committing code, you will. (Thanks in advance :)

### Is it already installed?
Just check your installed programs.

### Installation
Download GitHub for [Mac](https://mac.github.com/), [Windows](https://windows.github.com/), etc.
To clone the ND4J files, enter this command into your terminal (Mac) or Git Shell (Windows):

      git clone https://github.com/SkymindIO/nd4j
      
Another way to get the source code is by clicking on the '[download ZIP](https://github.com/SkymindIO/nd4j/archive/master.zip)' button from the [ND4J GitHub page](https://github.com/SkymindIO/nd4j). Then unzip the file (you can use [7-zip](http://www.7-zip.org/download.html) to do that).

# Next Steps

Now you're ready to run the [examples](elementwise.html). We recommend that you launch your IDE, load the ND4J project and open the examples subdirectory. Locate one of them and click run. If everything was installed correctly you should see numbers appear as the program output. You can start inspecting/messing with the code.

Once you are comfortable with the examples, you might want to change the dependencies defined in the POM files. Learn how to change the [dependencies here](dependencies.html).

For questions or feedback, join us on our [Google Groups Forum](https://groups.google.com/forum/#!forum/nd4j).

Useful links:

* ND4J's [Github repository](https://github.com/SkymindIO/nd4j).
* [DeepLearning4J project](http://deeplearning4j.org/) and [Github repository](https://github.com/SkymindIO/deeplearning4j) (using ND4J).

