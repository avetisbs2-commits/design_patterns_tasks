package com.example.structural.filter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 2 (Filter). PROVIDED CODE - do not change. */
class FilterTest {

    private final List<Person> people = List.of(
            new Person("Anna", 25, "Paris"),
            new Person("Tom", 15, "Paris"),
            new Person("Lena", 30, "Berlin"),
            new Person("Max", 17, "Berlin"));

    private List<String> names(List<Person> list) {
        List<String> names = new ArrayList<>();
        for (Person person : list) {
            names.add(person.getName());
        }
        return names;
    }

    @Test
    void cityCriteria_worksAsInTheExample() {
        assertEquals(List.of("Anna", "Tom"), names(new CityCriteria("Paris").meetCriteria(people)));
    }

    @Test
    void adultCriteria_keepsOnlyPeopleWith18OrMore() {
        assertEquals(List.of("Anna", "Lena"), names(new AdultCriteria().meetCriteria(people)));
    }

    @Test
    void adultCriteria_includesExactly18() {
        List<Person> list = List.of(new Person("Eve", 18, "Rome"), new Person("Bob", 17, "Rome"));

        assertEquals(List.of("Eve"), names(new AdultCriteria().meetCriteria(list)));
    }

    @Test
    void adultCriteria_doesNotChangeTheGivenList() {
        new AdultCriteria().meetCriteria(people);

        assertEquals(4, people.size());
    }

    @Test
    void andCriteria_keepsPeopleThatFollowBothRules() {
        Criteria adultInParis = new AndCriteria(new AdultCriteria(), new CityCriteria("Paris"));

        assertEquals(List.of("Anna"), names(adultInParis.meetCriteria(people)));
    }

    @Test
    void andCriteria_worksInAnyOrder() {
        Criteria parisAdult = new AndCriteria(new CityCriteria("Paris"), new AdultCriteria());

        assertEquals(List.of("Anna"), names(parisAdult.meetCriteria(people)));
    }

    @Test
    void andCriteria_canBeCombinedAgain() {
        // (adult AND Berlin) AND Berlin  -> still only Lena
        Criteria rule = new AndCriteria(
                new AndCriteria(new AdultCriteria(), new CityCriteria("Berlin")),
                new CityCriteria("Berlin"));

        assertEquals(List.of("Lena"), names(rule.meetCriteria(people)));
    }

    @Test
    void andCriteria_withNoMatch_returnsAnEmptyList() {
        Criteria rule = new AndCriteria(new AdultCriteria(), new CityCriteria("Rome"));

        assertTrue(rule.meetCriteria(people).isEmpty());
    }
}
