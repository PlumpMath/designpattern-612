package designpattern.behavioral.template.startup;

import designpattern.behavioral.template.Game;
import designpattern.behavioral.template.impl.Cricket;
import designpattern.behavioral.template.impl.Football;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
