package com.example.solid.ocp;

/**
 * One kind of discount. This is the "plug" that makes the system OPEN for new discounts:
 * to add a new kind you write a NEW class that implements Discount. You change nothing else.
 *
 * PROVIDED CODE - do not change.
 */
public interface Discount {

    /** Returns the price in cents after the discount. */
    int apply(int priceInCents);
}
