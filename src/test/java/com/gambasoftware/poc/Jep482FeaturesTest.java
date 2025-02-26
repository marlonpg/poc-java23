package com.gambasoftware.poc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/// ### Advantages of JEP 482: Flexible Constructor Bodies
/// - Allows operations on the partially constructed object, such as validations or computations, before calling the superclass constructor.
/// - Provides the ability to handle conditional initialization or default value assignments in constructor bodies before superclass initialization.
public class Jep482FeaturesTest {

    class User extends Person {
        User(String name, int age) {
            if (name == null || name.isEmpty()) {
                System.out.println("Initializing with a placeholder due to missing name...");
                name = "Unknown";
            }
            super(name, age);
        }
    }

    class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            if (name == null || name.isEmpty()) {
                System.out.println("Initializing with a placeholder due to missing name...");
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            this.name = name;

            System.out.println("Checked and starting initialization for age...");
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }


    @Test
    void flexible_constructor_bodies() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, 10);
        }, "Name cannot be null or empty");


        User user = new User(null, 10);
        assertEquals("Unknown", user.getName());
        assertEquals(10, user.getAge());
    }
}
