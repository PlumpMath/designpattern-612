package designpattern.structural.bridge.impl;

import designpattern.structural.bridge.DrawAPI;

/**
 * Created by kimi on 4/27/16.
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}


