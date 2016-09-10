package designpattern.behavioral.visitor.impl;

import designpattern.behavioral.visitor.ComputerPart;
import designpattern.behavioral.visitor.ComputerPartVisitor;

/**
 * Created by kimi on 4/27/16.
 */
public class Computer implements ComputerPart {
    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
    }
    
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
