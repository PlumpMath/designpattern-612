package designpattern.others.interceptingfilter.impl;

import designpattern.others.interceptingfilter.Filter;

/**
 * Created by kimi on 4/28/16.
 */
public class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
