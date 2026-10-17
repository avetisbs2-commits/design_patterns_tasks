package com.example.solid.lsp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 3 (Liskov Substitution). PROVIDED CODE - do not change. */
class LspTest {

    @Test
    void sparrow_flies_asInTheExample() {
        assertEquals("Sparrow flies", new Sparrow().fly());
    }

    @Test
    void eagle_soars() {
        assertEquals("Eagle soars", new Eagle().fly());
    }

    @Test
    void penguin_isNotAFlyingBird() {
        assertFalse(FlyingBird.class.isAssignableFrom(Penguin.class),
                "A penguin cannot fly, so it must not be a FlyingBird (TODO 1)");
    }

    @Test
    void penguin_hasNoFlyMethod() {
        for (var method : Penguin.class.getDeclaredMethods()) {
            assertFalse(method.getName().equals("fly"), "Delete the fly() method of Penguin (TODO 2)");
        }
    }

    @Test
    void penguin_isStillABird_itEatsAndHasAName() {
        assertTrue(Bird.class.isAssignableFrom(Penguin.class));
        assertEquals("Penguin", new Penguin().getName());
        assertEquals("Penguin eats", new Penguin().eat());
    }

    @Test
    void penguin_swims() {
        assertEquals("Penguin swims", new Penguin().swim());
    }

    @Test
    void everyFlyingBird_canBeSubstitutedAndFliesWithoutAnyException() {
        // This is the Liskov promise: use any FlyingBird in the same way, and it works.
        List<FlyingBird> birds = List.of(new Sparrow(), new Eagle());

        for (FlyingBird bird : birds) {
            assertDoesNotThrow(bird::fly);
        }
    }

    @Test
    void birdWatcher_makesEveryBirdFlyInOrder() {
        List<String> result = new BirdWatcher().watch(List.of(new Sparrow(), new Eagle(), new Sparrow()));

        assertEquals(List.of("Sparrow flies", "Eagle soars", "Sparrow flies"), result);
    }

    @Test
    void birdWatcher_noBirds_noResults() {
        assertTrue(new BirdWatcher().watch(List.of()).isEmpty());
    }
}
