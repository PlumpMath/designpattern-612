package designpattern.behavioral.cor.impl;

import designpattern.behavioral.cor.AbstractLogger;

/**
 * Created by kimi on 4/27/16.
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
