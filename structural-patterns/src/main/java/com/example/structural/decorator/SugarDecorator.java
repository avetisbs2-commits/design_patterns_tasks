package com.example.structural.decorator;

/**
 * STUDENT TASK 3b - adds sugar: the description gets ", sugar" and the price goes up by 0.20.
 * Write it like WhipDecorator.
 */
public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        // TODO: return the description of the coffee inside, plus ", sugar".

        return super.getDescription();      // TEMPORARY - replace this line
    }

    @Override
    public double getCost() {
        // TODO: return the cost of the coffee inside, plus 0.20.

        return super.getCost();             // TEMPORARY - replace this line
    }
}
