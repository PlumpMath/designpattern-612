package designpattern.others.interceptingfilter.startup;

import designpattern.others.interceptingfilter.impl.*;

/**
 * Created by kimi on 4/28/16.
 */
public class Startup {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
}
