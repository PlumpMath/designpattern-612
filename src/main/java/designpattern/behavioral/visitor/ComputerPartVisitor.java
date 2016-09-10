package designpattern.behavioral.visitor;

import designpattern.behavioral.visitor.impl.Computer;
import designpattern.behavioral.visitor.impl.Keyboard;
import designpattern.behavioral.visitor.impl.Monitor;
import designpattern.behavioral.visitor.impl.Mouse;

/**
 * Created by kimi on 4/27/16.
 */
public interface ComputerPartVisitor {
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}
