package com.example.solid.ocp;

/**
 * THE BAD EXAMPLE - read it, do not change it.
 *
 * It works. But look: for every NEW kind of customer you must OPEN this class and add
 * another "else if". Every change to old, working code can break it. The class is
 * not closed for modification.
 *
 * Your task: a calculator that never changes. New discounts are new classes.
 */
public class BadDiscountCalculator {

    public int calculate(int priceInCents, String customerType) {
        if (customerType.equals("none")) {
            return priceInCents;
        } else if (customerType.equals("member")) {
            return priceInCents - priceInCents * 10 / 100;
        } else if (customerType.equals("vip")) {
            return priceInCents - priceInCents * 20 / 100;
        } else if (customerType.equals("blackfriday")) {
            return priceInCents - priceInCents * 30 / 100;
        }
        throw new IllegalArgumentException("Unknown customer type: " + customerType);
    }
}
