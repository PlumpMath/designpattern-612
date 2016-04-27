package designpattern.creational.prototype.impl;

import designpattern.creational.prototype.Shape;

/**
 * Created by kimi on 4/27/16.
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
