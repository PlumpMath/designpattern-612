package designpattern.behavioral.template;

/**
 * Created by kimi on 4/27/16.
 */
public abstract class Game {
    public abstract void initialize();

    public abstract void startPlay();

    public abstract void endPlay();

    //template method
    public final void play() {

        //initialize the game
        initialize();

        //start game
        startPlay();

        //end game
        endPlay();
    }
}
