Gradle 使用指南
===================


##Gradle简介
-------------

>  From mobile apps to microservices, from small startups to big enterprises, Gradle helps teams build, automate and deliver better software, faster.

简而言之，Gradle是个**自动化构建**工具，帮助我们提高开发效率。Gradle采用了脚本语言**Groovy**替代了传统的XML作为其构建脚本，更加简洁清晰。

#### **Gradle 下载与安装**

自行参考： https://docs.gradle.org/3.5/userguide/installation.html

#### **Gradle Wrapper**
为了解决不同机器上Gradle版本不同和下载安装的问题，官方推荐在项目中使用Gradle Wrapper来解决这些问题。

当项目中使用了Gradle Wrapper，使用以下命令来执行任务：
>- ./gradlew <task> （在类Unix平台上，如Linux和Mac OS X）
>- gradlew <task> （在Windows上使用gradlew.bat批处理文件）

Gradle Wrapper绑定了一个特定的Gradle版本，你可以任意替换它，当执行任务时，若机器上不存在指定的Gradle版本则会自动下载对应的版本。

执行gradle wrapper --gradle-version X.X 将Gradle Wrapper安装到你的项目之中。

以下文件将会添加至项目之中：

      gradlew
      gradlew.bat
      gradle/wrapper/
        gradle-wrapper.jar
        gradle-wrapper.properties

这些文件应该被添加至**版本控制工具**之中，之后任何机器都可在其目录下执行gradlew构建命令了。

#### **依赖管理基础**

自动将项目所需的外部依赖和其传递依赖引进项目。

示例:

    repositories {
        mavenCentral()
    }
    
    dependencies {
        compile 'org.hibernate：hibernate-core：3.6.7.Final'
    }

repositories告诉Gradle去哪里寻找依赖，示例中使用了Maven的中心库。
dependencies中声明需要引入的外部依赖，其中compile为依赖关系，随后指定了一个hibernate的版本。

默认提供了四个基本的依赖关系为compile, runtime, testCompile和testRuntime，可以通过插件进行扩展。

##基本概念
-------------

#### **Projcet与Task**

Gradle 命令会从当前目录下寻找 build.gradle 文件来执行构建。我们称 build.gradle 文件为构建脚本。严格来说这其实是一个**构建配置脚本**，这个构建脚本**定义了一个 project 和一些默认的 task**。

> Everything in Gradle sits on top of two basic concepts: projects and tasks.

project的概念不是很清晰，但是在我们项目中编写的build.gradle实际上就是在定义一个projcet对象。一个project有着多个task，每个 task 都代表了构建执行过程中的一个原子性操作。如编译，打包，生成 javadoc，发布到某个仓库等操作。

我们在build.gradle实际上无非是调用方法和为porject对象设置属性。如：

    //调用apply方法 引入插件
    apply plugin: 'java'
    apply plugin: 'eclipse'
	//设置属性
    sourceCompatibility = 1.5
    version = '1.0'
我们调用一些未定义的方法和属性时，将自动委托为project对象来完成，上面的方法和属性都是默认定义在project之中的。

当我们写了一个空的build.gradle文件时，就已经有了一些默认的task，如进行初始化的init任务、生成GradleWapper文件的wrapper任务和一些用于显示porject信息的help任务。

task用于完成一直对项目的操作，我们可以使用groovy来自定义一些我们想要的操作，通过在build.gradle编写：

    task hello {
        doLast {
            println'Hello world！'
        }
    }
执行该任务则会简单的打印出'Hello world！'，实际我们是调用了task方法，传入了一个闭包来创建了一个task，这个task会作为project的一个属性。

#### **插件**

Gradle自身提供的功能很少，大部分功能都是通过使用插件来完成，下面以Java插件为例介绍插件的功能。

将插件应用于项目允许插件扩展项目的功能。它可以做如下事情：

1.扩展Gradle模型（例如添加可配置的新DSL元素）
2.根据约定配置项目（例如，添加新任务或配置合理的默认值）
3.应用特定配置（例如添加组织存储库或执行标准）

通过应用插件，而不是向项目构建脚本添加逻辑，我们可以获得许多好处：

1.促进重用，并减少跨多个项目维护类似逻辑的开销
2.允许更高程度的模块化，增强可理解性和组织
3.封装命令逻辑，并允许构建脚本尽可能声明性

通过添加apply plugin: 'java'，来使用java插件。它会帮助我们创建一系列相关的任务，如jar任务来进行打包，引入了resourceSet模型来表示java资源集，设置一些默认值如src/main/java为编译路径等。通过引入插件我们获得对java项目的构建功能。

更详细的java插件介绍可以参考 http://wiki.jikexueyuan.com/project/gradle/java-package.html 。

 
##与Eclipse集成编写web项目
-------------

#### **War插件**
首先我们需要在项目中使用war插件，War 的插件继承自 Java 插件并添加了对组装 web 应用程序的 WAR 文件的支持。它禁用了 Java 插件生成默认的 JAR archive，并添加了一个默认的 WAR archive 任务。

War插件主要功能为：
1.提供了war任务将项目打包成war。
2.增加了名为providedCompile和providedRuntime的两个依赖配置。
3.设置了些默认值，如src/main/webapp作为web资源目录。

#### **eclipse-wtf插件**

eclipse插件生成eclipse IDE使用的文件，因此可以将项目导入到Eclipse。eclipse-wtf插件基于eclipse，生成eclipse web项目需要的配置文件。

插件会生成一些处理eclipse配置文件的方法，和增加一些属性使得我们可以对eclipse进行一些配置。

#### **使用eclipse插件支持gradle**

在elipse marketplace中下载buildship让eclipse获得对gradle的功能支持。


