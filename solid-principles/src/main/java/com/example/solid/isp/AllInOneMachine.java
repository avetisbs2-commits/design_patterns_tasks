package com.example.solid.isp;

/**
 * STUDENT TASK 4e - a big machine that can print, scan AND fax.
 *
 * It has all three abilities, so it implements all three small interfaces.
 *
 * TODO: change "implements Machine" to "implements Printer, DocumentScanner, FaxSender".
 */
public class AllInOneMachine implements Machine {  // TEMPORARY - this should list the three small interfaces

    @Override
    public String print(String document) {
        return "Printing: " + document;
    }

    @Override
    public String scan() {
        return "Scanned page";
    }

    @Override
    public String fax(String document, String number) {
        return "Faxing " + document + " to " + number;
    }
}
