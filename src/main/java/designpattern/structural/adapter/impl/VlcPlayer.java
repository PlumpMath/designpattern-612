package designpattern.structural.adapter.impl;

import designpattern.structural.adapter.AdvancedMediaPlayer;

/**
 * Created by kimi on 4/27/16.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
