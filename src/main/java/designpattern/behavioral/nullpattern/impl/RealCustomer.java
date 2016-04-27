package designpattern.behavioral.nullpattern.impl;

import designpattern.behavioral.nullpattern.AbstractCustomer;

/**
 * Created by kimi on 4/27/16.
 */
public class RealCustomer extends AbstractCustomer {
    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}
