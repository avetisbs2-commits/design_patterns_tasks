package com.example.solid.srp;

import java.util.ArrayList;
import java.util.List;

/**
 * JOB 3: keeping invoices. Today it is a list in memory. Tomorrow it can be a database,
 * and nobody else has to change.
 *
 * STUDENT TASK 1c - write the three methods.
 */
public class InvoiceRepository {

    private final List<Invoice> invoices = new ArrayList<>();

    public void save(Invoice invoice) {
        // TODO: add the invoice to the list.
    }

    public int count() {
        // TODO: return how many invoices are saved.

        return -1;  // TEMPORARY - delete this line
    }

    /** A COPY of the saved invoices, in the order they were saved. Changing the copy must not change the repository. */
    public List<Invoice> findAll() {
        // TODO: return new ArrayList<>(invoices)

        return null;    // TEMPORARY - delete this line
    }
}
