package designpattern.behavioral.state.impl;

import designpattern.behavioral.state.State;

/**
 * Created by kimi on 4/27/16.
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}
