package com.example.solid.srp;

/** One line of an invoice. The price is in cents. PROVIDED CODE - do not change. */
public record LineItem(String name, int priceInCents, int quantity) {
}
