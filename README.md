# logback
logback日志框架demo

# additivity
additivity的作用在于 children-logger是否使用 rootLogger配置的appender进行输出。

false：表示只用当前logger的appender-ref。

true：表示当前logger的appender-ref和rootLogger的appender-ref都有效。
