package com.example.solid.srp;

import java.util.List;

/**
 * An invoice. It only HOLDS data. It does not calculate, print or save anything.
 * (That is already Single Responsibility: this class has one job, to hold the data.)
 *
 * PROVIDED CODE - do not change.
 */
public class Invoice {

    private final String customer;
    private final List<LineItem> items;

    public Invoice(String customer, List<LineItem> items) {
        this.customer = customer;
        this.items = List.copyOf(items);
    }

    public String getCustomer() {
        return customer;
    }

    public List<LineItem> getItems() {
        return items;
    }
}
