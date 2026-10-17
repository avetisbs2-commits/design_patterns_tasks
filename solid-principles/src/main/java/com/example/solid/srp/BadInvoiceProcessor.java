package com.example.solid.srp;

import java.util.ArrayList;
import java.util.List;

/**
 * THE BAD EXAMPLE - read it, do not change it.
 *
 * This class works. But it has THREE reasons to change:
 *   1. the tax rules change             (the calculation)
 *   2. the look of the invoice changes  (the formatting)
 *   3. the place where we store invoices changes, for example a database (the saving)
 * A class with 3 jobs is hard to read, hard to test, and every change can break the other jobs.
 *
 * Your task: give each job to its own class (InvoiceCalculator, InvoiceFormatter, InvoiceRepository),
 * and let InvoiceProcessor only coordinate them.
 */
public class BadInvoiceProcessor {

    private final List<Invoice> saved = new ArrayList<>();

    public String process(Invoice invoice) {
        // Job 1: calculate
        int subtotal = 0;
        for (LineItem item : invoice.getItems()) {
            subtotal += item.priceInCents() * item.quantity();
        }
        int total = subtotal + subtotal * 20 / 100;

        // Job 2: format
        List<String> lines = new ArrayList<>();
        lines.add("Invoice for " + invoice.getCustomer());
        for (LineItem item : invoice.getItems()) {
            int lineTotal = item.priceInCents() * item.quantity();
            lines.add(item.name() + " x" + item.quantity() + " = "
                    + String.format("%d.%02d", lineTotal / 100, lineTotal % 100));
        }
        lines.add("Total: " + String.format("%d.%02d", total / 100, total % 100));

        // Job 3: save
        saved.add(invoice);

        return String.join("\n", lines);
    }

    public int getSavedCount() {
        return saved.size();
    }
}
