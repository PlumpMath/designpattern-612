package designpattern.creational.prototype.impl;

import designpattern.creational.prototype.Shape;

/**
 * Created by kimi on 4/27/16.
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
