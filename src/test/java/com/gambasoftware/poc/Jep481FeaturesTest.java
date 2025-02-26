package com.gambasoftware.poc;

import org.junit.jupiter.api.Test;

/// ### Advantages of JEP 481: Scoped Values (Third Preview)
/// - Scoped Values eliminate the need to pass extra parameters through method calls to transfer data. Frameworks no longer need to burden user code with passing internal context explicitly.
/// - The syntactic structure (using `ScopedValue.runWhere`) makes the scope of shared data immediately clear and bounded, improving both **readability** and **reasoning** about the code.
/// - Scoped Values are **immutable**, unlike `ThreadLocal`, which allows unconstrained mutability. This ensures that once a value is set in a scope, it cannot be overwritten or altered unexpectedly, promoting **deterministic** behavior.
/// - Scoped Values allow **automatic inheritance** across a parent thread and its child threads. When used with structured concurrency (JEP 480), scoped values make cross-thread data sharing highly efficient.
/// - Unlike `ThreadLocal`, no data duplication occurs when child threads inherit the parent's scoped value. The memory overhead for child threads is minimal.
public class Jep481FeaturesTest {
    private static final ScopedValue<String> X = ScopedValue.newInstance();
    @Test
    void scoped_value() {
        new FooBar().foo();
    }

    class FooBar {
        void foo() {
            ScopedValue.runWhere(X, "hello", () -> bar());
        }

        void bar() {
            System.out.println(X.get());
            ScopedValue.runWhere(X, "goodbye", () -> baz());
            System.out.println(X.get());
        }

        void baz() {
            System.out.println(X.get());
        }
    }
}
