package com.gambasoftware.poc;

import java.io.IOException;
import java.lang.classfile.ClassElement;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.FieldModel;
import java.lang.classfile.MethodModel;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws IOException {
        Path classFilePath = Path.of("target/classes/com/gambasoftware/poc/ExampleClass.class");

        // Parse the class file
        byte[] classFileBytes = Files.readAllBytes(classFilePath);
        ClassModel classModel = ClassFile.of().parse(classFileBytes);

        for (FieldModel fieldModel : classModel.fields()) {
            System.out.printf("Field %s%n", fieldModel.fieldName().stringValue());
        }

        for (ClassElement classElement : classModel) {
            switch (classElement) {
                case MethodModel mm -> System.out.printf("Method %s%n",
                        mm.methodName().stringValue());
                case FieldModel fm -> System.out.printf("Field %s%n",
                        fm.fieldName().stringValue());
                default -> { /* NO-OP */ }
            }
        }

    }
}
