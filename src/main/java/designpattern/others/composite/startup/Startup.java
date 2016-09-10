package designpattern.others.composite.startup;

import designpattern.others.composite.impl.Client;

/**
 * Created by kimi on 4/28/16.
 */
public class Startup {
    public static void main(String[] args) {
        Client client = new Client();
        client.setData("Test", "Data");
        client.printData();
        client.setData("Second Test", "Data1");
        client.printData();
    }
}
