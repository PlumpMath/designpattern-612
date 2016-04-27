package designpattern.behavioral.memento.impl;

/**
 * Created by kimi on 4/27/16.
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
