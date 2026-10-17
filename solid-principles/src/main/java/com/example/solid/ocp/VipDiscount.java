package com.example.solid.ocp;

/**
 * STUDENT TASK 2b - 20 percent off (rounded down, like MemberDiscount).
 * Look how little you write. And you did not touch the calculator: that is the principle.
 */
public class VipDiscount implements Discount {

    @Override
    public int apply(int priceInCents) {
        // TODO: return the price minus 20 percent of the price. Read MemberDiscount.java first.

        return priceInCents;    // TEMPORARY - delete this line
    }
}
