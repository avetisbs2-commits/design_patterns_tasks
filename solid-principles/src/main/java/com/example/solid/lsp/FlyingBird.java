package com.example.solid.lsp;

/**
 * A bird that CAN fly. Only classes that really fly may implement it.
 * Every FlyingBird promises: "if you call fly(), it works".
 *
 * PROVIDED CODE - do not change.
 */
public interface FlyingBird extends Bird {

    String fly();
}
