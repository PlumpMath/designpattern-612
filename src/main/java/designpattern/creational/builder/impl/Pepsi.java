package designpattern.creational.builder.impl;

/**
 * Created by kimi on 4/26/16.
 */
public class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
