package designpattern.behavioral.state;

import designpattern.behavioral.state.impl.Context;

/**
 * Created by kimi on 4/27/16.
 */
public interface State {
    void doAction(Context context);
}
