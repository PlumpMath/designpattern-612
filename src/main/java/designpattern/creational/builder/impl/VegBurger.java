package designpattern.creational.builder.impl;

import designpattern.creational.builder.impl.Burger;

/**
 * Created by kimi on 4/26/16.
 */
public class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
