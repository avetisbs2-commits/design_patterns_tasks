package com.example.structural.facade;

import java.util.List;

/** Part of the home theater. PROVIDED CODE - do not change. */
public class SoundSystem {

    private final List<String> log;

    public SoundSystem(List<String> log) {
        this.log = log;
    }

    public void on() {
        log.add("Sound on");
    }

    public void off() {
        log.add("Sound off");
    }

    public void setVolume(int volume) {
        log.add("Sound volume " + volume);
    }
}
