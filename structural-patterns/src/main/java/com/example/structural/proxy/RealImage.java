package com.example.structural.proxy;

import java.util.List;

/**
 * The real picture. Loading it is slow and costs memory, so we want to do it only when needed.
 * Loading happens in the constructor. It writes "Loading ..." into the log.
 *
 * PROVIDED CODE - do not change.
 */
public class RealImage implements Image {

    private final String fileName;

    public RealImage(String fileName, List<String> log) {
        this.fileName = fileName;
        log.add("Loading " + fileName);       // pretend this takes a long time
    }

    @Override
    public String display() {
        return "Showing " + fileName;
    }
}
