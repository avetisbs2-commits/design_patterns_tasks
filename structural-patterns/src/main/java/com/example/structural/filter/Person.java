package com.example.structural.filter;

/** A person to search in. PROVIDED CODE - do not change. */
public class Person {

    private final String name;
    private final int age;
    private final String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}
