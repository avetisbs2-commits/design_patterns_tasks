package com.example.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * STUDENT TASK 2a - keep only the adults (age 18 or more).
 * Write it like CityCriteria.
 */
public class AdultCriteria implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        // TODO:
        // 1. Make a new empty list:  List<Person> result = new ArrayList<>();
        // 2. Go through all people with a for loop.
        // 3. If person.getAge() >= 18, add the person to result.
        // 4. Return result.

        return new ArrayList<>();   // TEMPORARY - delete this line
    }
}
