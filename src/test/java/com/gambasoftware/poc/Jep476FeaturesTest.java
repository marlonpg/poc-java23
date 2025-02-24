package com.gambasoftware.poc;

import module java.base;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/// Module Import Declarations (Preview)
///https://www.infoq.com/news/2024/05/simplifying-java-module-import/
public class Jep476FeaturesTest {

    @BeforeAll
    static void beforeAll() {}

    @Test
    void test() {
        List<String> list = List.of("a", "b", "c");
        System.out.println(list);
    }
}
