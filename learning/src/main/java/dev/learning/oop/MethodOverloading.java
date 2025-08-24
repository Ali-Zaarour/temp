package dev.learning.oop;

// Topic: Method Overloading in Java

/*
 * Rules for Method Overloading:
 * 1. Same method name.
 * 2. Different parameter list (number of parameters OR data type).
 * 3. Return type can be same or different, but not used alone for overloading.
 *
 * Benefit:
 * - Improves code readability.
 * - Allows one method name to handle multiple data types/variations.
 */

class Calculator {

    // === Overloaded methods ===

    // 1. Add two integers
    int sum(int a, int b) {
        return a + b;
    }

    // 2. Add three integers
    int sum(int a, int b, int c) {
        return a + b + c;
    }

    // 3. Add two doubles
    double sum(double a, double b) {
        return a + b;
    }

    // 4. Concatenate two strings (also valid overloading)
    String sum(String a, String b) {
        return a + " " + b;
    }
}

public class MethodOverloading {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // === Call different overloaded methods ===
        System.out.println("Sum of 2 ints: " + calc.sum(5, 10));             // calls int,int
        System.out.println("Sum of 3 ints: " + calc.sum(5, 10, 15));         // calls int,int,int
        System.out.println("Sum of 2 doubles: " + calc.sum(3.5, 2.8));       // calls double,double
        System.out.println("Concatenated Strings: " + calc.sum("Hello", "World")); // calls String,String

        /*
         * Key Points:
         * - Same method name "sum".
         * - Different parameter lists.
         * - Compiler decides which version to use.
         * - Improves readability and flexibility.
         */
    }
}

