package com.example.solid.srp;

/**
 * JOB 1: the numbers. This class knows about prices and tax, and nothing else.
 *
 * STUDENT TASK 1a - write the two methods.
 */
public class InvoiceCalculator {

    /** The tax is 20 percent. */
    public static final int TAX_PERCENT = 20;

    /** The sum of (price x quantity) of all items, without tax. */
    public int subtotalInCents(Invoice invoice) {
        // TODO: go through invoice.getItems() and add  item.priceInCents() * item.quantity()

        return 0;   // TEMPORARY - delete this line
    }

    /** The subtotal plus the tax. The tax is rounded DOWN (whole cents): subtotal * TAX_PERCENT / 100. */
    public int totalInCents(Invoice invoice) {
        // TODO: 1. get the subtotal (use the method above)
        //       2. return subtotal + subtotal * TAX_PERCENT / 100

        return 0;   // TEMPORARY - delete this line
    }
}
