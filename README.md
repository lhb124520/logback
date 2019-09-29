# logback
logback日志框架demo

# 依赖
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

# 配置logback.xml
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

# additivity
additivity的作用在于 children-logger是否使用 rootLogger配置的appender进行输出。

false：表示只用当前logger的appender-ref。

true：表示当前logger的appender-ref和rootLogger的appender-ref都有效。

# 使用
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

