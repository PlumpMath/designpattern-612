package designpattern.behavioral.template.impl;

import designpattern.behavioral.template.Game;

/**
 * Created by kimi on 4/27/16.
 */
public class Football extends Game {
    @Override
    public void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    public void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    public void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
