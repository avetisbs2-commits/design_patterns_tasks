package com.example.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Checks Task 2 (Factory). PROVIDED CODE - do not change. */
class FactoryTest {

    @Test
    void create_email_returnsEmailNotification() {
        assertInstanceOf(EmailNotification.class, NotificationFactory.create("email"));
    }

    @Test
    void create_sms_returnsSmsNotification() {
        assertInstanceOf(SmsNotification.class, NotificationFactory.create("sms"));
    }

    @Test
    void create_push_returnsPushNotification() {
        assertInstanceOf(PushNotification.class, NotificationFactory.create("push"));
    }

    @Test
    void create_ignoresUpperAndLowerCase() {
        assertInstanceOf(EmailNotification.class, NotificationFactory.create("EMAIL"));
        assertInstanceOf(SmsNotification.class, NotificationFactory.create("Sms"));
    }

    @Test
    void create_unknownType_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> NotificationFactory.create("fax"));
    }

    @Test
    void create_null_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> NotificationFactory.create(null));
    }

    @Test
    void createdNotifications_sendTheirOwnKindOfMessage() {
        assertEquals("EMAIL: Hi", NotificationFactory.create("email").send("Hi"));
        assertEquals("SMS: Hi", NotificationFactory.create("sms").send("Hi"));
        assertEquals("PUSH: Hi", NotificationFactory.create("push").send("Hi"));
    }
}
