package designpattern.others.servicelocator.impl;

/**
 * Created by kimi on 4/28/16.
 */
public class InitialContext {
    public Object lookup(String jndiName) {

        if (jndiName.equalsIgnoreCase("SERVICE1")) {
            System.out.println("Looking up and creating a new Service1 object");
            return new Service1();
        } else if (jndiName.equalsIgnoreCase("SERVICE2")) {
            System.out.println("Looking up and creating a new Service2 object");
            return new Service2();
        }
        return null;
    }
}
