package com.example.solid.dip;

import java.util.ArrayList;
import java.util.List;

/**
 * STUDENT TASK 5b - make this service depend on the interface, not on a concrete class.
 *
 * Right now it IGNORES the sender that it receives and always uses an EmailSender that it
 * creates itself. That is the bad design.
 *
 * TODO:
 *   1. Change the field: the type must be MessageSender (not EmailSender), and it must NOT
 *      be created with "new" here.
 *   2. In the constructor, save the sender that was given:  this.sender = sender;
 *   3. Write notifyUsers().
 */
public class NotificationService {

    private final EmailSender sender = new EmailSender();   // TEMPORARY - must be:  private final MessageSender sender;

    public NotificationService(MessageSender sender) {
        // TODO: save the sender that was given.
    }

    /** Sends the text to one user. Returns what the sender returned. */
    public String notifyUser(String to, String text) {
        return sender.send(to, text);
    }

    /** Sends the same text to every user, in order. Returns the results, in the same order. */
    public List<String> notifyUsers(List<String> users, String text) {
        // TODO: make a new list, call notifyUser for every user, add the result, return the list.

        return new ArrayList<>();   // TEMPORARY - delete this line
    }
}
