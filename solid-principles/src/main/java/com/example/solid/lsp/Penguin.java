package com.example.solid.lsp;

/**
 * STUDENT TASK 3b - FIX THE BUG IN THE DESIGN.
 *
 * A penguin is a bird, but it CANNOT fly. Right now Penguin says it is a FlyingBird, and then
 * throws an exception when you ask it to fly. That BREAKS the Liskov principle:
 *
 *     for (FlyingBird bird : birds) {
 *         bird.fly();          // BOOM when the bird is a Penguin
 *     }
 *
 * A subclass must be usable everywhere its parent is used, without surprises.
 * The fix is NOT to catch the exception. The fix is to tell the truth in the design:
 * a penguin is a Bird (not a FlyingBird), and a penguin can swim.
 *
 * TODO:
 *   1. Change "implements FlyingBird" to "implements Bird".
 *   2. Delete the fly() method (a penguin has no fly()).
 *   3. Make swim() return "Penguin swims".
 */
public class Penguin implements FlyingBird {      // TEMPORARY - this should be "implements Bird"

    @Override
    public String getName() {
        return "Penguin";
    }

    @Override
    public String fly() {                          // TEMPORARY - delete this whole method
        throw new UnsupportedOperationException("Penguins cannot fly");
    }

    public String swim() {
        return "";  // TEMPORARY - return "Penguin swims"
    }
}
