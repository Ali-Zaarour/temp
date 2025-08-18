package dev.learning.fundamental;

// Demonstrates logical operators in Java.

/*
 * Logical Operators:
 * ------------------
 * &&   : Logical AND   → true if both are true
 * ||   : Logical OR    → true if at least one is true
 * !    : Logical NOT   → inverts the boolean value
 *
 * Notes:
 * - && and || are short-circuit operators:
 *   - In (A && B), if A is false, B is not evaluated.
 *   - In (A || B), if A is true, B is not evaluated.
 */

public class LogicalOperators {

    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        // AND (&&)
        System.out.println("x && y = " + (x && y)); // false
        System.out.println("x && true = " + (x && true)); // true

        // OR (||)
        System.out.println("\nx || y = " + (x || y)); // true
        System.out.println("y || false = " + (y || false)); // false

        // NOT (!)
        System.out.println("\n!x = " + (!x)); // false
        System.out.println("!y = " + (!y)); // true

        // Combining with comparison operators
        int a = 10, b = 20, c = 30;
        boolean condition = (a < b) && (b < c); // true && true
        System.out.println("\n(a < b) && (b < c) = " + condition);

        // Short-circuit example
        int num = 5;
        boolean test = (num > 10) && (++num > 0); // left is false, right not evaluated
        System.out.println("\nShort-circuit AND: num = " + num); // still 5 (no increment)

        boolean test2 = (num < 10) || (++num > 0); // left is true, right not evaluated
        System.out.println("Short-circuit OR: num = " + num); // still 5 (no increment)
    }
}
