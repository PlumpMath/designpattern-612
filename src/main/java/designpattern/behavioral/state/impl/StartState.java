package designpattern.behavioral.state.impl;

import designpattern.behavioral.state.State;

/**
 * Created by kimi on 4/27/16.
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}
