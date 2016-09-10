package designpattern.others.interceptingfilter.impl;

import designpattern.others.interceptingfilter.Filter;

/**
 * Created by kimi on 4/28/16.
 */
public class FilterManager {
    FilterChain filterChain;

    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}
