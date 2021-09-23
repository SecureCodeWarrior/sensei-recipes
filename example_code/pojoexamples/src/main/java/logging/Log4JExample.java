package logging;

import org.apache.log4j.*;
import org.apache.log4j.spi.LoggerFactory;

import java.io.*;
import java.sql.SQLException;

// https://logging.apache.org/log4j/2.x/manual/migration.html
public class Log4JExample{

    /* Get the class name to be printed on */
    static Logger log = Logger.getLogger(Log4JExample.class.getName());
    static Logger log2 = Logger.getRootLogger();
    static Logger log3 = LogManager.getRootLogger();
    static Logger log4 = Logger.getLogger("name", (LoggerFactory) null);

    public static void main(String[] args)throws IOException,SQLException{
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");

        Level level = log.getEffectiveLevel();

        LogManager.shutdown();
        log.setLevel(Level.DEBUG);
        log.setLevel(Level.INFO);
        log.setLevel(Level.TRACE);
        log.setLevel(Level.WARN);
        log.setLevel(Level.ERROR);
        log.setLevel(Level.FATAL);

        log.log(Level.DEBUG, "some message");
        log.log(Level.INFO, "some message");
        log.log(Level.TRACE, "some message");
        log.log(Level.WARN, "some message");
        log.log(Level.ERROR, "some message");
        log.log(Level.FATAL, "some message");

        Throwable e = new Exception();
        log.log(Level.DEBUG, "some message", e);
        log.log(Level.INFO, "some message", e);
        log.log(Level.TRACE, "some message", e);
        log.log(Level.WARN, "some message", e);
        log.log(Level.ERROR, "some message", e);
        log.log(Level.FATAL, "some message", e);

    }

    /*
    org.apache.log4j.Logger.getLogger() -> org.apache.logging.log4j.LogManager.getLogger()
    org.apache.log4j.Logger.getRootLogger() -> org.apache.logging.log4j.LogManager.getRootLogger()
    org.apache.log4j.LogManager.getRootLogger() -> org.apache.logging.log4j.LogManager.getRootLogger()
    org.apache.log4j.Logger.getLogger with LoggerFactory, remove factory and use v2's other extensions
    org.apache.log4j.Logger.getEffectiveLevel() -> org.apache.logging.log4j.Logger.getLevel()
    org.apache.log4j.LogManager.shutdown() -> Log4j Core now automatically adds a JVM shutdown hook
    (v2.1 ShutdownCallbackRegistry to override hooks)
    (v2.6 Manual shutdown using org.apache.logging.log4j.LogManager.shutdown())
    org.apache.log4j.Logger.setLevel() or similar -> replace or org.apache.logging.log4j.core.config.Configurator.setLevel()
    use parameterized messages instead of String concatenation
    org.apache.log4j.MDC and org.apache.log4j.NDC -> the Thread Context.
     */

    /* XML v1

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "log4j.dtd"> <-- gone
    <log4j:configuration xmlns:log4j='http://jakarta.apache.org/log4j/'> <-- rename Configuration
      <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender"> <-- rename Console and split
        <layout class="org.apache.log4j.PatternLayout"> <-- merged below
          <param name="ConversionPattern" value="%d %-5p [%t] %C{2} (%F:%L) - %m%n"/>
        </layout>
      </appender>
      <category name="org.apache.log4j.xml"> <-- rename Logger, merge below
        <priority value="info" /> <-- rename level
      </category>
      <Root> <-- part of Loggers, merge below
        <priority value ="debug" />
        <appender-ref ref="STDOUT" /> <-- rename
      </Root>
    </log4j:configuration>

     */

    /* XML v2

    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration>
      <Appenders> <-- inserted
        <Console name="STDOUT" target="SYSTEM_OUT">
          <PatternLayout pattern="%d %-5p [%t] %C{2} (%F:%L) - %m%n"/>
        </Console>
      </Appenders>
      <Loggers> <-- inserted
        <Logger name="org.apache.log4j.xml" level="info"/>
        <Root level="debug">
          <AppenderRef ref="STDOUT"/>
        </Root>
      </Loggers>
    </Configuration>

     */
}