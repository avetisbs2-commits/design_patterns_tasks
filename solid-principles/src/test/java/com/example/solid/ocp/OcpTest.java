package com.example.solid.ocp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Checks Task 2 (Open/Closed). PROVIDED CODE - do not change. */
class OcpTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    @Test
    void calculator_usesTheDiscountThatWasGiven() {
        assertEquals(900, calculator.calculate(1000, new MemberDiscount()));
        assertEquals(1000, calculator.calculate(1000, new NoDiscount()));
    }

    @Test
    void vipDiscount_takesTwentyPercentOff() {
        assertEquals(800, new VipDiscount().apply(1000));
    }

    @Test
    void vipDiscount_roundsTheDiscountDown() {
        // 999 * 20 / 100 = 199.8 -> discount 199 -> 800
        assertEquals(800, new VipDiscount().apply(999));
    }

    @Test
    void blackFridayDiscount_takesThirtyPercentOff() {
        assertEquals(700, new BlackFridayDiscount().apply(1000));
    }

    @Test
    void blackFridayDiscount_roundsTheDiscountDown() {
        // 999 * 30 / 100 = 299.7 -> discount 299 -> 700
        assertEquals(700, new BlackFridayDiscount().apply(999));
    }

    @Test
    void calculator_totalFor_addsThePricesAfterTheDiscount() {
        assertEquals(2400, calculator.totalFor(List.of(1000, 2000), new VipDiscount()));
    }

    @Test
    void calculator_totalFor_emptyList_isZero() {
        assertEquals(0, calculator.totalFor(List.of(), new VipDiscount()));
    }

    @Test
    void calculator_isOpenForExtension_aBrandNewDiscountWorksWithoutChangingTheCalculator() {
        // This discount was invented in the TEST. The calculator never heard of it.
        Discount fiveEurosOff = price -> Math.max(0, price - 500);

        assertEquals(500, calculator.calculate(1000, fiveEurosOff));
        assertEquals(500, calculator.totalFor(List.of(1000, 300), fiveEurosOff));
    }

    @Test
    void newClasses_giveTheSameAnswersAsTheBadIfElseVersion() {
        BadDiscountCalculator bad = new BadDiscountCalculator();
        int[] prices = {0, 1, 99, 999, 1000, 12345};

        for (int price : prices) {
            assertEquals(bad.calculate(price, "none"), calculator.calculate(price, new NoDiscount()));
            assertEquals(bad.calculate(price, "member"), calculator.calculate(price, new MemberDiscount()));
            assertEquals(bad.calculate(price, "vip"), calculator.calculate(price, new VipDiscount()));
            assertEquals(bad.calculate(price, "blackfriday"), calculator.calculate(price, new BlackFridayDiscount()));
        }
    }
}
