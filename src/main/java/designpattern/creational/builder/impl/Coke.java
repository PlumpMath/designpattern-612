package designpattern.creational.builder.impl;

/**
 * Created by kimi on 4/26/16.
 */
public class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
