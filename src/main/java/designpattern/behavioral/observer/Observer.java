package designpattern.behavioral.observer;

import designpattern.behavioral.observer.impl.Subject;

/**
 * Created by kimi on 4/27/16.
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
