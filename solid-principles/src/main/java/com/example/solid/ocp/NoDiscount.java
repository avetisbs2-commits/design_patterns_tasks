package com.example.solid.ocp;

/** No discount at all. PROVIDED CODE - do not change. */
public class NoDiscount implements Discount {

    @Override
    public int apply(int priceInCents) {
        return priceInCents;
    }
}
