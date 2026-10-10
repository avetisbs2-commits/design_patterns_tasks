package com.example.patterns.factory;

/**
 * A way to send a message. Every kind of notification implements it.
 *
 * PROVIDED CODE - do not change.
 */
public interface Notification {

    /** "Sends" the message and returns the text that was sent. */
    String send(String message);
}
