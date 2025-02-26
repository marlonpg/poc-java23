package com.gambasoftware.poc;

public class ExampleClass extends ExampleSuperClass {
    private String name;
    private int id;

    public ExampleClass(int age) {
        if (age <= 0) throw new IllegalArgumentException("Invalid age: " + age);
        super(age);
    }
    public void exampleMethod() {
        System.out.println("Example method");
    }
}
