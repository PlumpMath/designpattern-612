package designpattern.creational.abstractfactory.impl;

import designpattern.creational.abstractfactory.AbstractFactory;
import designpattern.creational.abstractfactory.Color;
import designpattern.creational.abstractfactory.Shape;

/**
 * Created by kimi on 4/26/16.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
