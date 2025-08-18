package dev.learning.fundamental;

// Demonstrates defining and using methods in Java.

/*
 * What is a method?
 * -----------------
 * - A method is a reusable block of code.
 * - It has a name, may take parameters, and may return a value.
 *
 * Syntax:
 *   modifier returnType methodName(parameters) {
 *       // method body
 *   }
 *
 * Types of Methods:
 * -----------------
 * 1. Predefined (built-in) methods → e.g., Math.sqrt(), System.out.println()
 * 2. User-defined methods → created by programmer
 */

public class Method {

    // 1. Method with no parameters and no return value
    public void sayHello() {
        System.out.println("Hello from method!");
    }

    // 2. Method with parameters and no return value
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // 3. Method with parameters and return value
    public int add(int a, int b) {
        return a + b;
    }

    // 4. Static method (belongs to class, no need to create an object)
    public static double square(double x) {
        return x * x;
    }

    public static void main(String[] args) {
        // Creating an object to call non-static methods
        Method obj = new Method();

        // Calling method with no parameters
        obj.sayHello();

        // Calling method with parameters
        obj.greet("Ali");

        // Calling method with parameters and return
        int sum = obj.add(10, 20);
        System.out.println("Sum = " + sum);

        // Calling static method (no object needed)
        double result = Method.square(5.5);
        System.out.println("Square of 5.5 = " + result);

        // Example of predefined method (from Math class)
        System.out.println("Square root of 16 = " + Math.sqrt(16));
    }
}
