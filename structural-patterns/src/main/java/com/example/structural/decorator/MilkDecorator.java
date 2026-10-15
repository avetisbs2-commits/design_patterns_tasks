package com.example.structural.decorator;

/**
 * STUDENT TASK 3a - adds milk: the description gets ", milk" and the price goes up by 0.50.
 * Write it like WhipDecorator.
 */
public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        // TODO: return the description of the coffee inside, plus ", milk".

        return super.getDescription();      // TEMPORARY - replace this line
    }

    @Override
    public double getCost() {
        // TODO: return the cost of the coffee inside, plus 0.50.

        return super.getCost();             // TEMPORARY - replace this line
    }
}
