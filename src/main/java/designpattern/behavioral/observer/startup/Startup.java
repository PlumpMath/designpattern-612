package designpattern.behavioral.observer.startup;

import designpattern.behavioral.observer.impl.BinaryObserver;
import designpattern.behavioral.observer.impl.HexaObserver;
import designpattern.behavioral.observer.impl.OctalObserver;
import designpattern.behavioral.observer.impl.Subject;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
