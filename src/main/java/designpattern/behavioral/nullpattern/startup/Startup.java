package designpattern.behavioral.nullpattern.startup;

import designpattern.behavioral.nullpattern.AbstractCustomer;
import designpattern.behavioral.nullpattern.impl.CustomerFactory;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {

        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
