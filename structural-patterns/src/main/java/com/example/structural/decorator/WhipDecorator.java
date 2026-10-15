package com.example.structural.decorator;

/**
 * Adds whipped cream. This is the WORKED EXAMPLE for MilkDecorator and SugarDecorator.
 * Look: it asks the coffee inside, and then adds its own part.
 *
 * PROVIDED CODE - do not change.
 */
public class WhipDecorator extends CoffeeDecorator {

    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", whip";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.70;
    }
}
