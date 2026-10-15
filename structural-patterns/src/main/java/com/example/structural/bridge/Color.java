package com.example.structural.bridge;

/**
 * The "paint" of a shape. It is one side of the bridge.
 * Every color is its own small class, and it has nothing to do with shapes.
 *
 * PROVIDED CODE - do not change.
 */
public interface Color {

    /** The name of the color, for example "red". */
    String fill();
}
