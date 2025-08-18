package dev.learning.fundamental;

// Demonstrates reserved words in Java.

/*
 * Reserved words in Java:
 * -----------------------
 * - There are 50+ reserved words in Java.
 * - They are all lowercase.
 * - You do not use them as identifiers (variable names, class names, etc.).
 *
 * Categories:
 * 1. Data types: byte, short, int, long, float, double, char, boolean
 * 2. Control flow: if, else, switch, case, default, while, do, for, break, continue, return
 * 3. Access modifiers: public, private, protected
 * 4. Class-related: class, interface, enum, abstract, extends, implements, new, package, import
 * 5. Exception handling: try, catch, finally, throw, throws
 * 6. Others: static, final, void, super, this, synchronized, volatile, transient, instanceof, const*, goto*
 *
 */

public class ReservedWords {

    public static void main(String[] args) {
        // Example: you CANNOT do this:
        // int class = 10;   // ERROR: 'class' is a reserved word
        // String public = "Hi"; // ERROR

        // Instead, use normal identifiers:
        int number = 10;       //  valid variable name
        String message = "Hello"; //  valid variable name

        System.out.println("Reserved words cannot be used as identifiers.");
        System.out.println("Example valid identifiers: number = " + number + ", message = " + message);
    }
}
