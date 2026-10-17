package com.example.solid.ocp;

/**
 * 10 percent off. The discount is rounded DOWN to whole cents: 999 -> discount 99 -> 900.
 * This is the WORKED EXAMPLE for VipDiscount and BlackFridayDiscount.
 *
 * PROVIDED CODE - do not change.
 */
public class MemberDiscount implements Discount {

    @Override
    public int apply(int priceInCents) {
        return priceInCents - priceInCents * 10 / 100;
    }
}
