package com.gambasoftware.poc;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.classfile.ClassElement;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.FieldModel;
import java.lang.classfile.MethodModel;
import java.nio.file.Files;
import java.nio.file.Path;

/// ### Advantages of JEP 466: Class-File API (Second Preview)
/// - No need for low-level byte manipulation libraries.
/// - Simplifies creating Java agents, frameworks, and tools that analyze or transform class files.
/// - Easy access to the binary structure of `.class` files for tooling developers.
public class Jep466FeaturesTest {

    @Test
    void test() throws IOException {
        Path classFilePath = Path.of("target/classes/com/gambasoftware/poc/ExampleClass.class");

        // Parse the class file
        byte[] classFileBytes = Files.readAllBytes(classFilePath);
        ClassModel classModel = ClassFile.of().parse(classFileBytes);

        for (FieldModel fieldModel : classModel.fields()) {
            System.out.printf("Field %s%n", fieldModel.fieldName().stringValue());
        }

        for (ClassElement classElement : classModel) {
            switch (classElement) {
                case MethodModel methodModel -> System.out.printf("Method %s%n", methodModel.methodName().stringValue());
                case FieldModel fieldModel -> System.out.printf("Field %s%n", fieldModel.fieldName().stringValue());
                default -> {}
            }
        }
    }
}
