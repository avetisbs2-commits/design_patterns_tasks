package com.example.patterns.factory;

/**
 * Creates the right kind of Notification from a name.
 * The caller says "email" and gets an EmailNotification, without writing
 * "new EmailNotification()" itself.
 *
 * STUDENT TASK 2 - write the factory method.
 */
public class NotificationFactory {

    public static Notification create(String type) {
        // TODO:
        // 1. If type is null, throw new IllegalArgumentException("Type is required").
        // 2. Look at the type, ignoring upper/lower case (use type.toLowerCase()):
        //        "email" -> return new EmailNotification()
        //        "sms"   -> return new SmsNotification()
        //        "push"  -> return new PushNotification()
        // 3. Any other type: throw new IllegalArgumentException("Unknown type: " + type).
        //
        // Tip: a switch or an if / else if chain both work.

        return null; // TEMPORARY - delete this line
    }
}
