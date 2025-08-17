package dev.learning.part1;

// Demonstrates how to declare and use constants in Java.

/*
 * Constants in Java:
 * ------------------
 * - Declared with the keyword 'final'.
 * - Once assigned, their value cannot be changed.
 * - Usually written in UPPERCASE by convention.
 *
 * Types:
 * 1. Local constant: inside a method.
 * 2. Instance constant: belongs to an object.
 * 3. Static constant: belongs to the class (shared across all objects).
 */

public class Constants {

    // Instance constant (different copy for each object)
    final int INSTANCE_CONSTANT = 100;

    // Static constant (shared by all objects of the class)
    static final double PI = 3.14159;

    public static void main(String[] args) {
        // 1. Local constant
        final String GREETING = "Hello, World!";
        System.out.println("Local constant: " + GREETING);

        // Uncommenting the next line will cause an error
        // GREETING = "Hi"; // Cannot assign a new value to a final variable

        // 2. Instance constant
        Constants obj = new Constants();
        System.out.println("Instance constant: " + obj.INSTANCE_CONSTANT);

        // 3. Static constant
        System.out.println("Static constant (PI): " + Constants.PI);

        // Example: using constants in calculation
        double radius = 5;
        double area = Constants.PI * radius * radius;
        System.out.println("Area of circle with radius 5 = " + area);
    }
}
