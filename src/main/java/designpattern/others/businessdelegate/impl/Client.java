package designpattern.others.businessdelegate.impl;

/**
 * Created by kimi on 4/28/16.
 */
public class Client {
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService) {
        this.businessService = businessService;
    }

    public void doTask() {
        businessService.doTask();
    }
}
