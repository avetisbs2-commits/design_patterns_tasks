package com.example.solid.lsp;

/**
 * Something that is a bird. It says ONLY what is true for EVERY bird: it has a name and it eats.
 * (Not every bird can fly, so "fly" is NOT here.)
 *
 * PROVIDED CODE - do not change.
 */
public interface Bird {

    String getName();

    default String eat() {
        return getName() + " eats";
    }
}
