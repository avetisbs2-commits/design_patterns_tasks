package com.example.structural.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Checks Task 1 (Bridge). PROVIDED CODE - do not change. */
class BridgeTest {

    @Test
    void square_usesTheColorItWasGiven() {
        // Square is provided. It only works when Shape saves the color (Task 1a).
        assertEquals("Square filled with red", new Square(new RedColor()).draw());
        assertEquals("Square filled with blue", new Square(new BlueColor()).draw());
    }

    @Test
    void circle_drawsWithRed() {
        assertEquals("Circle filled with red", new Circle(new RedColor()).draw());
    }

    @Test
    void circle_drawsWithBlue() {
        assertEquals("Circle filled with blue", new Circle(new BlueColor()).draw());
    }

    @Test
    void greenColor_isNamedGreen() {
        assertEquals("green", new GreenColor().fill());
    }

    @Test
    void newColor_worksWithEveryShape_withoutChangingTheShapes() {
        assertEquals("Circle filled with green", new Circle(new GreenColor()).draw());
        assertEquals("Square filled with green", new Square(new GreenColor()).draw());
    }

    @Test
    void anyShapeCanBeUsedThroughTheShapeType() {
        Shape shape = new Circle(new BlueColor());

        assertEquals("Circle filled with blue", shape.draw());
    }
}
