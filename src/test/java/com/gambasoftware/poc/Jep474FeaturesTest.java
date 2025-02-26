package com.gambasoftware.poc;

/// ### ZGC: Generational Mode by Default
/// - Generational Mode now standard for ZGC in Java 23
/// Switch the default mode of the Z Garbage Collector (ZGC) to the generational mode.
/// Deprecate the non-generational mode, with the intent to remove it in a future release.
///
/// Generational ZGC is used:
/// -XX:+UseZGC
///
/// Generational ZGC is used:
/// -XX:+UseZGC -XX:+ZGenerational
///
/// Non-generational ZGC is used:
/// -XX:+UseZGC -XX:-ZGenerational
/// A warning that the ZGenerational option is deprecated is issued.
/// A warning that the non-generational mode is deprecated for removal is issued.
public class Jep474FeaturesTest {
}
