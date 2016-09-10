package designpattern.behavioral.strategy.impl;

import designpattern.behavioral.strategy.Strategy;

/**
 * Created by kimi on 4/27/16.
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
