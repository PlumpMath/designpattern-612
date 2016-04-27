package designpattern.structural.bridge.impl;

import designpattern.structural.bridge.DrawAPI;
import designpattern.structural.bridge.Shape;

/**
 * Created by kimi on 4/27/16.
 */
public class Circle extends Shape {

    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
