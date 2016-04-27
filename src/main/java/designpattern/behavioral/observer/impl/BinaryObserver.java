package designpattern.behavioral.observer.impl;

import designpattern.behavioral.observer.Observer;

/**
 * Created by kimi on 4/27/16.
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
