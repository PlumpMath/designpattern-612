package designpattern.creational.abstractfactory.impl;

import designpattern.creational.abstractfactory.Color;

/**
 * Created by kimi on 4/26/16.
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
