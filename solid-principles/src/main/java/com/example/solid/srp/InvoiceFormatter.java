package com.example.solid.srp;

import java.util.ArrayList;
import java.util.List;

/**
 * JOB 2: the look of the text. This class knows how an invoice looks, and nothing else.
 *
 * STUDENT TASK 1b - write format().
 */
public class InvoiceFormatter {

    /**
     * Builds the text of the invoice, lines separated by "\n" (no "\n" at the end):
     *
     *     Invoice for Anna
     *     Phone x2 = 600.00
     *     Case x1 = 15.00
     *     Total: 738.00
     *
     * The first line is "Invoice for " + the customer.
     * Then one line for each item:  name + " x" + quantity + " = " + the money of (price x quantity).
     * The last line is "Total: " + the money of totalInCents.
     */
    public String format(Invoice invoice, int totalInCents) {
        // TODO: make a list of lines (List<String> lines = new ArrayList<>()), add the lines
        //       described above (use formatMoney for the money), and return String.join("\n", lines).

        return "";  // TEMPORARY - delete this line
    }

    // PROVIDED - 73800 cents -> "738.00", 1505 -> "15.05"
    public static String formatMoney(int cents) {
        return String.format("%d.%02d", cents / 100, cents % 100);
    }
}
