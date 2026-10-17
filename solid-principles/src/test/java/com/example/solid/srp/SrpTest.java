package com.example.solid.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/** Checks Task 1 (Single Responsibility). PROVIDED CODE - do not change. */
class SrpTest {

    private Invoice invoice;

    @BeforeEach
    void setUp() {
        invoice = new Invoice("Anna", List.of(
                new LineItem("Phone", 30000, 2),
                new LineItem("Case", 1500, 1)));
    }

    // ---------- InvoiceCalculator (job 1: numbers) ----------

    @Test
    void calculator_subtotal_isThePriceTimesQuantityOfAllItems() {
        assertEquals(61500, new InvoiceCalculator().subtotalInCents(invoice));
    }

    @Test
    void calculator_total_addsTwentyPercentTax() {
        assertEquals(73800, new InvoiceCalculator().totalInCents(invoice));
    }

    @Test
    void calculator_total_roundsTheTaxDown() {
        Invoice small = new Invoice("Tom", List.of(new LineItem("Pen", 333, 1)));

        // tax is 66.6 cents -> 66, so the total is 399 (not 400)
        assertEquals(399, new InvoiceCalculator().totalInCents(small));
    }

    @Test
    void calculator_emptyInvoice_costsNothing() {
        Invoice empty = new Invoice("Nobody", List.of());

        assertEquals(0, new InvoiceCalculator().totalInCents(empty));
    }

    // ---------- InvoiceFormatter (job 2: text) ----------

    @Test
    void formatter_buildsTheTextOfTheInvoice() {
        String text = new InvoiceFormatter().format(invoice, 73800);

        assertEquals("Invoice for Anna\nPhone x2 = 600.00\nCase x1 = 15.00\nTotal: 738.00", text);
    }

    @Test
    void formatter_usesTheTotalThatWasGiven_itDoesNotCalculateByItself() {
        String text = new InvoiceFormatter().format(invoice, 1);

        assertEquals("Invoice for Anna\nPhone x2 = 600.00\nCase x1 = 15.00\nTotal: 0.01", text);
    }

    // ---------- InvoiceRepository (job 3: keeping) ----------

    @Test
    void repository_startsEmpty() {
        assertEquals(0, new InvoiceRepository().count());
    }

    @Test
    void repository_saveAndCount() {
        InvoiceRepository repository = new InvoiceRepository();

        repository.save(invoice);
        repository.save(new Invoice("Tom", List.of()));

        assertEquals(2, repository.count());
    }

    @Test
    void repository_findAll_returnsTheInvoicesInOrder() {
        InvoiceRepository repository = new InvoiceRepository();
        Invoice second = new Invoice("Tom", List.of());
        repository.save(invoice);
        repository.save(second);

        List<Invoice> all = repository.findAll();

        assertEquals(2, all.size());
        assertEquals(invoice, all.get(0));
        assertEquals(second, all.get(1));
    }

    @Test
    void repository_findAll_returnsACopy() {
        InvoiceRepository repository = new InvoiceRepository();
        repository.save(invoice);

        List<Invoice> copy = repository.findAll();
        assertNotNull(copy);
        copy.clear();   // clearing the copy must not clear the repository

        assertEquals(1, repository.count());
    }

    // ---------- InvoiceProcessor (the coordinator) ----------

    @Test
    void processor_returnsTheFormattedText() {
        InvoiceProcessor processor = new InvoiceProcessor(
                new InvoiceCalculator(), new InvoiceFormatter(), new InvoiceRepository());

        assertEquals("Invoice for Anna\nPhone x2 = 600.00\nCase x1 = 15.00\nTotal: 738.00",
                processor.process(invoice));
    }

    @Test
    void processor_savesTheInvoice() {
        InvoiceRepository repository = new InvoiceRepository();
        InvoiceProcessor processor = new InvoiceProcessor(new InvoiceCalculator(), new InvoiceFormatter(), repository);

        processor.process(invoice);

        assertEquals(1, repository.count());
        assertEquals(invoice, repository.findAll().get(0));
    }

    @Test
    void processor_givesTheSameResultAsTheBadOneClassVersion() {
        // The refactoring must NOT change what the program does. Only how it is built.
        BadInvoiceProcessor bad = new BadInvoiceProcessor();
        InvoiceRepository repository = new InvoiceRepository();
        InvoiceProcessor good = new InvoiceProcessor(new InvoiceCalculator(), new InvoiceFormatter(), repository);

        assertEquals(bad.process(invoice), good.process(invoice));
        assertEquals(bad.getSavedCount(), repository.count());
    }
}
