package com.example.patterns.factory;

/** PROVIDED CODE - do not change. */
public class EmailNotification implements Notification {

    @Override
    public String send(String message) {
        return "EMAIL: " + message;
    }
}
