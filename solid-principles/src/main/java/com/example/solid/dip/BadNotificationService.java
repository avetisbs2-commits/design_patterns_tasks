package com.example.solid.dip;

/**
 * THE BAD EXAMPLE - read it, do not change it.
 *
 * The important class (NotificationService) creates the small detail (EmailSender) by itself,
 * with "new". So:
 *   - it can NEVER use SMS, unless you open and change this class
 *   - you cannot test it without a real email sender
 * The high-level class depends on a low-level detail. The arrow points the wrong way.
 *
 * Your task: turn the arrow around. The service depends on the MessageSender interface,
 * and somebody else GIVES it the sender (Dependency Injection).
 */
public class BadNotificationService {

    private final EmailSender sender = new EmailSender();

    public String notifyUser(String to, String text) {
        return sender.send(to, text);
    }
}
