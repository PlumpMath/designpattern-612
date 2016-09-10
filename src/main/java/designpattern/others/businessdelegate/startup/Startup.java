package designpattern.others.businessdelegate.startup;

import designpattern.others.businessdelegate.impl.BusinessDelegate;
import designpattern.others.businessdelegate.impl.Client;

/**
 * Created by kimi on 4/28/16.
 */
public class Startup {
    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }
}
