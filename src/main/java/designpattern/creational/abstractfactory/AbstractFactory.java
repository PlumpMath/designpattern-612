package designpattern.creational.abstractfactory;

/**
 * Created by kimi on 4/26/16.
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shapeType);
}
