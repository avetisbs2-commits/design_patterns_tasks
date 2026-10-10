package com.example.patterns;

import com.example.patterns.builder.Pizza;
import com.example.patterns.factory.Notification;
import com.example.patterns.factory.NotificationFactory;
import com.example.patterns.immutable.Order;
import com.example.patterns.singleton.AppSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows all four patterns working. Run it to SEE your code.
 * (The tests are the real check. This is the "look at it" version.)
 *
 * PROVIDED CODE - do not change.
 */
public class Main {

    public static void main(String[] args) {
        section("1. Singleton", () -> {
            AppSettings first = AppSettings.getInstance();
            AppSettings second = AppSettings.getInstance();
            first.setAppName("Pattern Shop");

            System.out.println("Same object?     " + (first == second) + "   (must be true)");
            System.out.println("second app name: " + second.getAppName() + "   (must be Pattern Shop)");
        });

        section("2. Factory", () -> {
            String[] types = {"email", "SMS", "push"};
            for (String type : types) {
                Notification notification = NotificationFactory.create(type);
                System.out.println(type + " -> " + notification.send("Hello"));
            }
        });

        section("3. Builder", () -> {
            Pizza pizza = new Pizza.Builder()
                    .size("large")
                    .cheese(true)
                    .mushrooms(true)
                    .build();
            System.out.println(pizza);
            System.out.println("(must be: large, cheese=true, pepperoni=false, mushrooms=true)");
        });

        section("4. Immutable", () -> {
            List<String> items = new ArrayList<>(List.of("book"));
            Order order = new Order("Anna", items);

            items.add("pen");                         // change the original list
            Order bigger = order.withItem("lamp");    // ask for a new order

            System.out.println("order:  " + order.getItems() + "   (must be [book])");
            System.out.println("bigger: " + bigger.getItems() + "   (must be [book, lamp])");
        });
    }

    // Runs one part. If your code is not finished, it prints the problem and goes on.
    private static void section(String title, Runnable code) {
        System.out.println("=== " + title + " ===");
        try {
            code.run();
        } catch (RuntimeException e) {
            System.out.println("   (not finished yet: " + e + ")");
        }
        System.out.println();
    }
}
