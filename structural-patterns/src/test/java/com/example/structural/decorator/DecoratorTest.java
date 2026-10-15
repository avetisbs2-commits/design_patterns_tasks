package com.example.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/** Checks Task 3 (Decorator). PROVIDED CODE - do not change. */
class DecoratorTest {

    private static final double DELTA = 0.0001;

    @Test
    void plainCoffee_costs2() {
        Coffee coffee = new SimpleCoffee();

        assertEquals("Coffee", coffee.getDescription());
        assertEquals(2.00, coffee.getCost(), DELTA);
    }

    @Test
    void whipDecorator_worksAsInTheExample() {
        Coffee coffee = new WhipDecorator(new SimpleCoffee());

        assertEquals("Coffee, whip", coffee.getDescription());
        assertEquals(2.70, coffee.getCost(), DELTA);
    }

    @Test
    void milkDecorator_addsMilk() {
        Coffee coffee = new MilkDecorator(new SimpleCoffee());

        assertEquals("Coffee, milk", coffee.getDescription());
        assertEquals(2.50, coffee.getCost(), DELTA);
    }

    @Test
    void sugarDecorator_addsSugar() {
        Coffee coffee = new SugarDecorator(new SimpleCoffee());

        assertEquals("Coffee, sugar", coffee.getDescription());
        assertEquals(2.20, coffee.getCost(), DELTA);
    }

    @Test
    void decorators_canBeStacked() {
        Coffee coffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));

        assertEquals("Coffee, milk, sugar", coffee.getDescription());
        assertEquals(2.70, coffee.getCost(), DELTA);
    }

    @Test
    void decorators_canBeStackedInAnyOrderAndAnyNumberOfTimes() {
        Coffee coffee = new MilkDecorator(new WhipDecorator(new MilkDecorator(new SimpleCoffee())));

        assertEquals("Coffee, milk, whip, milk", coffee.getDescription());
        assertEquals(3.70, coffee.getCost(), DELTA);
    }

    @Test
    void aDecoratedCoffee_isStillACoffee() {
        assertInstanceOf(Coffee.class, new MilkDecorator(new SimpleCoffee()));
    }
}
