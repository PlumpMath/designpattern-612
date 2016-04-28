package designpattern.others.interceptingfilter.impl;

/**
 * Created by kimi on 4/28/16.
 */
public class Target {
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}
