package com.example.solid.isp;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 4 (Interface Segregation). PROVIDED CODE - do not change. */
class IspTest {

    // ---------- the small interfaces ----------

    @Test
    void printer_hasOneMethod_print() throws NoSuchMethodException {
        Method print = Printer.class.getMethod("print", String.class);

        assertEquals(String.class, print.getReturnType());
        assertEquals(1, Printer.class.getDeclaredMethods().length, "A small interface has ONE method");
    }

    @Test
    void documentScanner_hasOneMethod_scan() throws NoSuchMethodException {
        Method scan = DocumentScanner.class.getMethod("scan");

        assertEquals(String.class, scan.getReturnType());
        assertEquals(1, DocumentScanner.class.getDeclaredMethods().length);
    }

    @Test
    void faxSender_hasOneMethod_fax() throws NoSuchMethodException {
        Method fax = FaxSender.class.getMethod("fax", String.class, String.class);

        assertEquals(String.class, fax.getReturnType());
        assertEquals(1, FaxSender.class.getDeclaredMethods().length);
    }

    // ---------- BasicPrinter: ONLY a printer ----------

    @Test
    void basicPrinter_printsText() {
        assertEquals("Printing: report", new BasicPrinter().print("report"));
    }

    @Test
    void basicPrinter_implementsOnlyPrinter() {
        assertEquals(Set.of(Printer.class), new HashSet<>(Arrays.asList(BasicPrinter.class.getInterfaces())),
                "BasicPrinter must implement Printer, and nothing else (TODO 4d)");
    }

    @Test
    void basicPrinter_hasNoScanAndNoFax() {
        assertThrows(NoSuchMethodException.class, () -> BasicPrinter.class.getMethod("scan"),
                "A printer must not have scan()");
        assertThrows(NoSuchMethodException.class, () -> BasicPrinter.class.getMethod("fax", String.class, String.class),
                "A printer must not have fax()");
    }

    // ---------- AllInOneMachine: all three abilities ----------

    @Test
    void allInOne_doesAllThreeThings() {
        AllInOneMachine machine = new AllInOneMachine();

        assertEquals("Printing: report", machine.print("report"));
        assertEquals("Scanned page", machine.scan());
        assertEquals("Faxing report to 555-01", machine.fax("report", "555-01"));
    }

    @Test
    void allInOne_implementsTheThreeSmallInterfaces() {
        Set<Class<?>> interfaces = new HashSet<>(Arrays.asList(AllInOneMachine.class.getInterfaces()));

        assertEquals(Set.of(Printer.class, DocumentScanner.class, FaxSender.class), interfaces,
                "AllInOneMachine must implement Printer, DocumentScanner and FaxSender (TODO 4e)");
    }

    @Test
    void nobodyUsesTheFatInterfaceAnyMore() {
        assertFalse(Machine.class.isAssignableFrom(BasicPrinter.class));
        assertFalse(Machine.class.isAssignableFrom(AllInOneMachine.class));
        assertTrue(Machine.class.isInterface()); // it is still there, as the bad example
    }
}
