package com.example.patterns.immutable;

import java.util.List;

/**
 * An order in a shop: a customer and a list of items.
 *
 * An IMMUTABLE object can never change after it is created. Like a printed
 * receipt: if you want a different one, you print a new one.
 * Immutable objects are safe to share, even between threads.
 *
 * Right now this class is MUTABLE (it can be changed in many ways).
 * STUDENT TASK 4 - make it immutable, step by step.
 */
public class Order {                                  // TODO 1: make the class final

    private String customer;                          // TODO 2: make this field final
    private List<String> items;                       // TODO 2: make this field final

    public Order(String customer, List<String> items) {
        this.customer = customer;
        // TODO 3: save a COPY of the list, not the list itself.
        //         If you save the same list, the caller can still change it from outside.
        //         Use:  List.copyOf(items)   (the copy cannot be changed either)
        this.items = items;                           // TEMPORARY - this keeps the caller's list
    }

    public String getCustomer() {
        return customer;
    }

    public List<String> getItems() {
        // TODO 4: nothing to change here IF the list from TODO 3 is already unmodifiable.
        return items;
    }

    // TODO 5: DELETE these two methods. An immutable object has no setters
    //         and no methods that change it.
    public void setCustomer(String customer) {        // TEMPORARY - delete
        this.customer = customer;
    }

    public void addItem(String item) {                // TEMPORARY - delete
        this.items.add(item);
    }

    // TODO 6: instead of changing the order, return a NEW order that has one more item.
    //         1. Make a new ArrayList with the current items:  new ArrayList<>(items)
    //         2. Add the new item to that new list.
    //         3. Return new Order(customer, newList).
    //         The original order must stay the same.
    public Order withItem(String item) {
        return this;                                  // TEMPORARY - delete this line
    }
}
