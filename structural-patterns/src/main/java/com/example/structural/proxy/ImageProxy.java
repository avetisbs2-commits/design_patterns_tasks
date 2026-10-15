package com.example.structural.proxy;

import java.util.List;

/**
 * A stand-in for the real picture. It looks the same (it is an Image),
 * but it does not load the real picture until somebody really wants to see it.
 * This kind is called a "lazy" proxy.
 *
 * STUDENT TASK 5 - write display().
 */
public class ImageProxy implements Image {

    private final String fileName;
    private final List<String> log;

    // The real picture. It is null until the first display().
    private RealImage realImage;

    public ImageProxy(String fileName, List<String> log) {
        this.fileName = fileName;
        this.log = log;
    }

    // PROVIDED - the proxy can answer this without loading the real picture.
    public String getFileName() {
        return fileName;
    }

    @Override
    public String display() {
        // TODO:
        // 1. If realImage is still null, create it:  realImage = new RealImage(fileName, log);
        //    (this is the slow part, so it must happen only ONE time)
        // 2. Ask the real picture to display itself and return the result.

        return "TODO";              // TEMPORARY - delete this line
    }
}
