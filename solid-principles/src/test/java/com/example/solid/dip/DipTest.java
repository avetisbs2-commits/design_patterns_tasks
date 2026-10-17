package com.example.solid.dip;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 5 (Dependency Inversion). PROVIDED CODE - do not change. */
class DipTest {

    @Test
    void smsSender_sendsBySms() {
        assertEquals("SMS to anna: Hi", new SmsSender().send("anna", "Hi"));
    }

    @Test
    void service_withSms_usesSms() {
        NotificationService service = new NotificationService(new SmsSender());

        assertEquals("SMS to anna: Hi", service.notifyUser("anna", "Hi"));
    }

    @Test
    void service_withEmail_usesEmail() {
        NotificationService service = new NotificationService(new EmailSender());

        assertEquals("EMAIL to anna: Hi", service.notifyUser("anna", "Hi"));
    }

    @Test
    void service_usesTheSenderThatWasGiven_evenAFakeOneMadeInTheTest() {
        // The service never heard of this sender. It only knows the MessageSender interface.
        MessageSender fake = (to, message) -> "FAKE[" + to + "|" + message + "]";
        NotificationService service = new NotificationService(fake);

        assertEquals("FAKE[tom|Hello]", service.notifyUser("tom", "Hello"));
    }

    @Test
    void service_doesNotCreateItsOwnConcreteSender() {
        for (Field field : NotificationService.class.getDeclaredFields()) {
            assertTrue(field.getType().isInterface(),
                    "The field '" + field.getName() + "' has the type " + field.getType().getSimpleName()
                            + ". Use the interface MessageSender (TODO 1)");
        }
    }

    @Test
    void service_notifyUsers_sendsToEveryUserInOrder() {
        NotificationService service = new NotificationService(new SmsSender());

        List<String> results = service.notifyUsers(List.of("anna", "tom"), "Hi");

        assertEquals(List.of("SMS to anna: Hi", "SMS to tom: Hi"), results);
    }

    @Test
    void service_notifyUsers_withFakeSender_callsItForEveryUser() {
        NotificationService service = new NotificationService((to, message) -> to.toUpperCase());

        assertEquals(List.of("A", "B", "C"), service.notifyUsers(List.of("a", "b", "c"), "x"));
    }

    @Test
    void service_notifyUsers_noUsers_noResults() {
        NotificationService service = new NotificationService(new EmailSender());

        assertTrue(service.notifyUsers(List.of(), "Hi").isEmpty());
    }

    @Test
    void newService_givesTheSameAnswerAsTheBadOneWhenUsingEmail() {
        assertEquals(new BadNotificationService().notifyUser("anna", "Hi"),
                new NotificationService(new EmailSender()).notifyUser("anna", "Hi"));
    }
}
