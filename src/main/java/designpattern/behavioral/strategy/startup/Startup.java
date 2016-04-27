package designpattern.behavioral.strategy.startup;

import designpattern.behavioral.strategy.impl.Context;
import designpattern.behavioral.strategy.impl.OperationAdd;
import designpattern.behavioral.strategy.impl.OperationMultiply;
import designpattern.behavioral.strategy.impl.OperationSubstract;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
