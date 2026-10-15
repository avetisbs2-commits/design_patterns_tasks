package com.example.structural.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 4 (Facade). PROVIDED CODE - do not change. */
class FacadeTest {

    private List<String> log;
    private HomeTheaterFacade theater;

    @BeforeEach
    void setUp() {
        log = new ArrayList<>();
        theater = new HomeTheaterFacade(new Projector(log), new SoundSystem(log), new StreamingPlayer(log));
    }

    @Test
    void newFacade_doesNothingByItself() {
        assertTrue(log.isEmpty());
    }

    @Test
    void watchMovie_switchesEverythingOnInTheRightOrder() {
        theater.watchMovie("Matrix");

        assertEquals(List.of(
                "Projector on",
                "Sound on",
                "Sound volume 10",
                "Player play Matrix"), log);
    }

    @Test
    void watchMovie_usesTheNameOfTheMovie() {
        theater.watchMovie("Avatar");

        assertEquals("Player play Avatar", log.get(log.size() - 1));
    }

    @Test
    void endMovie_switchesEverythingOffInTheRightOrder() {
        theater.endMovie();

        assertEquals(List.of(
                "Player stop",
                "Sound off",
                "Projector off"), log);
    }

    @Test
    void watchThenEnd_runsAllSevenSteps() {
        theater.watchMovie("Matrix");
        theater.endMovie();

        assertEquals(7, log.size());
    }
}
