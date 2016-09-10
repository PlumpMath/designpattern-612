package designpattern.behavioral.strategy.impl;

import designpattern.behavioral.strategy.Strategy;

/**
 * Created by kimi on 4/27/16.
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
