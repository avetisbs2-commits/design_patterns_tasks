package com.example.patterns.immutable;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 4 (Immutable). PROVIDED CODE - do not change. */
class ImmutableTest {

    @Test
    void class_isFinal() {
        assertTrue(Modifier.isFinal(Order.class.getModifiers()),
                "Order must be final (TODO 1)");
    }

    @Test
    void allFields_areFinal() {
        for (Field field : Order.class.getDeclaredFields()) {
            assertTrue(Modifier.isFinal(field.getModifiers()),
                    "Field '" + field.getName() + "' must be final (TODO 2)");
        }
    }

    @Test
    void order_hasNoSettersAndNoAddMethods() {
        for (Method method : Order.class.getDeclaredMethods()) {
            String name = method.getName();
            assertTrue(!name.startsWith("set") && !name.startsWith("add"),
                    "Delete the method '" + name + "' (TODO 5)");
        }
    }

    @Test
    void constructor_keepsACopyOfTheList() {
        List<String> source = new ArrayList<>(List.of("book"));
        Order order = new Order("Anna", source);

        source.add("pen"); // change the original list from outside

        assertEquals(List.of("book"), order.getItems(),
                "The order must not change when the original list changes (TODO 3)");
    }

    @Test
    void getItems_cannotBeChanged() {
        Order order = new Order("Anna", new ArrayList<>(List.of("book")));

        assertThrows(UnsupportedOperationException.class,
                () -> order.getItems().add("pen"),
                "The list from getItems() must not be changeable (TODO 3 and 4)");
    }

    @Test
    void withItem_returnsANewOrderAndKeepsTheOldOne() {
        Order order = new Order("Anna", List.of("book"));

        Order bigger = order.withItem("lamp");

        assertNotSame(order, bigger, "withItem must return a NEW Order (TODO 6)");
        assertEquals(List.of("book", "lamp"), bigger.getItems());
        assertEquals("Anna", bigger.getCustomer());
        assertEquals(List.of("book"), order.getItems(), "The old order must stay the same");
    }
}
