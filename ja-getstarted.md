---
layout: page
title: "Getting Started"
description: ""
---
{% include JB/setup %}

ND4Jを始めるためには、以下のプログラムをインストールする必要があります。

1. [Java](#1-java)を活用することで、新たなプロジェクトを編集することができます。[ダウンロード](https://java.com/ja/download/)
2. [Github](#2-github)を活用することで、ND4Jに関するデータを一元管理することができます。[Macはこちら](https://mac.github.com/), [Windowsはこちら](https://windows.github.com/)
3. [Maven](#3-maven)を活用することで、最新版のND4Jの[JAR](http://ja.wikipedia.org/wiki/JAR_%28%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%83%95%E3%82%A9%E3%83%BC%E3%83%9E%E3%83%83%E3%83%88%29)を自動的にアップロードし続けることができます。[ダウンロード](https://maven.apache.org/download.cgi)
4. [IDE for Java](#4-ide-for-java)は、上記のプログラムを実行するためのシステム環境になります。[ダウンロード](https://www.jetbrains.com/idea/download/)


<iframe width="750" height="560" src="//www.youtube.com/embed/D0TrW9ht2Qo" frameborder="0" allowfullscreen></iframe>

この手順に沿ってダウンロードすれば、どなたでも簡単にND4Jをスタートすることができます。

# <a id="1-java">1. Java</a>

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

# <a id="2-github">2. GitHub</a>

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

# <a id="3-maven">3. Maven</a>

### Mavenとは
 MavenとはJava用プロジェクト管理ツールです。([Mavenホームページ](http://maven.apache.org/what-is-maven.html)) Mavenをインストールすることで、最新版のND4Jの[JAR](http://ja.wikipedia.org/wiki/JAR_%28%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%83%95%E3%82%A9%E3%83%BC%E3%83%9E%E3%83%83%E3%83%88%29)を自動的にアップロードし続けることができます。

### なぜ必要か
 Mavenを活用することで、より簡単にND4JとDeeplearning4j projectsをインストールすることができます。なお、最終的にダウンロードする[IDE](http://ja.wikipedia.org/wiki/%E7%B5%B1%E5%90%88%E9%96%8B%E7%99%BA%E7%92%B0%E5%A2%83)を操作するうえでも、Mavenは役立ちます。([IDE](https://github.com/globalcaos/nd4j/blob/gh-pages/getstarted.md#4-ide-for-java))また、もしMavenの内容をご理解いただいている方は、[当社ホームページ](http://nd4j.org/downloads.html) ページにアクセスいただくことで、この過程をスキップすることができます。

### イントール状況の確認
コマンドラインに、以下のコードをご入力ください。

		mvn --version

### インストール方法
[Mavenホームページ](https://maven.apache.org/download.cgi)を通じて、無料でダウンロードいただけます


お持ちのパソコンのオペレーティングシステムに適応する、最新版のMavenを含む圧縮ファイルをダウンロードしてください。
以下の文章はオペレーティングシステムの例になります。

*"Unix-based Operating Systems (Linux, Solaris and Mac OS X)."* 

もしND4Jを修正したい場合は、 ソフトウェアを*git clone*してください。ND4J　dictionaryでMavenに以下のコマンドを入力してください。

    mvn clean install -DskipTests -Dmaven.javadoc.skip=true


# <a id="4-ide-for-java">4. IDE for Java</a>

### IDEとは

[IDE](http://encyclopedia.thefreedictionary.com/integrated+development+environment)とは、ソフトウェアの開発において用いられるエディタ、コンパイラ、リンカ、デバッガ、その他の支援ツールなどを統合・統一化した開発環境のことを指します。IDEには、ソフトウェア開発に必要な最低限のツールがすべて含まれているため、これを導入することで、インストールしたMaveとGitHubの操作を統一して行うことができます。 
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

# Next Steps

 これで[当社ホームページ](../elementwise.html)にあるプロジェクトを実行する準備が整いました。ダウンロードいただいたIDE上で、いずれか一つのプロジェクトをクリックし、(Run)ボタンを押すことで実行できます。すべてが正しくダウンロードされていた場合、画面に数字が表示され、アウトプットを確認することができます。

操作環境にご満足頂いた場合は、POMファイルのdependenciyを変更することも可能です。dependencyの変更方法は [こちら](http://nd4j.org/dependencies.html).

質問やフィードバックに関しては、 [Google Groups Forum](https://groups.google.com/forum/#!forum/nd4j)までお願いいたします。

その他リンク:

*  [ND4Jとは](http://nd4j.org/) 。ND4Jに関するGitHubのファイルは [こちら](https://github.com/SkymindIO/nd4j)
*  [DeepLearning4Jとは](http://deeplearning4j.org/)。DeepLearning4Jに関するGitHubのファイルは [こちら](https://github.com/SkymindIO/deeplearning4j).
