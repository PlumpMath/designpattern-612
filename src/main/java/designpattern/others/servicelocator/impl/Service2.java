package designpattern.others.servicelocator.impl;

import designpattern.others.servicelocator.Service;

/**
 * Created by kimi on 4/28/16.
 */
public class Service2 implements Service {
    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service2");
    }
}
