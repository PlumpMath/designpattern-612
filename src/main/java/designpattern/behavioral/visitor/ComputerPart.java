package designpattern.behavioral.visitor;

/**
 * Created by kimi on 4/27/16.
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
