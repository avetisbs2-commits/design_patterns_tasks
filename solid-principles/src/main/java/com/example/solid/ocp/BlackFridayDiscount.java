package com.example.solid.ocp;

/**
 * STUDENT TASK 2c - 30 percent off (rounded down, like MemberDiscount).
 * It is a NEW kind of discount. Again, you do not change the calculator.
 */
public class BlackFridayDiscount implements Discount {

    @Override
    public int apply(int priceInCents) {
        // TODO: return the price minus 30 percent of the price.

        return priceInCents;    // TEMPORARY - delete this line
    }
}
