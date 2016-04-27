package designpattern.structural.proxy.startup;

import designpattern.structural.proxy.Image;
import designpattern.structural.proxy.impl.ProxyImage;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}
