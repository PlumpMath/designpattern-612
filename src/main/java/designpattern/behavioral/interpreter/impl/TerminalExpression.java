package designpattern.behavioral.interpreter.impl;

import designpattern.behavioral.interpreter.Expression;

/**
 * Created by kimi on 4/27/16.
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
