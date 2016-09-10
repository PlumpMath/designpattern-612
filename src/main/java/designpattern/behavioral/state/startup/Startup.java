package designpattern.behavioral.state.startup;

import designpattern.behavioral.state.impl.Context;
import designpattern.behavioral.state.impl.StartState;
import designpattern.behavioral.state.impl.StopState;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
