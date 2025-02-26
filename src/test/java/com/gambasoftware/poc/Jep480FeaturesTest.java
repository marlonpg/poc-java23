package com.gambasoftware.poc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// ### Advantages of JEP 480: Structured Concurrency
/// - Structured concurrency automatically handles the lifecycle of tasks, ensuring they are properly completed, canceled, or cleaned up when a scope exits.
/// - Provides built-in mechanisms to propagate and handle errors across all concurrent tasks within a scope, reducing the chances of unhandled errors or inconsistent states.
///
/// Improved Observability into a new JSON thread-dump
///     The owning thread of a scope will typically be blocked in a join method waiting for subtasks to complete;
///     the thread dump makes it easy to see what the subtasks' threads are doing by showing the tree hierarchy imposed by structured concurrency.
///     The JSON object for a scope also has a reference to its parent so that the structure of the program can be reconstituted from the dump.
public class Jep480FeaturesTest {

    @Test
    void unstructured_concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();

        try (ExecutorService esvc = Executors.newFixedThreadPool(2)) {
            Future<String> user = esvc.submit(() -> findUser());
            Future<Integer> order = esvc.submit(() -> fetchOrder());

            System.out.println(user.get() + " has placed an order for " + order.get());
        } catch (ExecutionException e) {
            long end = System.currentTimeMillis();
            assertEquals("java.lang.RuntimeException: Order not found", e.getMessage());
            System.out.println("Time taken: " + (end - start) + "ms");
        }

    }

    @Test
    void structured_concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<String> user = scope.fork(() -> findUser());
            Supplier<Integer> order = scope.fork(() -> fetchOrder());

            scope.join()
                    .throwIfFailed();

            System.out.println(user.get() + " has placed an order for " + order.get());
        } catch (ExecutionException e) {
            long end = System.currentTimeMillis();
            assertEquals("java.lang.RuntimeException: Order not found", e.getMessage());
            System.out.println("Time taken: " + (end - start) + "ms");
        }
    }

    String findUser() throws InterruptedException {
        Thread.sleep(2000);
        return "John";
    }

    int fetchOrder() throws InterruptedException {
        Thread.sleep(1000);
        throw new RuntimeException("Order not found");
    }
}
