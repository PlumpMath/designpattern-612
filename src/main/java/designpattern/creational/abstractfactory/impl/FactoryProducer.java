package designpattern.creational.abstractfactory.impl;

import designpattern.creational.abstractfactory.AbstractFactory;

/**
 * Created by kimi on 4/26/16.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {

        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();

        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }

        return null;
    }
}
