package designpattern.others.frontcontroller.startup;

import designpattern.others.frontcontroller.impl.FrontController;

/**
 * Created by kimi on 4/28/16.
 */
public class Startup {
    public static void main(String[] args) {

        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }
}
