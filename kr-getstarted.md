---
layout: page
title: "Get started with ND4J in Minutes"
description: "Install a Java development environment ready for N-Dimensional Array Algebra with ND4J"
---
{% include JB/setup %}

ND4J 몇 분 안에 시작하기

이것은 다단계 설치 입니다. 질문이나 피드백이 있으시다면 저희가 상세한 설명을 드릴 수 있드록 저희의 [Gitter Live Chat](https://gitter.im/deeplearning4j/deeplearning4j)에 가입하시기를 강력 추천드립니다. 비사교적 또는 완전 독립적인 성격이시라면 자율 학습 하실 수 있습니다.

ND4J 및 DL4J를 시작하려면 다음을 읽어주시기 바랍니다:

1. [Prerequisites](http://nd4j.org/getstarted.html#prereq)
2. [통합 개발 환경(Integrated Development Environment)](http://nd4j.org/getstarted.html#ide)
3. [Github](http://nd4j.org/getstarted.html#github)
4. [개발 도구](http://nd4j.org/getstarted.html#devtools)
5. [다음 단계](http://nd4j.org/getstarted.html#next-steps)


Prerequisites

시스템 구성(configuration) 요구 사항:

[Java 7](http://nd4j.org/getstarted.html#java)
[Scala 2.10.4](http://nd4j.org/getstarted.html#scala)
[Maven 3.2.5](http://nd4j.org/getstarted.html#maven)
[Canova 0.0.0.2](http://nd4j.org/getstarted.html#canova)

Spark 요구 사항을 사용하여 배포된(distributed) 시스템:

[Spark 1.3.0](https://spark.apache.org/downloads.html) (package type = Pre-built for Hadoop 1.X)

GPU 요구 사항:

[Cuda 7](http://docs.nvidia.com/cuda/index.html#axzz3dlfIdQjP)


Java 7

Java는 ND4J의 주요 인터페이스 및 네트워킹 언어입니다. 이는 수천 개의 노드로 배포된 클라우드 기반의 시스템에서부터 저용량 메모리 IoT 기기들까지 모두 사용되기 때문입니다. Java는 "한번 작성하면, 어디서든 실행할 수 있는" 언어입니다.

여러분이 가지고 있는 Java의 버전을 (혹은 가지고 있는지 여부를) 확인하려면, 커맨드 라인에 다음을 입력하세요:

————-
	java -version
————-

ND4J 및 DL4J는 Java 7을 필요로 하므로 만약 이전의 또는 더 새로운 버전을 가지고 계시다면 재설치하시기 바랍니다.

Java 7이 컴퓨터에 설치되어 있지 않은 경우, [여기에서 Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)를 다운로드 하실 수 있습니다. 다운로드는 운영 체제에 따라 다를 것 입니다. 새로운 Mac의 경우, Mac OS X를 언급하는 첫 번째 라인에 있는 파일을 원하실 것이며 (jdk-7u 뒤의 숫자가 각 업데이트와 함께 증가합니다.) 이는 다음과 같을 것입니다:

——————
	Mac OS X x64 185.94 MB -  jdk-7u79-macosx-x75.dmg
——————

Scala

여러분은 [Scala API](http://nd4j.org/scala.html)를 통해 ND4J를 작업하실 수 있습니다. Scala는 JVM 상에서 실행되는 강력한 static type 시스템을 가진 멀티패러다임 언어입니다.다. Scala는 Java와 같이 OOP 기능 뿐만 아니라 Scheme 및 Haskell과 유사한 기능적인 프로그래밍 기능을 가지고 있으며, 그 구조는 프로그램을 간결하게 유지하게 합니다. 여러분은 Scala와 함께 Java 라이브러리를 이용하실 수 있습니다. 여러분이 실행해 볼 수 있는 Scala로 작성된 신경망 예제들이 있는데, 이는 Spark 구현에 필요합니다.

여러분이 가지고 있는 Scala의 버전을 (혹은 가지고 있는지 여부를) 확인하려면, 커맨드 라인에 다음을 입력하세요:

————
	scala -version
—————-

Scala를 설치하시려면 [Scala download page](http://www.scala-lang.org/download/2.10.4.html)를 방문하십시오.


Maven

Maven은 Java 프로젝트를 위한 자동화된 빌드 도구입니다 (이는 다른 [여러 용도들](http://maven.apache.org/what-is-maven.html) 중 하나 입니다). 이는 ND4J 및 DL4J 프로젝트 라이브러리의 최신 버전을 찾아주고 (.jar 파일들), 필요시 자동으로 다운로드 합니다.

저희는 [Java 프로그래머가 아닌 분들을 위해 조금 더 심화된 introduction to Maven을 여기에](http://deeplearning4j.org/maven.html) 작성했습니다. Maven은 ND4J와 Deeplearning4j 프로젝트 모두를 쉽게 설치할 수 있게 합니다. 이는 IntelliJ와 같은 통합 개발 환경 (IDEs)와 잘 작동합니다.

Maven이 컴퓨터에 설치되어 있는지 확인하려면, 커맨드 라인에 다음을 입력하세요:

———-
	mvn --version
————-

Maven 설치 방법은 [여기](https://maven.apache.org/download.cgi)에 있습니다. Maven의 최신 안정화된 버전을 포함하고 있는 압축 파일을 다운로드 하십시오.
