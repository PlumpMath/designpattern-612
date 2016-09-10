package designpattern.structural.decorator.impl;

import designpattern.structural.decorator.Shape;

/**
 * Created by kimi on 4/27/16.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
