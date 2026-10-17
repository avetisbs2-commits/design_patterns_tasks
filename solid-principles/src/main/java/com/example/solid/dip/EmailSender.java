package com.example.solid.dip;

/** Sends by email. WORKED EXAMPLE for SmsSender. PROVIDED CODE - do not change. */
public class EmailSender implements MessageSender {

    @Override
    public String send(String to, String message) {
        return "EMAIL to " + to + ": " + message;
    }
}
