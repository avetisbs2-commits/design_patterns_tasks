package com.example.solid.lsp;

/**
 * A sparrow can fly, so it is a FlyingBird. WORKED EXAMPLE for Eagle.
 *
 * PROVIDED CODE - do not change.
 */
public class Sparrow implements FlyingBird {

    @Override
    public String getName() {
        return "Sparrow";
    }

    @Override
    public String fly() {
        return "Sparrow flies";
    }
}
