package designpattern.creational.singleton.startup;

import designpattern.creational.singleton.impl.SingleObject;

/**
 * Created by kimi on 4/26/16.
 */
public class Startup {
    public static void main(String[] args) {

        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //SingleObject object = new SingleObject();

        //Get the only object available
        SingleObject object = SingleObject.getInstance();
        SingleObject object1 = SingleObject.getInstance();
        System.out.println(object.equals(object1));
        System.out.println(object == object1);
        //show the message
        object.showMessage();
    }
}
