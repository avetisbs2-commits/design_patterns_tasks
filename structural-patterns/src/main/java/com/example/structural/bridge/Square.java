package com.example.structural.bridge;

/**
 * A square. This is the WORKED EXAMPLE for the Circle task: look how it uses the color.
 *
 * PROVIDED CODE - do not change.
 */
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square filled with " + color.fill();
    }
}
