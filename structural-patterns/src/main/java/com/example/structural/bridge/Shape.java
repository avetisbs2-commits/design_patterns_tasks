package com.example.structural.bridge;

/**
 * A shape that can be drawn. It does NOT know which color classes exist.
 * It only holds a Color. That reference is the BRIDGE between the two sides:
 *
 *      Shape (Circle, Square ...)   ---- bridge ---->   Color (Red, Blue, Green ...)
 *
 * Without the bridge you would need a class for every pair: RedCircle,
 * BlueCircle, RedSquare, BlueSquare ... With the bridge: 2 shapes + 2 colors = 4 classes,
 * and any shape works with any color.
 *
 * STUDENT TASK 1a - save the color.
 */
public abstract class Shape {

    protected final Color color;

    protected Shape(Color color) {
        // TODO: save the color in the field:   this.color = color;

        this.color = null;  // TEMPORARY - replace this line
    }

    /** Draws the shape and returns the text of the drawing. */
    public abstract String draw();
}
