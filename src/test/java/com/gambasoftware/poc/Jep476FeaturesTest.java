package com.gambasoftware.poc;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import module java.base;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

/// Module Import Declarations (Preview)
/// - Enhance the Java programming language with the ability to succinctly import all of the packages exported by a module.
/// This simplifies the reuse of modular libraries, but does not require the importing code to be in a module itself.
public class Jep476FeaturesTest {

    @BeforeAll
    static void beforeAll() {
    }

    @Test
    void test() {
        String[] fruits = new String[]{"apple", "berry", "citrus"};
        Map<String, String> m =
                Stream.of(fruits)
                        .collect(Collectors.toMap(s -> s.toUpperCase().substring(0, 1),
                                Function.identity()));
    }
}
