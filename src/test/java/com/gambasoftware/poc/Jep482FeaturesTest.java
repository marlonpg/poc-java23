package com.gambasoftware.poc;

import org.junit.jupiter.api.Test;

/// ### Advantages of JEP 482: Flexible Constructor Bodies
/// - Allows operations on the partially constructed object, such as validations or computations, before calling the superclass constructor.
/// - Provides the ability to handle conditional initialization or default value assignments in constructor bodies before superclass initialization.
///
public class Jep482FeaturesTest {
    class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            if (name == null || name.isEmpty()) {
                System.out.println("Initializing with a placeholder due to missing name...");
                name = "Unnamed";
            }
            this.name = name;

            System.out.println("Checked and starting initialization for age...");
            this.age = age;
        }
    }

    @Test
    void flexible_constructor_bodies() {
        Person person = new Person(null, 10);
        System.out.println(person.name);
        System.out.println(person.age);
    }
}
