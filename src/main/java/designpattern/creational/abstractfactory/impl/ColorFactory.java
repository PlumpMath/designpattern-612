package designpattern.creational.abstractfactory.impl;

import designpattern.creational.abstractfactory.AbstractFactory;
import designpattern.creational.abstractfactory.Color;
import designpattern.creational.abstractfactory.Shape;

/**
 * Created by kimi on 4/26/16.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {

        if (color == null) {
            return null;
        }

        if (color.equalsIgnoreCase("RED")) {
            return new Red();

        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();

        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }

        return null;
    }
}
