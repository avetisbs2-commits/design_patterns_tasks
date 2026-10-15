package com.example.structural;

import com.example.structural.bridge.BlueColor;
import com.example.structural.bridge.Circle;
import com.example.structural.bridge.GreenColor;
import com.example.structural.bridge.RedColor;
import com.example.structural.bridge.Shape;
import com.example.structural.bridge.Square;
import com.example.structural.decorator.Coffee;
import com.example.structural.decorator.MilkDecorator;
import com.example.structural.decorator.SimpleCoffee;
import com.example.structural.decorator.SugarDecorator;
import com.example.structural.decorator.WhipDecorator;
import com.example.structural.facade.HomeTheaterFacade;
import com.example.structural.facade.Projector;
import com.example.structural.facade.SoundSystem;
import com.example.structural.facade.StreamingPlayer;
import com.example.structural.filter.AdultCriteria;
import com.example.structural.filter.AndCriteria;
import com.example.structural.filter.CityCriteria;
import com.example.structural.filter.Person;
import com.example.structural.proxy.ImageProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows all five patterns working. Run it to SEE your code.
 * (The tests are the real check. This is the "look at it" version.)
 *
 * PROVIDED CODE - do not change.
 */
public class Main {

    public static void main(String[] args) {
        section("1. Bridge", () -> {
            Shape[] shapes = {
                    new Circle(new RedColor()),
                    new Square(new BlueColor()),
                    new Circle(new GreenColor())
            };
            for (Shape shape : shapes) {
                System.out.println(shape.draw());
            }
            System.out.println("(must be: Circle filled with red / Square filled with blue / Circle filled with green)");
        });

        section("2. Filter", () -> {
            List<Person> people = List.of(
                    new Person("Anna", 25, "Paris"),
                    new Person("Tom", 15, "Paris"),
                    new Person("Lena", 30, "Berlin"),
                    new Person("Max", 17, "Berlin"));

            System.out.println("Adults:         " + new AdultCriteria().meetCriteria(people));
            System.out.println("Adults in Paris: "
                    + new AndCriteria(new AdultCriteria(), new CityCriteria("Paris")).meetCriteria(people));
            System.out.println("(must be: Anna and Lena / only Anna)");
        });

        section("3. Decorator", () -> {
            Coffee coffee = new SugarDecorator(new MilkDecorator(new WhipDecorator(new SimpleCoffee())));
            System.out.printf("%s = %.2f%n", coffee.getDescription(), coffee.getCost());
            System.out.println("(must be: Coffee, whip, milk, sugar = 3.40)");
        });

        section("4. Facade", () -> {
            List<String> log = new ArrayList<>();
            HomeTheaterFacade theater = new HomeTheaterFacade(
                    new Projector(log), new SoundSystem(log), new StreamingPlayer(log));

            theater.watchMovie("Matrix");
            theater.endMovie();
            for (String line : log) {
                System.out.println("  " + line);
            }
            System.out.println("(must be 7 lines: 4 for watchMovie, 3 for endMovie)");
        });

        section("5. Proxy", () -> {
            List<String> log = new ArrayList<>();
            ImageProxy image = new ImageProxy("photo.jpg", log);
            System.out.println("After creating the proxy, log = " + log + "   (must be empty)");

            System.out.println(image.display());
            System.out.println(image.display());
            System.out.println("After 2 displays, log = " + log + "   (must have ONE Loading line)");
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
