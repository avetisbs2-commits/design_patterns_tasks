package com.example.solid.isp;

/**
 * THE BAD EXAMPLE - one FAT interface that forces every class to have everything.
 * A simple printer cannot scan and cannot send a fax, but this interface forces it to have
 * scan() and fax() anyway. So it has to lie, or throw an exception.
 *
 * Your task: split it into small interfaces, so every class has only what it really can do.
 *
 * PROVIDED CODE - do not change. (When you finish, nobody uses it any more.)
 */
public interface Machine {

    String print(String document);

    String scan();

    String fax(String document, String number);
}
