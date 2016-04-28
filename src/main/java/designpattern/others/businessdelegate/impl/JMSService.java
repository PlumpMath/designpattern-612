package designpattern.others.businessdelegate.impl;

import designpattern.others.businessdelegate.BusinessService;

/**
 * Created by kimi on 4/28/16.
 */
public class JMSService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}
