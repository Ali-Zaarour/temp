package dev.learning.fundamental;

// This class explains how variables work in Java.

/*
 * What is a variable?
 * -------------------
 * A variable is a "named storage" in memory that holds a value
 * which can change during program execution.
 *
 * Syntax:
 *   dataType variableName = value;
 *
 * Types of variables in Java:
 * 1. Local variables -> declared inside methods, exist only during method execution
 * 2. Instance variables -> declared inside a class but outside methods, each object has its own copy
 * 3. Static variables -> declared with 'static', shared across all objects of a class
 */

public class Variable {

    // Instance variable (belongs to the object, not static)
    int instanceVar = 10;

    // Static variable (shared by all objects of the class)
    static String staticVar = "Shared across all objects";

    public static void main(String[] args) {
        // Local variable: declared inside the method
        int localVar = 5;

        // Printing a local variable
        System.out.println("Local variable value: " + localVar);

        // Creating an object to access instance variables
        Variable obj = new Variable();
        System.out.println("Instance variable value: " + obj.instanceVar);

        // Accessing static variable (no object needed)
        System.out.println("Static variable value: " + Variable.staticVar);

        // Example of re-assigning a variable
        localVar = 20; // variable value changes
        System.out.println("Local variable after reassignment: " + localVar);
    }
}
