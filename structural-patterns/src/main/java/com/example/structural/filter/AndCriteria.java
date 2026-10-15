package com.example.structural.filter;

import java.util.List;

/**
 * STUDENT TASK 2b - combine two rules: a person must follow BOTH.
 *
 * Idea: first filter with the first rule, then filter that result with the second rule.
 * No loop is needed, because each rule already knows how to filter.
 */
public class AndCriteria implements Criteria {

    private final Criteria first;
    private final Criteria second;

    public AndCriteria(Criteria first, Criteria second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        // TODO:
        // 1. Filter the people with the first rule:   first.meetCriteria(people)
        // 2. Filter THAT result with the second rule: second.meetCriteria(...)
        // 3. Return the final list.

        return people;              // TEMPORARY - delete this line
    }
}
