package designpattern.behavioral.cor.impl;

import designpattern.behavioral.cor.AbstractLogger;

/**
 * Created by kimi on 4/27/16.
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
