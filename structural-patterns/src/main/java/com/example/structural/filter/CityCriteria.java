package com.example.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps only the people from one city.
 * This is the WORKED EXAMPLE for AdultCriteria: look at the loop.
 *
 * PROVIDED CODE - do not change.
 */
public class CityCriteria implements Criteria {

    private final String city;

    public CityCriteria(String city) {
        this.city = city;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getCity().equals(city)) {
                result.add(person);
            }
        }
        return result;
    }
}
