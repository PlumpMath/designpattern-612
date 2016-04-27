package designpattern.structural.decorator.startup;

import designpattern.structural.decorator.Shape;
import designpattern.structural.decorator.impl.Circle;
import designpattern.structural.decorator.impl.Rectangle;
import designpattern.structural.decorator.impl.RedShapeDecorator;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(circle);
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
