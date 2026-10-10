package com.example.patterns.factory;

/** PROVIDED CODE - do not change. */
public class SmsNotification implements Notification {

    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
