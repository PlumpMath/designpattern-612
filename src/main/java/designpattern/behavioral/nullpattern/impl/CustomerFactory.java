package designpattern.behavioral.nullpattern.impl;

import designpattern.behavioral.nullpattern.AbstractCustomer;

/**
 * Created by kimi on 4/27/16.
 */
public class CustomerFactory {
    public static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name) {

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
