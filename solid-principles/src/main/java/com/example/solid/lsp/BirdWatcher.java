package com.example.solid.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * Makes birds fly and writes down what happened.
 * Look at the parameter: List<FlyingBird>. It is NOT List<Bird>. Because the watcher only
 * works with birds that can fly, it asks for exactly that, and the compiler protects it:
 * you cannot give it a Penguin.
 *
 * STUDENT TASK 3c - write watch().
 */
public class BirdWatcher {

    /** Calls fly() on every bird, in order, and returns the results. */
    public List<String> watch(List<FlyingBird> birds) {
        // TODO: make a new list of results, call bird.fly() for every bird, add each result, return the list.

        return new ArrayList<>();   // TEMPORARY - delete this line
    }
}
