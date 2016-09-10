package designpattern.behavioral.nullpattern.impl;

import designpattern.behavioral.nullpattern.AbstractCustomer;

/**
 * Created by kimi on 4/27/16.
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
