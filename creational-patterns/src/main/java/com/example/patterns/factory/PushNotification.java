package com.example.patterns.factory;

/** PROVIDED CODE - do not change. */
public class PushNotification implements Notification {

    @Override
    public String send(String message) {
        return "PUSH: " + message;
    }
}
