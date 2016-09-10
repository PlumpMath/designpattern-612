package designpattern.behavioral.cor.startup;

import designpattern.behavioral.cor.AbstractLogger;
import designpattern.behavioral.cor.impl.ConsoleLogger;
import designpattern.behavioral.cor.impl.ErrorLogger;
import designpattern.behavioral.cor.impl.FileLogger;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
