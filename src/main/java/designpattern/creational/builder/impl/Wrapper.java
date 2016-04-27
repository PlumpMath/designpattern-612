package designpattern.creational.builder.impl;

import designpattern.creational.builder.Packing;

/**
 * Created by kimi on 4/26/16.
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
