package designpattern.structural.facade.impl;

import designpattern.structural.facade.Shape;

/**
 * Created by kimi on 4/27/16.
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}