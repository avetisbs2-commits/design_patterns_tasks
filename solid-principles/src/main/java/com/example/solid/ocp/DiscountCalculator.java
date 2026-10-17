package com.example.solid.ocp;

import java.util.List;

/**
 * The calculator that is CLOSED for modification and OPEN for extension.
 * It does not know any kind of discount. It only knows the Discount interface.
 * Look: there is no "if" about a customer type, and there never will be.
 *
 * STUDENT TASK 2a - write the two methods.
 */
public class DiscountCalculator {

    /** The price after the discount. */
    public int calculate(int priceInCents, Discount discount) {
        // TODO: ask the discount to apply itself to the price:  discount.apply(...)

        return priceInCents;    // TEMPORARY - this ignores the discount. Delete this line.
    }

    /** The sum of all prices, each one after the discount. */
    public int totalFor(List<Integer> pricesInCents, Discount discount) {
        // TODO: go through the prices and add  calculate(price, discount)  to a sum. Return the sum.

        return 0;               // TEMPORARY - delete this line
    }
}
