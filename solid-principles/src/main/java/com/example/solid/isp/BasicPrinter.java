package com.example.solid.isp;

/**
 * STUDENT TASK 4d - a simple printer. It can ONLY print.
 *
 * Right now it uses the fat Machine interface, so it has scan() and fax() that it cannot do,
 * and they throw exceptions. Clients that call scan() on a printer get a nasty surprise.
 *
 * TODO:
 *   1. Change "implements Machine" to "implements Printer".
 *   2. Delete scan() and fax(). A printer must not even have them.
 */
public class BasicPrinter implements Printer {

    @Override
    public String print(String document) {
        return "Printing: " + document;
    }

}
