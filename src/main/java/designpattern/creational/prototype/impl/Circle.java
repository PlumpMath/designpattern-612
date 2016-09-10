package designpattern.creational.prototype.impl;

import designpattern.creational.prototype.Shape;

/**
 * Created by kimi on 4/27/16.
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
