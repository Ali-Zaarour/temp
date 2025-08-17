package dev.learning.part1;

// File: HelloWorld.java
// This is the most basic Java program structure.

// In Java, everything must be inside a class.
// The class is a blueprint for creating objects,
// but also the container for your program.

// The main method is the entry point of a Java program.
// - public: accessible by JVM from anywhere
// - static: does not require creating an object
// - void: does not return anything
// - String[] args: allows command-line arguments

public class HelloWorld {
    // The main method: entry point of every Java application
    public static void main(String[] args) {
        // Print text to the console
        // System: A built-in class
        // out: A static member (output stream)
        // println: method to print text + new line
        System.out.println("Hello, World!");
        System.out.println("Every Java program must have at least one class!");
        System.out.println("Main method is where execution starts.");


        // Single-line comment: use //
        // Multi-line comment: use /* ... */
        // Documentation comment: use /** ... */

        // This is a single-line comment
        System.out.println("Hello with comments!");

        /* This is a multi-line comment
           It can span multiple lines. */
        System.out.println("Comments help explain code.");

        /** Documentation comments
         * are used for generating Javadocs. */
        System.out.println("Useful for documentation!");
    }
}

