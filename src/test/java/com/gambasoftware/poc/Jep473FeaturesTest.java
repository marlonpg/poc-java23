package com.gambasoftware.poc;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
/// ### Advantages of JEP 473: Stream Gatherers (Second Preview)
/// - enhance the Stream API by enabling custom intermediate operations for greater flexibility and expressiveness.
public class Jep473FeaturesTest {

    @Test
    void testStreamFeatures() {
        var numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        var gathered = numbers.gather(Gatherers.windowFixed(3)).toList();

        assertEquals(List.of(1, 2, 3), gathered.get(0));
        assertEquals(List.of(4, 5, 6), gathered.get(1));
        assertEquals(List.of(7, 8, 9), gathered.get(2));
    }

    @Test
    void slidingWindow() {
        var numbers = Stream.of(1, 2, 3, 4, 5);

        var gathered = numbers.gather(Gatherers.windowSliding(3)).toList();

        assertEquals(List.of(1, 2, 3), gathered.get(0));
        assertEquals(List.of(2, 3, 4), gathered.get(1));
        assertEquals(List.of(3, 4, 5), gathered.get(2));
    }

    @Test
    void fold() {
        var numbers = Stream.of(1, 2, 3, 4, 5);

        numbers.gather(Gatherers.fold(() -> 1, (a, b) -> a * b))
                .forEach(System.out::println);
    }

    @Test
    void scan() {
        var numbers = Stream.of(1, 2, 3, 4, 5);

        numbers.gather(Gatherers.scan(() -> 1, (a, b) -> a * b))
                .forEach(System.out::println);
    }

    @Test
    void mapConcurrent() {
        var numbers = Stream.of(1, 2, 3, 4, 5).parallel();

        var counter = new AtomicInteger(0);

        System.out.println("Map concurrent example:");
        var gathered = numbers.gather(Gatherers.mapConcurrent(4, number -> {
                    counter.incrementAndGet();
                    return number * 2;
                }))
                .toList();


        assertEquals(List.of(2, 4, 6, 8, 10), gathered);
        assertEquals(5, counter.get());
    }
}
