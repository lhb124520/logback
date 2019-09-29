## Java日志框架logback使用

## 介绍

Logback是由log4j创始人设计的又一个开源日志组件。

logback当前分成三个模块：logback-core,logback- classic和logback-access。logback-core是其它两个模块的基础模块。
logback-classic是log4j的一个 改良版本。
此外logback-classic完整实现SLF4J API，
使你可以很方便地更换成其它日志系统如log4j或JDK14 Logging。
logback-access访问模块与Servlet容器集成提供通过Http来访问日志的功能。


## slf4j和log4j以及logback的联系和区别
1、slf4j是java的一个日志门面，实现了日志框架一些通用的api，不能单独使用。log4j和logback是具体的日志框架。

2、log4j和logback可以单独的使用，也可以绑定slf4j一起使用。

## 官方文档
[https://logback.qos.ch/manual/configuration.html](https://logback.qos.ch/manual/configuration.html)


## maven仓库依赖


       <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-ext</artifactId>
            <version>1.7.25</version>
        </dependency>

        <!--可选-->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>1.2.3</version>
        </dependency>
        <!--可选-->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-access</artifactId>
            <version>1.2.3</version>
        </dependency>

## 配置logback.xml

```
<?xml version="1.0" encoding="UTF-8" ?>
<configuration>

    <appender name="STDOUT"
              class="ch.qos.logback.core.ConsoleAppender">
        <!-- encoders are assigned by default the type
             ch.qos.logback.classic.encoder.PatternLayoutEncoder -->
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!--设置多个记录器的级别-->
    <logger name="com.demo.TestMain" level="INFO"/>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <!-- encoders are assigned the type
             ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!--设置输出到文件格式-->
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>myApp.log</file>
        <encoder>
            <pattern>%date %level [%thread] %logger{10} [%file:%line] %msg%n</pattern>
        </encoder>
    </appender>

    <!--设置是否可加性，即只用当前logger的appender-ref-->
    <logger name="com.demo.MyApp1" additivity="false">
        <appender-ref ref="FILE"/>
    </logger>

    <!--设置root记录器的级别-->
    <root level="trace">
        <appender-ref ref="FILE"/>
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```

## 使用logback

```
package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApp1 {
    private final static Logger logger = LoggerFactory.getLogger(MyApp1.class);

    public static void main(String[] args) {
        logger.trace("Entering application.");
        logger.debug("Entering application.");
        logger.info("Entering application.");
        logger.warn("Entering application.");
        logger.error("Entering application.");

    }
}
```

## 源码
GitHub：[https://github.com/lhb124520/logback](https://github.com/lhb124520/logback)

码云：[https://gitee.com/lhblearn/logback](https://gitee.com/lhblearn/logback)



