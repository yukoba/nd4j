---
layout: ja-default
title: "ND4J入門"
description: ""
---
{% include JB/setup %}

ND4Jを始めるためには、以下のプログラムをインストールする必要があります。

1. [Java](#java)を活用することで、新たなプロジェクトを編集することができます。[ダウンロード](https://java.com/ja/download/)
2. [Integrated Development Environment](#ide-for-java)は、上記のプログラムを実行するためのシステム環境になります。[ダウンロード](https://www.jetbrains.com/idea/download/)
3. [Maven](#maven)を活用することで、最新版のND4Jの[JAR](http://ja.wikipedia.org/wiki/JAR_%28%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%83%95%E3%82%A9%E3%83%BC%E3%83%9E%E3%83%83%E3%83%88%29)を自動的にアップロードし続けることができます。[ダウンロード](https://maven.apache.org/download.cgi)
4. [Github](#github)を活用することで、ND4Jに関するデータを一元管理することができます。[Macはこちら](https://mac.github.com/), [Windowsはこちら](https://windows.github.com/)

<iframe width="750" height="560" src="//www.youtube.com/embed/aWQsQQoTm9Y" frameborder="0" allowfullscreen></iframe>

この手順に沿ってダウンロードすれば、どなたでも簡単にND4Jをスタートすることができます。

# <a id="java">Java</a>

### Javaとは何か
 [Java](http://ja.wikipedia.org/wiki/Java)とは、プログラミング言語及びコンピュータープラットフォームのことを指します。

### なぜ必要か
 Janaを活用することでプラットフォームに依存しないアプリケーションソフトウェアの開発と配備を行うことができます。

### Javaのバージョン確認方法
 コマンドラインに以下の文書を入力することで、既にインストールされているJavaのバージョンを確認することができます。

		java -version

 ND4Jを始めるためには「Java7」が必要になるため、古いバージョンをお使いの場合には、再度インストールが必要になります。

### インストール方法
 最新のJavaは[オラクルホームページ](https://java.com/ja/download/)を通じて、無料でダウンロードいただけます。ダウンロード方法はお使いの端末によって異なります。

# <a id="ide-for-java">Integrated Development Environment</a>

### Integrated Development Environmentとは

Integrated Development Environment[[IDE]](http://encyclopedia.thefreedictionary.com/integrated+development+environment)とは、ソフトウェアの開発において用いられるエディタ、コンパイラ、リンカ、デバッガ、その他の支援ツールなどを統合・統一化した開発環境のことを指します。IDEには、ソフトウェア開発に必要な最低限のツールがすべて含まれているため、これを導入することで、インストールしたMaveとGitHubの操作を統一して行うことができます。 
### なぜIDEが必要か

IDSを活用することで、コードを入力するだけで簡単にシステムをセットアップができるようになります。IDEは一般的にMavenとセットで使われるため、Mavenのダウンロードをおすすめしております。

### イントール状況の確認

インストールプログラムをご確認ください。

### インストール方法

[intellij](https://www.jetbrains.com/idea/download/)のfree community editionをお勧めいたします。

以下のIDEも同様にご活用いただけます。

[Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html) or [Netbeans](http://wiki.netbeans.org/MavenBestPractices).

インストール後、以下のサイトからND4Jプロジェクトをダウンロードいただけます。

[Intellijの場合](http://stackoverflow.com/questions/1051640/correct-way-to-add-lib-jar-to-an-intellij-idea-project)、
[Eclipseの場合](http://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse) 、 [Netbeansの場合](http://gpraveenkumar.wordpress.com/2009/06/17/abc-to-import-a-jar-file-in-netbeans-6-5/)



# <a id="maven">Maven</a>

### Mavenとは
 MavenとはJava用プロジェクト管理ツールです。([Mavenホームページ](http://maven.apache.org/what-is-maven.html)) Mavenをインストールすることで、最新版のND4Jの[JAR](http://ja.wikipedia.org/wiki/JAR_%28%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%83%95%E3%82%A9%E3%83%BC%E3%83%9E%E3%83%83%E3%83%88%29)を自動的にアップロードし続けることができます。

### なぜ必要か
 Mavenを活用することで、より簡単にND4JとDeeplearning4j projectsをインストールすることができます。なお、最終的にダウンロードする[IDE](http://ja.wikipedia.org/wiki/%E7%B5%B1%E5%90%88%E9%96%8B%E7%99%BA%E7%92%B0%E5%A2%83)を操作するうえでも、Mavenは役立ちます。([IDE](https://github.com/globalcaos/nd4j/blob/gh-pages/getstarted.md#4-ide-for-java))また、もしMavenの内容をご理解いただいている方は、[当社ホームページ](http://nd4j.org/downloads.html) ページにアクセスいただくことで、この過程をスキップすることができます。

### イントール状況の確認
コマンドラインに、以下のコードをご入力ください。

		mvn --version

### インストール方法
[Mavenホームページ](https://maven.apache.org/download.cgi)を通じて、無料でダウンロードいただけます

![Alt text](../img/maven_downloads.png) 

ページの下部にある、お使いのOperating Systemごとの説明に沿って、インストールを進めてください。
 “Unix-based Operating Systems (Linux, Solaris and Mac OS X).”はこのような形で表示されております。
 
![Alt text](../img/maven_OS_instructions.png) 

ここまでの作業を完了すると、IDEを使って新しいプロジェクトを作ることができます。

![Alt text](../img/new_maven_project.png) 

IntelliJのWindowを通じて、下に表示されている画面が表示されます。まずはじめに名前を入力します。

![Alt text](../img/maven2.png) 

 "Next"を押していただくと、次のウィンドウが表示されますので、"ND4J"と名前を入力してください。
 これでIntelliJのpom.xml fileにアクセスでき、以下のよう表示されます。
 
 ![Alt text](../img/nd4j_pom_before.png) 
 
 
 次に<dependencies>セクションにdepemdencyを加えていく必要があります。これはCPUsやGPUsによって異なりますので、それぞれに適応する形で"nd4j-api"と a linear-algebra backend like "nd4j-jblas" か"nd4j-jcublas"を選択してください。これらはすべて <a href="http://search.maven.org/#search%7Cga%7C1%7Cnd4j-jblas">こちら</a>から取得できます。 "latest version" を選択し、コピーを行ってください。
 
 ![Alt text](../img/nd4j_maven.png)
 
 コピーした内容を<dependencies>セクションにペーストすると、以下の表示内容になります。
 
 ![Alt text](../img/nd4j_pom_after.png) 
 
 これで設定は完了になります。これ以降はIntelliJに新たなファイルを作ることも、 ND4Jの APIを利用することも可能になります。
 もし新たなアイデアが必要な場合には、[intro](http://nd4j.org/introduction.html)をご覧ください。


# <a id="github">GitHub</a>

### GitHubとは
 [Github](http://en.wikipedia.org/wiki/GitHub) は [Revision Control System](http://ja.wikipedia.org/wiki/Revision_Control_System)に基づいた、ソフトウェア開発プロジェクトのための共有ウェブサービスであり, [open source](http://ja.wikipedia.org/wiki/オープンソース) projects向けの無料アカウントを提供しています。

### なぜ必要か
 GitHubはこのシステムを使う上で必ずしも必要なものではありません。しかし、ND4Jファイルのダウンロードやプロジェクトの状況、バグの報告をチームメンバー間で共有する際には、GitHubが役立ちます。

### イントール状況の確認
 インストールプログラムにて、ご確認いただけます。

### インストール方法
 以下のURLを通じて無料でダウンロードいただけます。
 
[Macはこちら](https://mac.github.com/), [Windowsはこちら](https://windows.github.com/)

ND4Jのファイルを複製するためには以下の文章をterminal (Mac) もしくは Git Shell (Windows)へ入力してください。

      git clone https://github.com/SkymindIO/nd4j
      
# Next Steps

 これで[当社ホームページ](../elementwise.html)にあるプロジェクトを実行する準備が整いました。ダウンロードいただいたIDE上で、いずれか一つのプロジェクトをクリックし、(Run)ボタンを押すことで実行できます。すべてが正しくダウンロードされていた場合、画面に数字が表示され、アウトプットを確認することができます。

操作環境にご満足頂いた場合は、POMファイルのdependencyを変更することも可能です。dependencyの変更方法は [こちら](http://nd4j.org/dependencies.html).

質問やフィードバックに関しては、 [Google Groups Forum](https://groups.google.com/forum/#!forum/nd4j)までお願いいたします。

その他リンク:

*  [ND4Jとは](http://nd4j.org/) 。ND4Jに関するGitHubのファイルは [こちら](https://github.com/SkymindIO/nd4j)
*  [DeepLearning4Jとは](http://deeplearning4j.org/)。DeepLearning4Jに関するGitHubのファイルは [こちら](https://github.com/SkymindIO/deeplearning4j).
