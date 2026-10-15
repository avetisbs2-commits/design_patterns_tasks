package com.example.structural.decorator;

/** Plain coffee, without anything added. PROVIDED CODE - do not change. */
public class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public double getCost() {
        return 2.00;
    }
}
