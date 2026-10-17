package com.example.solid.srp;

/**
 * The COORDINATOR. It does not calculate, format or save by itself. It asks the three
 * classes that have those jobs. Compare it with BadInvoiceProcessor: the result is the same.
 *
 * STUDENT TASK 1d - write process().
 */
public class InvoiceProcessor {

    private final InvoiceCalculator calculator;
    private final InvoiceFormatter formatter;
    private final InvoiceRepository repository;

    public InvoiceProcessor(InvoiceCalculator calculator, InvoiceFormatter formatter, InvoiceRepository repository) {
        this.calculator = calculator;
        this.formatter = formatter;
        this.repository = repository;
    }

    /** Calculates, formats and saves the invoice. Returns the text of the invoice. */
    public String process(Invoice invoice) {
        // TODO: 1. total = calculator.totalInCents(invoice)
        //       2. text  = formatter.format(invoice, total)
        //       3. repository.save(invoice)
        //       4. return the text

        return "";  // TEMPORARY - delete this line
    }
}
