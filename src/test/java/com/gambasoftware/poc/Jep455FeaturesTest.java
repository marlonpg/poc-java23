package com.gambasoftware.poc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// ### Advantages of JEP 455: Primitive Types in Patterns, instanceof, and switch (Preview)
/// - Better readability and conciseness by removing boilerplate casting code.
/// - More expressive handling of data types, especially primitives, in pattern matching.
/// - Enhanced flexibility by allowing additional runtime constraints (with `when`).
/// - Type safety and compiler-assisted error detection via exhaustiveness checking.
public class Jep455FeaturesTest {

    @Test
    void primitive_in_instanceof() {
        Object value = 42;
        String result;
        if (value instanceof int i) {
            result = "Value is an int: " + i;
        } else if (value instanceof double d) {
            result = "Value is a double: " + d;
        } else {
            result = "Value is of an unknown type: " + value;
        }

        assertEquals("Value is an int: 42", result);
    }

    @Test
    void primitive_in_switch() {
        Object value = 10.5;
        String result = switch (value) {
            case int i when i > 0 -> "Value is a positive int: " + i;
            case double d when d > 0 -> "Value is a positive double: " + d;
            case int i -> "Value is a non-positive int: " + i;
            case double d -> "Value is a non-positive double: " + d;
            case String s -> "Value is a String: " + s;
            default -> "Value is of an unknown type: " + value;
        };

        assertEquals("Value is a positive double: 10.5", result);
    }
}
