package designpattern.creational.builder.impl;

import designpattern.creational.builder.Item;
import designpattern.creational.builder.Packing;

/**
 * Created by kimi on 4/26/16.
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
