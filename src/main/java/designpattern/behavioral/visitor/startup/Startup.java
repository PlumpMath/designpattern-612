package designpattern.behavioral.visitor.startup;

import designpattern.behavioral.visitor.ComputerPart;
import designpattern.behavioral.visitor.impl.Computer;
import designpattern.behavioral.visitor.impl.ComputerPartDisplayVisitor;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
