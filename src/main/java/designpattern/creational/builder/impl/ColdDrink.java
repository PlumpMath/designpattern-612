package designpattern.creational.builder.impl;

import designpattern.creational.builder.Item;
import designpattern.creational.builder.Packing;

/**
 * Created by kimi on 4/26/16.
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
