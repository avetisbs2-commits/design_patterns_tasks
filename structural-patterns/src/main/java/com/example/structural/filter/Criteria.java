package com.example.structural.filter;

import java.util.List;

/**
 * One rule that keeps some people and drops the others.
 * Every rule has the same method, so rules can be combined.
 *
 * PROVIDED CODE - do not change.
 */
public interface Criteria {

    /** Returns a NEW list with only the people that follow the rule. The given list is not changed. */
    List<Person> meetCriteria(List<Person> people);
}
