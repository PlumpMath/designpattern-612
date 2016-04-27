package designpattern.creational.abstractfactory.impl;

import designpattern.creational.abstractfactory.Shape;

/**
 * Created by kimi on 4/26/16.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}