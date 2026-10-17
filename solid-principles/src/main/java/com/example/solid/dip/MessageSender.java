package com.example.solid.dip;

/**
 * The ABSTRACTION. "Something that can send a message."
 * High-level code (NotificationService) will depend on THIS, not on email or SMS.
 *
 * PROVIDED CODE - do not change.
 */
public interface MessageSender {

    /** Sends the message and returns a text that says what was sent. */
    String send(String to, String message);
}
