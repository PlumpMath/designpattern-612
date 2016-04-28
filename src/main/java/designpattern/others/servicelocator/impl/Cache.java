package designpattern.others.servicelocator.impl;

import designpattern.others.servicelocator.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 4/28/16.
 */
public class Cache {
    private List<Service> services;

    public Cache() {
        services = new ArrayList<Service>();
    }

    public Service getService(String serviceName) {

        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached  " + serviceName + " object");
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService) {
        boolean exists = false;

        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(newService.getName())) {
                exists = true;
            }
        }
        if (!exists) {
            services.add(newService);
        }
    }
}
