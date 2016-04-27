package designpattern.behavioral.template.impl;

import designpattern.behavioral.template.Game;

/**
 * Created by kimi on 4/27/16.
 */
public class Cricket extends Game {
    @Override
    public void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    public void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    public void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
