package com.example.structural.facade;

import java.util.List;

/**
 * Part of the home theater. Every action writes one line into the log,
 * so we can see what happened and in which order.
 *
 * PROVIDED CODE - do not change.
 */
public class Projector {

    private final List<String> log;

    public Projector(List<String> log) {
        this.log = log;
    }

    public void on() {
        log.add("Projector on");
    }

    public void off() {
        log.add("Projector off");
    }
}
