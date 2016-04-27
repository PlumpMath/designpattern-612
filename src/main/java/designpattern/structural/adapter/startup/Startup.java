package designpattern.structural.adapter.startup;

import designpattern.structural.adapter.MediaPlayer;
import designpattern.structural.adapter.impl.AudioPlayer;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        MediaPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
