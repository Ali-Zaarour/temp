package dev.learning.part1;

// Demonstrates comparison (relational) operators in Java.

/*
 * Comparison Operators:
 * ----------------------
 * ==   : equal to
 * !=   : not equal to
 * >    : greater than
 * <    : less than
 * >=   : greater than or equal to
 * <=   : less than or equal to
 *
 * - These operators return a boolean (true or false).
 * - Can be used with primitives (int, double, char, etc.).
 * - With objects (like String), use .equals() instead of ==.
 */

public class ComparisonOperators {

    public static void main(String[] args) {
        int a = 10, b = 20;

        // == Equal to
        System.out.println("a == b ? " + (a == b)); // false

        // != Not equal to
        System.out.println("a != b ? " + (a != b)); // true

        // > Greater than
        System.out.println("a > b ? " + (a > b));   // false

        // < Less than
        System.out.println("a < b ? " + (a < b));   // true

        // >= Greater than or equal
        System.out.println("a >= 10 ? " + (a >= 10)); // true

        // <= Less than or equal
        System.out.println("b <= 15 ? " + (b <= 15)); // false

        // With double
        double x = 5.5, y = 5.5;
        System.out.println("\nx == y ? " + (x == y)); // true

        // With char (compares Unicode values)
        char c1 = 'A'; // Unicode 65
        char c2 = 'B'; // Unicode 66
        System.out.println("\nc1 < c2 ? " + (c1 < c2)); // true

        // With String (reference type)
        String s1 = new String("Java");
        String s2 = new String("Java");
        System.out.println("\nUsing == on String: " + (s1 == s2));       // false (different objects)
        System.out.println("Using .equals() on String: " + s1.equals(s2)); // true (same content)
    }
}
