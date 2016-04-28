package designpattern.others.businessdelegate.impl;

import designpattern.others.businessdelegate.BusinessService;

/**
 * Created by kimi on 4/28/16.
 */
public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {

        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}
