package designpattern.creational.builder.impl;

/**
 * Created by kimi on 4/26/16.
 */
public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
