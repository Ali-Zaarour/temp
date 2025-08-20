package dev.learning.oop;

// Topic: Procedural Programming in Java

/*
 * Procedural Programming:
 * - Focuses on functions (methods) and procedures.
 * - Data and behavior are separate (no objects).
 * - Code runs step by step in a linear flow.
 *
 * Difference from OOP:
 * - OOP groups data and behavior inside classes.
 * - Procedural programming just uses functions to operate on data.
 */

public class ProceduralProgramming {

    // === Functions (procedures) ===
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        // === Procedural flow ===
        int num1 = 20;
        int num2 = 5;

        // Calling functions directly (procedural style)
        System.out.println("Addition: " + add(num1, num2));
        System.out.println("Subtraction: " + subtract(num1, num2));
        System.out.println("Multiplication: " + multiply(num1, num2));
        System.out.println("Division: " + divide(num1, num2));

        /*
         * Key Points:
         * - num1 and num2 are separate variables.
         * - Functions operate directly on them.
         * - No encapsulation, inheritance, or polymorphism.
         * - Easy for small programs, harder to maintain for large ones.
         */
    }
}

