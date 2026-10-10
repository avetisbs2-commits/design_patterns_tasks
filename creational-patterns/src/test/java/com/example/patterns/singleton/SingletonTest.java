package com.example.patterns.singleton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Checks Task 1 (Singleton). PROVIDED CODE - do not change. */
class SingletonTest {

    @Test
    void getInstance_returnsTheSameObjectEveryTime() {
        AppSettings first = AppSettings.getInstance();
        AppSettings second = AppSettings.getInstance();

        assertSame(first, second, "getInstance() must always return the same object");
    }

    @Test
    void constructor_isPrivate() {
        for (Constructor<?> constructor : AppSettings.class.getDeclaredConstructors()) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()),
                    "The constructor must be private, so nobody can write new AppSettings()");
        }
    }

    @Test
    void settings_areSharedEverywhere() {
        AppSettings.getInstance().setAppName("Shared Name");

        assertEquals("Shared Name", AppSettings.getInstance().getAppName());
    }

    @Test
    void getInstance_returnsOneObjectEvenFromManyThreads() throws InterruptedException {
        Set<AppSettings> found = Collections.synchronizedSet(new HashSet<>());
        Thread[] threads = new Thread[50];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> found.add(AppSettings.getInstance()));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        assertEquals(1, found.size(), "All threads must get the same object");
    }
}
