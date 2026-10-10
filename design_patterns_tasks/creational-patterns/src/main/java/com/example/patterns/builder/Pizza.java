package com.example.patterns.builder;

/**
 * A pizza. The size is required, the toppings are optional.
 *
 * Without a builder you would need a constructor like
 *     new Pizza("large", true, false, true)
 * and nobody knows what "true, false, true" means. With a builder you write
 *     new Pizza.Builder().size("large").cheese(true).mushrooms(true).build()
 *
 * The Pizza itself is already finished (it can only be created by its Builder).
 *
 * STUDENT TASK 3 - finish the Builder class at the bottom of this file.
 */
public class Pizza {

    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;

    // PROVIDED - private, so a Pizza can only be created by the Builder.
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public String getSize() {
        return size;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }

    @Override
    public String toString() {
        return "Pizza{size=" + size + ", cheese=" + cheese
                + ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + "}";
    }

    // ------------------------------------------------------------------
    // STUDENT TASK 3
    // ------------------------------------------------------------------
    public static class Builder {

        // The fields are already here. The methods below must fill them.
        private String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;

        public Builder size(String size) {
            // TODO: save the size in the field, then return this.
            return this;            // TEMPORARY - it does not save anything yet
        }

        public Builder cheese(boolean cheese) {
            // TODO: save the value in the field, then return this.
            return this;            // TEMPORARY
        }

        public Builder pepperoni(boolean pepperoni) {
            // TODO: save the value in the field, then return this.
            return this;            // TEMPORARY
        }

        public Builder mushrooms(boolean mushrooms) {
            // TODO: save the value in the field, then return this.
            return this;            // TEMPORARY
        }

        public Pizza build() {
            // TODO:
            // 1. The size is required. If size is null or empty (size.isEmpty()),
            //    throw new IllegalStateException("Size is required").
            // 2. Create the pizza: return new Pizza(this)

            return null;            // TEMPORARY - delete this line
        }
    }
}
