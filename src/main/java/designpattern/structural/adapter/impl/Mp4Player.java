package designpattern.structural.adapter.impl;

import designpattern.structural.adapter.AdvancedMediaPlayer;

/**
 * Created by kimi on 4/27/16.
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
