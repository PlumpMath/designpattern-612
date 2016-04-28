package designpattern.others.servicelocator.startup;

import designpattern.others.servicelocator.Service;
import designpattern.others.servicelocator.impl.ServiceLocator;

/**
 * Created by kimi on 4/28/16.
 */
public class Startup {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
        service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
    }
}
