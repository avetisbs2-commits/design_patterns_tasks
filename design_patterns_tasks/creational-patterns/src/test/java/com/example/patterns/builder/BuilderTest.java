package com.example.patterns.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 3 (Builder). PROVIDED CODE - do not change. */
class BuilderTest {

    @Test
    void build_createsAPizzaWithAllTheValues() {
        Pizza pizza = new Pizza.Builder()
                .size("large")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(true)
                .build();

        assertNotNull(pizza, "build() must return a Pizza");
        assertEquals("large", pizza.getSize());
        assertTrue(pizza.hasCheese());
        assertTrue(pizza.hasPepperoni());
        assertTrue(pizza.hasMushrooms());
    }

    @Test
    void toppings_areOptional_andOffByDefault() {
        Pizza pizza = new Pizza.Builder().size("small").build();

        assertNotNull(pizza);
        assertEquals("small", pizza.getSize());
        assertFalse(pizza.hasCheese());
        assertFalse(pizza.hasPepperoni());
        assertFalse(pizza.hasMushrooms());
    }

    @Test
    void builderMethods_returnTheSameBuilder_soTheyCanBeChained() {
        Pizza.Builder builder = new Pizza.Builder();

        assertSame(builder, builder.size("medium"));
        assertSame(builder, builder.cheese(true));
        assertSame(builder, builder.pepperoni(true));
        assertSame(builder, builder.mushrooms(true));
    }

    @Test
    void build_withoutSize_throwsIllegalStateException() {
        assertThrows(IllegalStateException.class,
                () -> new Pizza.Builder().cheese(true).build());
    }

    @Test
    void build_withEmptySize_throwsIllegalStateException() {
        assertThrows(IllegalStateException.class,
                () -> new Pizza.Builder().size("").build());
    }
}
