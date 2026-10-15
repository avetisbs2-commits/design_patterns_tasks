package com.example.structural.decorator;

/**
 * The base of all decorators. A decorator IS a Coffee, and it HOLDS another Coffee.
 * By default it just passes the questions to the coffee inside.
 * A real decorator overrides the methods and adds something.
 *
 *      Sugar( Milk( SimpleCoffee ) )     <- like layers of an onion
 *
 * PROVIDED CODE - do not change.
 */
public abstract class CoffeeDecorator implements Coffee {

    protected final Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}
