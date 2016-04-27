package designpattern.structural.decorator.impl;

import designpattern.structural.decorator.Shape;
import designpattern.structural.decorator.ShapeDecorator;

/**
 * Created by kimi on 4/27/16.
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
