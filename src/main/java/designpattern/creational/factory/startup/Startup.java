package designpattern.creational.factory.startup;

import designpattern.creational.factory.impl.ShapeFactory;
import designpattern.creational.factory.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 4/26/16.
 */
public class Startup {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape> list = new ArrayList<Shape>();
        Shape circle = shapeFactory.getShape("CIRCLE");
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        Shape square = shapeFactory.getShape("SQUARE");

        list.add(circle);
        list.add(rectangle);
        list.add(square);
        list.add(shapeFactory.getShape("helloworld"));

        for (Shape shape : list) {
            if (shape != null) {
                shape.draw();
            }
        }
    }
}
