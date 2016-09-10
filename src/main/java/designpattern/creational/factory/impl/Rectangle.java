package designpattern.creational.factory.impl;

import designpattern.creational.factory.Shape;

/**
 * Created by kimi on 4/26/16.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("rectangle draw...");
    }
}
