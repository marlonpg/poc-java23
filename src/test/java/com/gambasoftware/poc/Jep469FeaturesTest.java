package com.gambasoftware.poc;


import module jdk.incubator.vector;
import org.junit.jupiter.api.Test;

/// ### Advantages of JEP 469: Vector API (Eighth Incubator)
/// - Operates directly on **vectorized hardware instructions** provided by modern CPUs (like AVX on x86 or NEON on ARM).
/// - Improves performance by enabling parallel computation on hardware vectors rather than scalar values.
/// - Automatically adapts to the underlying hardware without requiring platform-specific code.

public class Jep469FeaturesTest {
    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    @Test
    void vector() {
        float[] array = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f};

        // Define the vector species
        VectorSpecies<Float> species = FloatVector.SPECIES_PREFERRED;

        // Load the array into a vector
        FloatVector vector = FloatVector.fromArray(species, array, 0);

        // Print the vector
        System.out.println("Vector: " + vector);
    }
}
