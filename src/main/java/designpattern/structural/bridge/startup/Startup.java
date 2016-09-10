package designpattern.structural.bridge.startup;

import designpattern.structural.bridge.Shape;
import designpattern.structural.bridge.impl.Circle;
import designpattern.structural.bridge.impl.GreenCircle;
import designpattern.structural.bridge.impl.RedCircle;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}
