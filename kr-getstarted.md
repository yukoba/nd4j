---
layout: page
title: "ND4J 몇 분 안에 시작하기"
description: 
---
{% include JB/setup %}

이것은 다단계 설치 입니다. 질문이나 피드백이 있으시다면 저희가 상세한 설명을 드릴 수 있드록 저희의 [Gitter Live Chat](https://gitter.im/deeplearning4j/deeplearning4j)에 가입하시기를 강력 추천드립니다. 비사교적 또는 완전 독립적인 성격이시라면 자율 학습 하실 수 있습니다.

ND4J 및 DL4J를 시작하려면 다음을 읽어주시기 바랍니다:

1. [Prerequisites](#prereq)
2. [통합 개발 환경(Integrated Development Environment)](#ide)
3. [Github](#github)
4. [개발 도구](#devtools)
5. [다음 단계](#next)

## <a id="prereq">Prerequisites</a>

시스템 구성(configuration) 요구 사항:

[Java 7](#java)
[Scala 2.10.4](#scala)
[Maven 3.2.5](#maven)
[Canova 0.0.0.2](#canova)

Spark 요구 사항을 사용하여 배포된(distributed) 시스템:

* [Spark 1.3.0](https://spark.apache.org/downloads.html) (package type = Pre-built for Hadoop 1.X)

GPU 요구 사항:

* [Cuda 7](http://docs.nvidia.com/cuda/index.html#axzz3dlfIdQjP)

## <a id="java">Java 7</a>

Java는 ND4J의 주요 인터페이스 및 네트워킹 언어입니다. 이는 수천 개의 노드로 배포된 클라우드 기반의 시스템에서부터 저용량 메모리 IoT 기기들까지 모두 사용되기 때문입니다. Java는 "한번 작성하면, 어디서든 실행할 수 있는" 언어입니다.

여러분이 가지고 있는 Java의 버전을 (혹은 가지고 있는지 여부를) 확인하려면, 커맨드 라인에 다음을 입력하세요:

		java -version

ND4J 및 DL4J는 Java 7을 필요로 하므로 만약 이전의 또는 더 새로운 버전을 가지고 계시다면 재설치하시기 바랍니다.

Java 7이 컴퓨터에 설치되어 있지 않은 경우, [여기에서 Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)를 다운로드 하실 수 있습니다. 다운로드는 운영 체제에 따라 다를 것 입니다. 새로운 Mac의 경우, Mac OS X를 언급하는 첫 번째 라인에 있는 파일을 원하실 것이며 (jdk-7u 뒤의 숫자가 각 업데이트와 함께 증가합니다.) 이는 다음과 같을 것입니다:

		Mac OS X x64 185.94 MB -  jdk-7u79-macosx-x75.dmg

## <a id="scala">Scala</a>

여러분은 [Scala API](http://nd4j.org/scala.html)를 통해 ND4J를 작업하실 수 있습니다. Scala는 JVM 상에서 실행되는 강력한 static type 시스템을 가진 멀티패러다임 언어입니다.다. Scala는 Java와 같이 OOP 기능 뿐만 아니라 Scheme 및 Haskell과 유사한 기능적인 프로그래밍 기능을 가지고 있으며, 그 구조는 프로그램을 간결하게 유지하게 합니다. 여러분은 Scala와 함께 Java 라이브러리를 이용하실 수 있습니다. 여러분이 실행해 볼 수 있는 Scala로 작성된 신경망 예제들이 있는데, 이는 Spark 구현에 필요합니다.

여러분이 가지고 있는 Scala의 버전을 (혹은 가지고 있는지 여부를) 확인하려면, 커맨드 라인에 다음을 입력하세요:

		scala -version

Scala를 설치하시려면 [Scala download page](http://www.scala-lang.org/download/2.10.4.html)를 방문하십시오.

## <a id="maven">Maven</a>

Maven은 Java 프로젝트를 위한 자동화된 빌드 도구입니다 (이는 다른 [여러 용도들](http://maven.apache.org/what-is-maven.html) 중 하나 입니다). 이는 ND4J 및 DL4J 프로젝트 라이브러리의 최신 버전을 찾아주고 (.jar 파일들), 필요시 자동으로 다운로드 합니다.

저희는 [Java 프로그래머가 아닌 분들을 위해 조금 더 심화된 introduction to Maven을 여기에](http://deeplearning4j.org/maven.html) 작성했습니다. Maven은 ND4J와 Deeplearning4j 프로젝트 모두를 쉽게 설치할 수 있게 합니다. 이는 IntelliJ와 같은 통합 개발 환경 (IDEs)와 잘 작동합니다.

Maven이 컴퓨터에 설치되어 있는지 확인하려면, 커맨드 라인에 다음을 입력하세요:

		mvn --version

Maven 설치 방법은 [여기](https://maven.apache.org/download.cgi)에 있습니다. Maven의 최신 안정화된 버전을 포함하고 있는 압축 파일을 다운로드 하십시오.

![Alt text](../img/maven_downloads.png) 

같은 페이지의 아래 부분에 있는 여러분의 운영 체제에 맞춰진 설명을 따르십시오; 예를 들어, "Unix 기반의 운영 시스템 (Linux, Solaris 및 Mac OS X)." 그들은 다음과 같습니다:

![Alt text](../img/maven_OS_instructions.png) 

## <a id="ide">통합 개발 환경: IntelliJ</a>

통합 개발 환경 ([IDE](http://encyclopedia.thefreedictionary.com/integrated+development+environment))는 여러분이 저희의 API와 작동하게 하고, 몇 번의 클릭만으로 여러분의 망(nets)을 구축하게 합니다. 설치된 Java의 버전과 작동하고, 디펜던시(dependencies)를 처리할 [Maven](http://nd4j.org/getstarted.html#maven)과 의사소통 할 IntelliJ를 사용하시기를 권장합니다.

[IntelliJ](https://www.jetbrains.com/idea/download/)의 무료 커뮤니티 간행물에 설치 설명이 있습니다. 저희는 이를 선호하지만, [Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html)와 [Netbeans](http://wiki.netbeans.org/MavenBestPractices)도 범용화된 통합 개발 환경 입니다.

## 새로운 ND4J 프로젝트 시작하기

IntelliJ 내에서 새로운 ND4J 프로젝트를 생성하려면, 여러분의 프로젝트의 POM.xml 파일에 적절한 디펜던시를 넣기만 하면 됩니다. 제대로 되었다면, Maven은 여러분을 위해 ND4J을 구축해 줄 것입니다. 적절한 디펜던시를 여러분의 POM 값에 붙여 넣기만 하면 ND4J 설치 완료 - 다른 어떤 설치도 필요하지 않습니다!

*maven-archetype-quickstart* 를 선택하십시오.

![Alt text](../img/new_maven_project.png) 

아래 이미지들은 여러분에게 Maven을 사용한 IntelliJ New Project Wizard의 창들로 안내할 것 입니다. 첫째, 여러분이 좋아하는 그룹 및 artifact의 이름을 정하십시오.

![Alt text](../img/maven2.png) 

"Next"가 있는 다음과 같은 화면이 나올 때까지 클릭하시고, 그 다음 화면에서 여러분의 프로젝트 이름을 지정하신 후 마치기를 누르십시오 (예를 들어, "ND4J-test"). 이제 IntelliJ에 있는 여러분의 새로운 ND4J 프로젝트의 루트 내 POM.xml 파일로 이동하십시오.

여러분이 필요로 할 디펜던스들로 POM 파일을 업데이트 하십시오. 이들은 여러분께서 CPU 또는 GPU를 사용하시는 지의 여부에 따라 달라질 것 입니다. 

CPU를 위한 기본 백엔드는 ([Jblas](https://en.wikipedia.org/wiki/Jblas:_Linear_Algebra_for_Java)) 입니다. 이를 여러분의 POM의 `<dependencies> ... </dependencies>` 섹션에 다음과 같이 붙여 넣으실 수 있습니다.

			<dependency>
			   <groupId>org.nd4j</groupId>
			   <artifactId>nd4j-jblas</artifactId>
			   <version>${nd4j.version}</version>
			 </dependency>
 
ND4J의 버전이 여기에서 변수입니다. 이는 `<properties> ... </properties>` 섹션에 있는, nd4j를 지정할 POM의 다른 상위 라인을 참조할 것이며, 다음과 같이 보여질 것 입니다:

		<nd4j.version>0.0.3.5.5.3</nd4j.version>

저희가 새로운 릴리스를 사용하면 버전의 숫자는 달라질 수 있습니다. Maven Central에서 최신 버전을 확인하십시오. 여러분이 적절한 디펜던시와 nd4j 버전에 붙여 넣는다면, Maven은 자동으로 필요한 라이브러리를 설치하고, 여러분은 ND4J을 실행하실 수 있어야 합니다.

백엔드는 Jblas이어야 할 필요가 없습니다; Netlib Blas, 또는 GPU를 위한 Jcublas로 전환될 수 있습니다. 이는 저희의 [dependencies](http://nd4j.org/dependencies.html) 페이지에 더 심화된 구성 변경과 함께 설명되어 있습니다. 같은 페이지에 라이브러리의 [최신 버전](http://search.maven.org/#search%7Cga%7C1%7Cnd4j)을 확인하는 방법에 대해서도 설명되어 있습니다.

여러분은 이제 IntelliJ 내에서 새로운 프로젝트를 생성하고, 분산 선형 대수학을 위한 ND4J의 API를 사용해 시작하실 수 있습니다.

모든 새로운 IntelliJ 프로젝트로 생성된 App.java 파일을 열고, public static void main( String[] args ) 뒤에 있는 중괄호 사이에 코드를 작성하기 시작하십시오.

아직 적절한 패키지들을 가져 오지 않았기 때문에 클래스의 많은 부분이 빨간색으로 표시될 것 입니다. 그러나 IntelliJ가 여러분의 파일의 상단에 자동으로 패키지를 추가할 것 입니다. 패키지들을 자동으로 로드하게 하기 위해 여러분의 OS에 맞는 적절한 hot keys를 조회하십시오.

(몇 개의 시작 작업을 위해 저희의 [intro](http://nd4j.org/introduction.html)를 참조하십시오. IntelliJ에서 ND4J는 autocomplete 하므로, 어떤 문자로 새로운 라인을 시작하면 그 문자를 포함한 모든 ND4J 커맨드 목록이 보여질 것 입니다.)

## <a id="canova">Canova</a>

[Canova](https://github.com/deeplearning4j/Canova)는 저희가 기계 학습 도구를 위해 개발한 일반 벡터화 lib 입니다. 이는 저희의 신경망과 함께 작동 할 수 있는 svmLight, libsvm 및 ARFF와 같이 raw data를 사용 가능한 벡터 형식으로 벡터화 합니다.

### Canova 설치하기

[Canova](http://search.maven.org/#search%7Cga%7C1%7Ccanova-parent)를 설치하려면 ND4J를 위해 Maven을 설치할 때 사용하신 동일한 단계를 따르십시오.

## Deeplearning4j 설치하기

Deeplearning4j 버전은 POM의 속성(properties) 섹션에 하드 코딩된 버전 및 각 디펜던시에 언급된 버전 변수로, ND4J를 위해 했던 것과 동일한 방법으로 지정되어야 합니다.

여러분이 POM에 추가한 DL4J 디펜던시들은 프로젝트의 성격에 따라 달라집니다.

핵심 디펜던시 뿐만 아니라, 아래에 보여진 것과 같이, 여러분은 또한 커맨드 라인 인터페이스를 위한 deeplearning-cli를, Hadoop 또는 Spark 및 다른 것들 상의 병렬 실행을 위한 deeplearning4j-scaleout도 필요에 따라 설치할 수 있습니다. 전체 목록은 Maven Central에서 deeplearning4j을 검색하면 보실 수 있습니다.

				<dependency>
				 <groupId>org.deeplearning4j</groupId>
				 <artifactId>deeplearning4j-core</artifactId>
				 <version>${deeplearning4j.version}</version>
				</dependency>

Deeplearning4j 설치에 대한 더 많은 정보는 [Getting Started page](http://deeplearning4j.org/gettingstarted.html)에서 가능합니다.

## <a id="github">GitHub</a>

[Github](https://en.wikipedia.org/wiki/GitHub)은 웹 기반의 [개정 제어 시스템(Revision Control System)](https://en.wikipedia.org/wiki/Revision_control)으로, 오픈 소스 프로젝트를 위한 [사실상의 호스트](http://opensource.com/life/12/11/code-hosting-comparison) 입니다.

만약 여러분께서 버그를 수정하고 코드를 작성하여 ND4J 및 [DeepLearning4J](https://github.com/deeplearning4j/deeplearning4j) 프로젝트에 기여하고자 하신다면, git 및 GitHub가 필요하실 것 입니다. (미리 감사드립니다 :))

Git을 가지고 있는지 확인하려면, 커맨드 라인에 다음을 입력하세요.

		git --version 

GitHub을 위해서는 여러분의 컴퓨터에 설치된 응용 프로그램의 목록을 확인하시기만 하면 됩니다.

만약 가지고 있지 않으시다면 [git](https://git-scm.herokuapp.com/book/en/v2/Getting-Started-Installing-Git)을 설치하시기 바랍니다. 그리고 나서 [GitHub 계정](https://github.com/join)을 만들어 주세요. [Mac](https://mac.github.com), [Windows](https://windows.github.com), 등을 위한 GitHub을 다운로드 합니다. 설치되면, ND4J 및 DL4J를 복제하고, 여러분의 콘솔(console)에 다음의 커맨드를 입력하십시오:

		git clone https://github.com/deeplearning4j/nd4j
		git clone https://github.com/deeplearning4j/Canova
		git clone https://github.com/deeplearning4j/deeplearning4j

여러분은 저희의 예제들을 복제해서 ND4J 및 DL4J의 사전 구축 된 샘플들을 연습하실 수도 있습니다 (버전은 다를 수 있습니다):

		git clone https://github.com/deeplearning4j/dl4j-0.0.3.3-examples

소스 코드를 얻을 수 있는 또 다른 방법은 [ND4J GitHub page](https://github.com/deeplearning4j/nd4j)에서 “download ZIP” 버튼을 클릭하는 것 입니다. 그런 다음 파일의 압축을 풉니다 ([7-zip](http://www.7-zip.org/download.html)을 사용하실 수 있습니다).

Maven은 ND4J, Canova 및 Deeplearning4j가 올바르게 구축되었는지 확인하는데 Git와 함께 사용될 수 있습니다. 이 라이브러리들의 가장 최근의 작업 버전을 가지고 있는지 확인하려면, 그들의 루트 디렉토리들에 cd하고 여러분의 프롬프트에 다음의 커맨드를 입력하실 수 있습니다:

		mvn clean install -DskipTests -Dmaven.javadoc.skip=true

순서대로 ND4J, Canova 및 Deeplearning4j에 새로운 설치를 실행하는 것이 가장 최근의 버그 수정 및 기능들을 얻을 수 있는 좋은 방법 입니다.

## <a id="devtools">OSX, Windows 및 Linux의 C를 위한 개발 도구</a>

Windows나 Linux OS에서 특정 ND4J 디펜던시들을 컴파일 하려면, 여러분은 gcc를 포함한 C를 위한 몇 개의 개발 도구를 설치해야 합니다. 여러분이 gcc를 가지고 있는지 확인하려면, 여러분의 터미널 혹은 커맨드 프롬프트에 gcc -v를 입력하시기 바랍니다.

## OSX

[Apple developer tool Xcode](https://developer.apple.com/xcode/downloads/)의 일부 버전은 여러분을 위해 gcc를 설치해 줄 것 입니다. 만약 gcc를 가지고 있지 않으시다면 여러분의 커맨드 프롬프트에 brew install gcc를 입력해 주십시오.

## Windows

Windows 사용자는 무료 [Visual Studio community 2013](https://www.visualstudio.com/en-us/products/visual-studio-community-vs.aspx)을 설치해야 합니다. 수동으로 그 경로를 여러분의 PATH 환경 변수에 추가해야 합니다. 그 경로는 이와 같을 것입니다: C:\Program Files (x86)\Microsoft Visual Studio 12.0\VC\bin

여러분의 CMD에 "cl"을 입력 하십시오. 특정 .dll 파일들이 누락되어 있슴을 알리는 메시지가 나타날 수 있습니다. 여러분의 VS/IDE 폴더가 그 경로 내에 있는지 확인하십시오 (위 참조). 만약 여러분의 CMD이 "cl"을 위한 사용 정보를 보여준다면 이는 제대로 되어 있슴을 의미합니다.

(추가적으로, [Java CPP](https://github.com/bytedeco/javacpp)를 위한 include path가 Windows 상에서 항상 작동하지는 않습니다. 한 가지 해결 방법은 Visual Studio의 include directory에서 header files를 가져와 Java가 설치되어 있는 Java Run-Time Environment (JRE))의 include directory에 입력하는 것 입니다. 이는 standardio.h와 같은 파일들에 영향을 미칠 것 입니다.

## Linux

Linux로 Ubuntu 및 Centos 사용자는 두 개의 별도 세트의 설명을 따라야 합니다:

### Ubuntu

Ubuntu를 위해, 우선 다음을 입력하십시오:

		sudo apt-get update

그 다음 이 커맨드를 실행해야 합니다:

		sudo apt-get install linux-headers-$(uname -r) build-essential

$(uname -r)은 여러분의 Linux 버전에 따라 달라질 수 있습니다. Linux 버전을 확인하려면, 여러분의 터미널의 새로운 창을 열고 다음 커맨드를 입력하시기 바랍니다:

		uname -r

3.2.0-23-generic과 같은 것을 보게 되실 것 입니다. 무엇이든 그것을 복사해 스크립트의 첫 번째 라인에 ($uname -r) 대신해서 붙여 넣으십시오. 그리고 한 칸을 삽입하고 build-essential을 입력하십시오. 오타 조심하시기 바랍니다. 커맨드를 완료하기 위해 탭을 누르십시오.

### Centos

루트 사용자로서 터미널 (또는 ssh 세션)에 다음을 입력합니다:

		yum groupinstall 'Development Tools'

그 후, 여러분은 터미널 상에 많은 활동과 설치를 보시게 됩니다. 가지고 있는지 확인하려면, 예를 들어, gcc 이라면, 다음의 라인을 입력하십시오:

		gcc --version

더 자세한 설명은 [여기](http://www.cyberciti.biz/faq/centos-linux-install-gcc-c-c-compiler/)를 보시기 바랍니다.

## <a id="next">다음 단계</a>

이제 여러분은 [예제들](http://nd4j.org/introduction.html)을 실행할 준비가 된 것 입니다. 저희는 여러분께서 여러분의 IDE를 착수, ND4J 프로젝트를 로드하고 예제들의 하위 디렉토리를 열기를 권장 합니다. IntelliJ 창의 왼쪽에 있는 파일 트리에서 한 예를 찾은 후 오른쪽 클릭하시고, 드롭 다운 메뉴에서 "Run"을 위한 녹색 화살표를 선택하십시오.

모든 것이 올바르게 설치 되었다면 여러분은 IntelliJ 창 하단에 프로그램 출력으로서 숫자들이 나타나는 것을 보시게 됩니다. 이들을 실험 시작을 위한 샌드 박스로 사용하십시오.

이 예제들이 익숙하시다면 POM 파일들에 정의된 디펜던시들을 변경하실 수 있습니다. [디펜던시들을 변경하는 방법은 여기에서](http://nd4j.org/gpu_native_backends.html) 배우시기 바랍니다.

## 유용한 링크:

* [ND4J Github 저장소](https://github.com/deeplearning4j/nd4j)
* [ND4J Maven 저장소](http://mvnrepository.com/artifact/org.nd4j)
* [DeepLearning4j.org](http://deeplearning4j.org)
* [DeepLearning4j Github 저장소](https://github.com/deeplearning4j/deeplearning4j)
* [DeepLearning4j Maven 저장소](http://mvnrepository.com/artifact/org.deeplearning4j)
