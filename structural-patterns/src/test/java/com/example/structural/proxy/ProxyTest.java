package com.example.structural.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 5 (Proxy). PROVIDED CODE - do not change. */
class ProxyTest {

    private List<String> log;

    @BeforeEach
    void setUp() {
        log = new ArrayList<>();
    }

    @Test
    void proxy_isAnImage() {
        assertInstanceOf(Image.class, new ImageProxy("photo.jpg", log));
    }

    @Test
    void creatingTheProxy_doesNotLoadTheRealImage() {
        new ImageProxy("photo.jpg", log);

        assertTrue(log.isEmpty(), "The real image must NOT be loaded yet");
    }

    @Test
    void gettingTheFileName_doesNotLoadTheRealImage() {
        ImageProxy proxy = new ImageProxy("photo.jpg", log);

        assertEquals("photo.jpg", proxy.getFileName());
        assertTrue(log.isEmpty());
    }

    @Test
    void display_showsTheRealImage() {
        Image proxy = new ImageProxy("photo.jpg", log);

        assertEquals("Showing photo.jpg", proxy.display());
    }

    @Test
    void firstDisplay_loadsTheRealImage() {
        Image proxy = new ImageProxy("photo.jpg", log);

        proxy.display();

        assertEquals(List.of("Loading photo.jpg"), log);
    }

    @Test
    void displayManyTimes_loadsTheRealImageOnlyOnce() {
        Image proxy = new ImageProxy("photo.jpg", log);

        proxy.display();
        proxy.display();
        proxy.display();

        assertEquals(1, log.size(), "The real image must be loaded only one time");
    }

    @Test
    void eachProxy_hasItsOwnRealImage() {
        new ImageProxy("a.jpg", log).display();
        new ImageProxy("b.jpg", log).display();

        assertEquals(List.of("Loading a.jpg", "Loading b.jpg"), log);
    }
}
