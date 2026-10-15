package com.example.structural.facade;

import java.util.List;

/** Part of the home theater. PROVIDED CODE - do not change. */
public class StreamingPlayer {

    private final List<String> log;

    public StreamingPlayer(List<String> log) {
        this.log = log;
    }

    public void play(String movie) {
        log.add("Player play " + movie);
    }

    public void stop() {
        log.add("Player stop");
    }
}
