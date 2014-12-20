---
layout: page
title: 
tagline: 
---
{% include JB/setup %}

# ND4J入门

为了使用ND4J ，您的电脑或将计算机上需要安装了以下这些个工具：

1. [Java](http://nd4j.org/zh-getstarted.html#java)
2. [Github](http://nd4j.org/zh-getstarted.html#github)
3. [Maven](http://nd4j.org/zh-getstarted.html#maven)
4. [Java IDE](http://nd4j.org/zh-getstarted.html#ide)
5. [下一步](http://nd4j.org/zh-getstarted.html#next)

整个安装过程可能需要一个小时左右，这将取决于您的网络速度。在这个教程里，通过利用一些简单的例子，您将会学习到ND4J如何运行。

## <a name="java">Java</a>

### 什么是Java

Java是我们的首选编程语言。

## 为什么您需要Java

Java将会帮您把您的代码转换成机器代码，让您可以在服务器，计算机或电脑和移动电话上跨平台工作。

### 您是否安装了Java

测试您的Java版本（也测试您是否拥有Java） ，通过键入以下文本到命令行：

    java -version

ND4J需要Java 7 才能执行，因此，如果您有较旧的Java版本，您需要安装一个新的。

### 安装

如果您的计算机（电脑）上没有安装Java 7，请到这里下载 Java开发工具包（ JDK ）。 Java的下载方法将因不同的操作系统而异。对于较新的苹果操作系统，您会看到在在第一行的文件提及Mac OS X（每一次的更新的，jdk-7U后的数字将增加）。您讲会看到类似以下的文本：

        Mac OS X x64 185.94 MB -  jdk-7u67-macosx-x71.dmg
    
## <a name="github">Github</a>

### 什么是Github

Github是基于互联网的的一个分布式的版本控制系统。GitHub可以托管各种git库，并提供一个web界面，但与其它像 SourceForge或Google Code这样的服务不同，GitHub的独特卖点在于从另外一个项目进行分支的简易性。（点击此处查看现有的开放源代码软件的托管设施之间的比较） 。

### 为什么您需要Github

如果您只想使用ND4J库，您就不需要GitHub，Maven将会处理.jar文件。但是，如果您想对ND4J或DeepLearning4J项目作出贡献，我们十分欢迎您向我们报告当中出现错误。（我们十分感谢那些已经对这个项目作出贡献的人）。

### 您是否安装了Github

您只是检查你安装的程序。

### 安装

您只需要到GitHub上下载的Mac ，Windows等复制ND4J文件，输入以下的指令到您的终端（ Mac）或Git Shell（ Windows）中：

        git clone https://github.com/SkymindIO/nd4j

## <a name="maven">Maven</a>



