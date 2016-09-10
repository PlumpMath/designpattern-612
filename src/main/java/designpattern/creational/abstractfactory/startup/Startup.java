package designpattern.creational.abstractfactory.startup;

import designpattern.creational.abstractfactory.AbstractFactory;
import designpattern.creational.abstractfactory.Color;
import designpattern.creational.abstractfactory.Shape;
import designpattern.creational.abstractfactory.impl.FactoryProducer;

/**
 * Created by kimi on 4/26/16.
 */
public class Startup {
    public static void main(String[] args) {

        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //get an object of Shape Circle
        Shape circle = shapeFactory.getShape("CIRCLE");

        //call draw method of Shape Circle
        circle.draw();

        //get an object of Shape Rectangle
        Shape rectangle = shapeFactory.getShape("RECTANGLE");

        //call draw method of Shape Rectangle
        rectangle.draw();

        //get an object of Shape Square
        Shape square = shapeFactory.getShape("SQUARE");

        //call draw method of Shape Square
        square.draw();

        //get color factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //get an object of Color Red
        Color red = colorFactory.getColor("RED");

        //call fill method of Red
        red.fill();

        //get an object of Color Green
        Color green = colorFactory.getColor("Green");

        //call fill method of Green
        green.fill();

        //get an object of Color Blue
        Color blue = colorFactory.getColor("BLUE");

        //call fill method of Color Blue
        blue.fill();
    }
}
