package designpattern.behavioral.visitor.impl;

import designpattern.behavioral.visitor.ComputerPart;
import designpattern.behavioral.visitor.ComputerPartVisitor;

/**
 * Created by kimi on 4/27/16.
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
