# Configuring & Using Logger

***
by [Stanislav Scurtu](mailto:stanislav.scurtu@gmail.com)\
Feb 2024

## Overview

Logging is an essential aspect of software development and testing as it allows developers and testers to track and
debug the application's behavior. In this material, we will learn how to configure different log levels, format log
messages, customize log outputs, and harness the power of logging frameworks like Log4j 2 and SLF4J.

## Table of Contents

- [Configure & Use Logger](#configure-&-use-logger)
   - [What is Logging?](#what-is-logging)
   - [Why is Logging Important?](#why-is-logging-important)
   - [Types of Logs](#types-of-logs)
   - [Logging Frameworks in Java](#logging-frameworks-in-java)
   - [Best Practices for Logging](#best-practices-for-logging)
- [Introduction to Log4j2 Framework](#introduction-to-log4j2-framework)
   - [What is Log4j2 Framework?](#what-is-log4j2-framework)
   - [Why should you use Log4j2?](#why-should-you-use-log4j2)
   - [How to Use Log4j2?](#how-to-use-log4j2)
      - [Log4j2 Dependency](#log4j2-dependency)
      - [Configuring Log4j2](#configuring-log4j2)
      - [Initializing and Generating Log Statements](#initializing-and-generating-log-statements)
   - [Logging to Both File and Console](#logging-to-both-file-and-console)
   - [Configuration Using a Properties File](#configuration-using-a-properties-file)
   - [Lazy Logging With Lambda Expressions](#lazy-logging-with-lambda-expressions)
      - [Benefits of Using Lambda Expressions with Log4j 2](#benefits-of-using-lambda-expressions-with-log4j-2)

## What is Logging?

Logging refers to the practice of capturing and storing information about the execution of automated tests. It involves
recording important events, errors, and other relevant details during the test execution process. Logging provides
valuable insights into the flow of the test, allowing testers and developers to analyze and debug issues that may arise
during automated testing.

## Why is Logging Important?

Logging plays a crucial role in testing for several reasons:

1. **Debugging**\
Logs are essential for identifying and diagnosing issues encountered during test execution. When an
   error
   occurs, the log files can provide valuable information such as the exact point of failure, relevant stack traces, and
   variable values at the time of error.


2. **Traceability**\
Logs serve as a record of the testing process, capturing the sequence of events and the actions
   performed
   during test execution. This traceability helps in understanding the context of failures and allows for easier
   reproduction of issues.


3. **Data Analysis**\
By analyzing log files, testers and developers can gain insights into the behavior of the
   application
   under test. Logs can reveal patterns, trends, and anomalies that may not be apparent through direct observation,
   aiding
   in root cause analysis and performance optimization.


4. **Monitoring**\
Logging also facilitates real-time monitoring of test execution. We can keep track of progress, track
   resource utilization, and identify patterns or errors that may emerge during long-running test runs. This enables
   early
   detection of issues and allows for timely intervention.

## Types of Logs

There are typically three types of logs that can be utilized:

1. **Info Logs**\
These logs provide general information about the progression of the test execution. They typically
   include
   details such as test start and end timestamps, test case identifiers, and any other relevant contextual information.
   Info logs are useful for maintaining a high-level overview of the test process.


2. **Warning Logs**\
When unexpected events or conditions are encountered during test execution, warning logs are
   utilized.
   These logs highlight irregularities or potential issues that might affect the test results. Examples of warning logs
   include validation failures, invalid test data, or external dependencies not being available.


3. **Error Logs**\
Error logs are generated when the test encounters a critical failure or exception. These logs help
   identify
   the root cause of the failure and provide detailed information about the error, including stack traces and error
   messages. Error logs are crucial for debugging and identifying issues that need to be addressed.

## Logging Frameworks in Java

Java provides several logging frameworks that can be used in testing, including:

1. **Log4j** and **Log4j 2**\
Log4j is one of the most popular logging frameworks in Java. It offers a flexible configuration, allowing
   developers to control log levels, appenders (output targets), and formatting. Log4j supports logging at different
   levels (e.g., INFO, WARN, ERROR) and enables the separation of log statements based on specific categories or
   packages.


2. **Logback**\
   Logback is a robust logging framework for Java, designed as a successor to Log4j. It offers high performance and is considered more flexible and faster than its predecessor. Logback provides advanced features such as dynamic configuration through XML, various output appenders, and conditional logging. It seamlessly integrates with SLF4J, offering a straightforward migration path from other logging frameworks. Logback is well-suited for both development and production environments, thanks to its efficient architecture and ease of use.


3. **SLF4J**\
(Simple Logging Facade for Java): SLF4J serves as a simple facade or abstraction layer for various logging
   frameworks. It provides a common interface that allows developers to switch between different logging frameworks
   without
   changing their code. SLF4J supports the usage of placeholders for dynamic logging and provides optimized performance.


4. **Java Util Logging**\
Java Util Logging is a built-in logging framework included in the Java Development Kit (JDK).
   It
   provides a basic logging API that can be used without external dependencies. Java Util Logging offers various
   configuration options, such as specifying log levels and output formats, and allows the logging properties to be set
   using configuration files.

## Best Practices for Logging

To ensure effective logging, it is important to follow these best practices:

1. **Use a Consistent Logging Format**\
Adopt a standardized logging format across the automation framework to ensure
   uniformity and ease of analysis. A consistent format helps testers and developers quickly understand the log entries
   and
   extract meaningful insights.


2. **Implement Appropriate Log Levels**\
Use the appropriate log levels (info, warn, error) to categorize log messages
   based
   on
   their importance and severity. Avoid excessive logging at lower levels, as it can clutter the log files and impact
   performance.


3. **Include Sufficient Contextual Information**\
Log messages should include relevant contextual information, such as
   the
   test
   case name, step description, and any relevant input data. This aids in traceability and assists in pinpointing issues
   during debugging.


4. **Consider Log File Rotation**\
To ensure log files don't become too large and impact performance, consider
   implementing
   log
   file rotation. This involves periodically creating new log files and storing older ones for archival purposes. Log
   rotation can also help in managing disk space usage.


5. **Enable Timestamps and Thread IDs**\
Include timestamps and thread IDs in the log entries to provide additional
   context
   and
   facilitate log analysis. Timestamps help in understanding the temporal relationship between log entries, while thread
   IDs aid in identifying concurrent log entries from multiple threads.


6. **Review and Analyze Logs**\
Regularly review and analyze the logs generated during test execution. Look for
   patterns,
   trends, and error-prone areas to identify potential improvements in the test suite or the application under test.

# Introduction to Log4j2 Framework

***

## What is Log4j2 Framework?

Log4j2 is a powerful logging framework for Java applications. It provides a flexible and efficient mechanism for
generating log statements in applications. With its extensive features and capabilities, Log4j2 simplifies the process
of logging and allows developers to easily track and analyze the behavior of their applications.

## Why should you use Log4j2?

Log4j2 offers numerous benefits that make it a popular choice for logging in Java applications. Here are some reasons
why you should consider using Log4j2:

1. **Flexible Configuration**\
   Log4j2 provides a flexible configuration mechanism that allows you to easily define various aspects of logging, such
   as log levels, appenders, and formatting options. This flexibility enables you to tailor the logging behavior
   according to your application's specific requirements.


2. **High Performance**\
   Log4j2 is designed to deliver high performance logging for your Java applications. It utilizes asynchronous logging
   and uses efficient data structures, resulting in minimal impact on application performance even when a large number
   of log statements are generated.


3. **Multiple Logging Levels**\
   Log4j2 allows you to define multiple logging levels, such as DEBUG, INFO, WARN, ERROR, etc. This enables you to
   categorize log statements based on their importance and control the amount of information generated by your
   application.


4. **Multiple Output Destinations**\
   Log4j2 supports multiple output destinations, known as appenders. These appenders allow you to log messages to
   various destinations, such as files, databases, email, and even external systems like Logstash or Elasticsearch. This
   flexibility ensures that your logging information is accessible and useful for different purposes.


5. **Contextual Logging**\
   Log4j2 provides a powerful feature called MDC (Mapped Diagnostic Context) that allows you to add contextual
   information to your log statements. This information can include details such as user ID, session ID, or any other
   relevant data. This contextual logging makes it easier to trace and analyze application behavior in specific
   scenarios.

## How to Use Log4j2?

### **Log4j2 Dependency**

Include the Log4j2 dependency in your project's build `pom.xml` file. This ensures that you can access the Log4j2
classes and functionalities in your code.

```xml
<dependencies>
    <!-- Log4j 2 API -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.22.1</version>
    </dependency>
    <!-- Log4j 2 Core -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.22.1</version>
    </dependency>
</dependencies>
```

> 🔍Ensure you're using the latest version of Log4j 2 by checking the [official Log4j 2 website](https://logging.apache.org/log4j/2.x/maven-artifacts.html#using-log4j-in-your-apache-maven-build).

### **Configuring Log4j2**:

The configuration file can
be in XML, JSON, or properties format. Customize the file to define log levels, appenders, and other properties
according to your application's needs. The configuration file should be placed in the `src/main/resources` directory.
A basic `log4j2.xml` configuration might look like this:

> 🔧This configuration defines a console appender with a simple pattern layout and sets the root logger level to INFO.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

Let's make a breakdown of what's happening in this code:

#### 1. XML Declaration

```xml
<?xml version="1.0" encoding="UTF-8"?>
```

This line declares that the file is an XML document and uses version 1.0 with UTF-8 encoding, ensuring that the file can
include characters from any human language, making it internationally readable.

#### Configuration Root Element

```xml
<Configuration status="WARN">
```

The root element of every Log4j 2 configuration file. The status attribute set to "WARN" controls the logging level for
internal Log4j 2 status messages. Here, only warnings and errors from the Log4j 2 framework itself will be printed to
the console, reducing clutter from internal Log4j 2 information messages.

#### 2. Appenders Section

**Appenders** in Log4j 2 are responsible for delivering LogEvents to their destination. It's an output destination
where
the log messages are directed, such as a file, console, database, remote server, or even custom destinations. Each
appender can have its own layout, which controls the format of the output log message. Multiple appenders can be
attached to a single logger, allowing log messages to be sent to multiple destinations.

In our case, a Console appender is defined, meaning log messages will be written to the console (standard output).

```xml
<Appenders>
    <Console name="Console" target="SYSTEM_OUT">
        <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
</Appenders>
```

* `name="Console"` Assigns a name to this appender, which can be referenced by loggers.
* `target="SYSTEM_OUT"` Specifies that the log messages should be written to the standard system output stream (
  System.out in Java).

Inside the Console appender, a PatternLayout is defined with a specific pattern for log messages:

* `%d{HH:mm:ss.SSS}` Date and time of the log event in hours, minutes, seconds, and milliseconds.
* `[%t]` Name of the thread generating the log message.
* `%-5level` Log level (like INFO, DEBUG) padded to 5 characters for alignment.
* `%logger{36}` Name of the logger, truncated to 36 characters if necessary.
* `%msg` The log message.
* `%n` A platform-independent newline character.

In practice, when your application logs a message at the INFO level (or higher) using this configuration, you'll see
output in the console that might look like this:

> `12:34:56.789 [main] INFO com.example.YourClass - This is your log message`

>📚This output reflects the pattern defined in the PatternLayout, showing the timestamp, thread name, log level, logger
name, and the log message, followed by a new line.\
📝If we consider Log4J2 for our logger framework, there are several patterns that we can choose from or customize. Refer to the [official Log4J2 documentation](https://logging.apache.org/log4j/2.x/manual/layouts.html) to learn more about them.

#### 2.1 Here are some common types of appenders in Log4j 2:

#### ConsoleAppender

The ConsoleAppender writes log events to System.out or System.err. It's often used during development to see logging
output in the console.

```xml
<Appenders>
    <Console name="Console" target="SYSTEM_OUT">
        <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
</Appenders>
```

#### FileAppender

The FileAppender writes log events to a file. It can be configured to append to or overwrite an existing file.

```xml
<Appenders>
    <File name="File" fileName="logs/app.log">
        <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
    </File>
</Appenders>
```

#### RollingFileAppender

The RollingFileAppender extends FileAppender with the capability to roll over log files based on certain criteria like
file size or time.

```xml
<Appenders>
    <RollingFile name="RollingFile" fileName="logs/app.log" filePattern="logs/app-%d{yyyy-MM-dd}.log">
        <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
        <Policies>
            <TimeBasedTriggeringPolicy interval="1" modulate="true"/>
            <SizeBasedTriggeringPolicy size="10MB"/>
        </Policies>
    </RollingFile>
</Appenders>
```

#### AsyncAppender

The AsyncAppender allows log events to be processed in a separate thread. This can improve performance by reducing
logging overhead in the application's main execution path.

```xml
<Appenders>
    <Async name="Async">
        <AppenderRef ref="Console"/>
    </Async>
</Appenders>
```

#### SMTPAppender

The SMTPAppender sends log events via email. This is particularly useful for alerting on critical errors.

```xml
<Appenders>
    <SMTP name="Mail" subject="Application Log" to="admin@example.com" from="app@example.com"
          smtpHost="smtp.example.com">
        <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
    </SMTP>
</Appenders>
```

>📂For detailed illustrations, please refer to the examples provided in the accompanying [examples folder](Log4j2 examples).

#### Custom Appenders

> 🛠️Log4j 2 allows for the creation of custom appenders if the built-in appenders do not meet specific requirements.
> Implementing a custom appender involves extending the Appender interface or one of its abstract implementations, like
> AbstractAppender.
> \
> 📚For additional information on setting up a Custom Appender, refer to the official [Log4J2 documentation](https://logging.apache.org/log4j/2.x/manual/extending.html) to learn more about them.


Appenders are a flexible way to control where and how log messages are output, and they can be configured to suit a wide
range of logging requirements.

#### 3. Loggers Section

```xml
<Loggers>
    <Root level="info">
        <AppenderRef ref="Console"/>
    </Root>
</Loggers>
```

* The `Root` logger is the ancestor of all other loggers in the application.
* `level="info"`: This sets the minimum level of messages that will be logged. Here, INFO and levels above (WARN, ERROR,
  FATAL) will be logged, while DEBUG and TRACE messages will be ignored.
* `<AppenderRef ref="Console"/>`: This ties the root logger to the previously defined Console appender, meaning all log
  messages accepted by the root logger will be output to the console as per the Console appender's configuration.

> 🔠Use appropriate **log levels** for each statement to control the verbosity of your logs and to filter them based on
> importance:
>
>`ERROR`: Use for logging errors that are critical and might cause the application to fail.\
`WARN`: Use for potentially harmful situations that warrant attention.\
`INFO`: Use for informational messages that highlight the progress of the application.\
`DEBUG`: Use for detailed information on the flow through the system, primarily useful in development.\
`TRACE`: Use for the most detailed information, such as step-by-step tracing of algorithms.

### **Initializing and Generating Log Statements**

In your application's code, initialize Log4j2 by calling the appropriate initialization
method. This
ensures that Log4j2 is ready to handle logging statements and adheres to the defined configuration.

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Example {
    private static final Logger logger = LogManager.getLogger(Log4j2Example.class);
}
```

Log statements using Log4j2's logging APIs should contain relevant information about the application's behavior, errors,
or any other details. Consider the following scenarios:

* **Initialization and Configuration**: Log the start of application components or subsystems, along with any
  significant
  configuration settings.

```java
public void initializeComponent() {
    logger.info("Initializing component X with configuration Y...");
    // Initialization logic...
    logger.info("Component X initialized successfully.");
}
```

* **Method Entry and Exit**: For critical methods, log at the start and end, possibly including key parameter values or
  method results.

```java
public int performCalculation(int input) {
    logger.debug("Entering performCalculation with input: {}", input);
    // Calculation logic...
    logger.debug("Exiting performCalculation with result: {}", result);
    return result;
}
```

* **Conditional Branches**: In important conditional branches, especially in error handling or unusual conditions, add
  log
  statements to indicate which path the execution is taking.

```java
if (user.isValid()) {
  logger.info("User {} is valid, proceeding to process", user.getName());
  // Process user...
} else {
  logger.warn("User {} is not valid, aborting process", user.getName());
  // Handle invalid user...
}
```

* **Exceptions**: Always log exceptions, including stack traces, to aid in debugging. Catch blocks are ideal places for
  logging errors or warnings.

```java
try {
    // Some operation that might throw an exception
} catch (SpecificException ex) {
    logger.error("An error occurred processing XYZ: {}", ex.getMessage(), ex);
    // Handle exception...
}
```

* **Performance Metrics**: Log performance-related information, such as the time taken to execute a critical section of
  code.

```java
long startTime = System.currentTimeMillis();
// Perform time-consuming operation...
long endTime = System.currentTimeMillis();
logger.info("Operation completed in {} ms", (endTime - startTime));
```

* **User Actions**: In applications with significant user interaction, log user actions to understand user behavior and
  potential issues.

```java
public void loginUser(String username, String password) {
    logger.info("Login attempt for user: {}", username);
    try {
        // Authentication logic...
        logger.info("User {} logged in successfully", username);
    } catch (AuthenticationException ex) {
        logger.error("Failed login attempt for user {}: {}", username, ex.getMessage());
        // Handle authentication failure...
    }
}
```

> 🔍Monitor and analyze the generated log output to gain insights into your application's
> behavior,
> troubleshoot issues, or track specific events. Use the configured appenders to direct log messages to the desired
> destinations for further analysis.

## Logging to Both File and Console

This is very useful in a non-prod environment where we may want to see debug messages in the console, and we may want to persist the higher level logs to a file for later analysis.

To configure Log4j2 to log to both a file and the console, we would typically use a configuration file where we define Appenders for each output target and a Logger that references these appenders. Log4j 2 supports various types of configuration files, including XML, JSON, YAML, and properties files. Below is an example of how to do this with an XML configuration file.
>📄The XML configuration below defines two appenders: one for logging to the console (Console) and another for logging to a file (File), and it attaches both appenders to the root logger.
### Log4j2 XML Configuration Example

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="ConsoleAppender" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
        </Console>
        <File name="FileAppender" fileName="app.log" append="true">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="ConsoleAppender"/>
            <AppenderRef ref="FileAppender"/>
        </Root>
    </Loggers>
</Configuration>
```
#### Explanation of the Configuration Elements:
* `<Configuration>`: The root element of the configuration file.
* `<Appenders>`: This section defines all the appenders you'll use.
* `<Console>`: An appender for logging to the console. `target="SYSTEM_OUT"` specifies that log messages should be written to standard out.
* `<File>`: An appender for logging to a file. `fileName="app.log"` specifies the name of the log file.
* `<PatternLayout>`: This element within each appender defines the format of log messages. The pattern provided here is just an example; you can customize it according to your needs.
* `<Loggers>`: This section defines the loggers and their levels.
* `<Root>`: The root logger of the application. The `level="info"` attribute specifies that INFO and higher level messages (WARN, ERROR, FATAL) will be logged. Lower level messages (DEBUG, TRACE) will be ignored.
* `<AppenderRef>`: These elements link the appenders to the root logger. Both the console and file appenders are referenced here, so log messages will go to both destinations.

>🚀With the log4j2.xml configuration file in place, Log4j 2 will automatically detect and load it when our application starts. And we don't need to manually load this configuration file in our code.\
>👀When we run our application, we should see the log messages in both the console and the app.log file, formatted according to the pattern we specified in the configuration file.

## Configuration Using a Properties File

Unlike Log4j, which supports configuration only through properties and XML formats, we can define the Log4j 2 configurations using JSON, XML, YAML, or properties format. All these formats are functionally equivalent. Therefore, we can easily convert the configuration done in one format to any other.

When Log4j 2 was released, it didn’t have the support for configuration through the properties file. It started supporting the properties file from the release of version 2.4.
\
The default properties configuration file is always` log4j2.properties`. The Logger gets the reference of this file from the CLASSPATH.
\
The system property may refer to a local file system or may contain a URL. Log4j2 provides a DefaultConfiguration if it cannot locate a configuration file. In this case, we get the logging output redirected to the console and the root logger level set to ERROR.

>📝The `log4j2.properties` file is a simple, key-value pair format that is easy to read and write.

### Syntax of the log4j2.properties File

The syntax of the `log4j2.properties` file isn’t the same as that of log4j.properties. In the log4j.properties file, every configuration starts with ‘log4j‘, while this has been omitted in the log4j2.properties configuration.

Here's an example `log4j2.properties` file that configures Log4j 2 to log to both the console and a file:

```properties
status = error
name = PropertiesConfig

# Define the appender for the console
appender.console.type = Console
appender.console.name = ConsoleAppender
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

# Define the appender for the file
appender.file.type = File
appender.file.name = FileAppender
appender.file.fileName = logs/app.log
appender.file.layout.type = PatternLayout
appender.file.layout.pattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
appender.file.append = true

# Set the root logger level to INFO and attach the console and file appenders
rootLogger.level = info
rootLogger.appenderRef.console.ref = ConsoleAppender
rootLogger.appenderRef.file.ref = FileAppender
```

#### Explanation of Configuration Elements
* `status = error`: Sets the log level for internal Log4j 2 status logging. It's helpful for debugging Log4j 2 issues.

* `name = PropertiesConfig`: An arbitrary name for your configuration.

Appenders section:

* `appender.console.type = Console`: Defines a console appender.
* `appender.console.name = ConsoleAppender`: Sets a name for the console appender.
* `appender.console.layout.type = PatternLayout`: Specifies that this appender will use a pattern layout.
* `appender.console.layout.pattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n`: Defines the pattern for log messages. This pattern includes the timestamp, log level, logger name, line number, and the log message.
* `appender.file.type = File`: Defines a file appender.
* `appender.file.name = FileAppender`: Sets a name for the file appender.
* `appender.file.fileName = logs/app.log`: Specifies the log file's name and path.
* `appender.file.layout.type = PatternLayout`: defines the layout for file logging
* `appender.file.layout.pattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n`: Similar to the console appender, defines the pattern for file logging.
* `appender.file.append = true`: Indicates that log messages should be appended to the file if it already exists.

Logger section:

* `rootLogger.level` = info: Sets the logging level for the root logger. In this case, it's set to INFO, meaning that INFO, WARN, ERROR, and FATAL messages will be logged, while DEBUG and TRACE messages will be ignored.
* `rootLogger.appenderRef.console.ref` = ConsoleAppender and rootLogger.appenderRef.file.ref = FileAppender: Attaches the defined appenders to the root logger.

>🔄With the log4j2.properties file in place, Log4j 2 will automatically detect and use it when your application starts. You don't need to manually load this configuration in your code

## Lazy Logging With Lambda Expressions
Lambda expressions are a feature introduced in Java 8 that allows you to treat functionality as a method argument or code as data. A lambda expression can be understood as a concise representation of an anonymous function that can be passed around. It consists of a list of parameters, a body, a return type, and a set of thrown exceptions.
\
A potential performance improvement for applications that use logging can result from avoiding the calculation of log messages if the corresponding log level is not enabled.

First, let’s see a simple log statement at TRACE level:

```java
logger.trace("Number is {}", getRandomNumber());
```
In this example, the getRandomNumber() method is called to substitute the log message parameter regardless of whether TRACE statements are displayed or not. For example, if the log level is set to DEBUG, log4j 2 will not log the message, but the getRandomNumber() method still runs.
\
In other words, the execution of this method may be unnecessary.

Before the addition of support for lambda expressions, we could avoid constructing messages which are not logged by explicitly checking the log level before executing the log statement:

```java
if (logger.isTraceEnabled()) {
    logger.trace("Number is {}", getRandomNumer());
}
```
In this case, the getRandomNumber() method is only called if the TRACE log level is enabled. This can improve performance depending on how expensive the execution of methods used to substitute parameters is.
\
By using lambda expressions, we can further simplify the code above:

```java
logger.trace("Number is {}", () -> getRandomNumber());
```

The lambda expression is only evaluated if the corresponding log level is enabled. This is referred to as lazy logging.
\
We can also use multiple lambda expressions for a log message:

```java
logger.trace("Name is {} and age is {}", () -> getName(), () -> getRandomNumber());
```
### Benefits of Using Lambda Expressions with Log4j 2

* **Performance Optimization**: By deferring the evaluation of log messages, lambda expressions help avoid unnecessary computation, improving the application's performance.
* **Code Clarity**: Lambda expressions can lead to more readable and concise code, making it easier to understand the logging logic.
* **Functional Programming Style**: They allow for a more functional programming style in Java, making your logging statements part of functional pipelines if needed.

>🎉In conclusion, the integration of lambda expressions into Log4j 2 provides significant benefits, particularly in terms of performance optimization and code readability, making it a powerful feature for developers logging in Java applications.

[Back to top](#table-of-contents)