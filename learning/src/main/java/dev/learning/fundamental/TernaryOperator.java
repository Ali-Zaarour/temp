package dev.learning.fundamental;

// Demonstrates ternary operator usage in Java.

/*
 * Ternary Operator Syntax:
 * ------------------------
 * result = (condition) ? valueIfTrue : valueIfFalse;
 *
 * - If condition is true  → result = valueIfTrue
 * - If condition is false → result = valueIfFalse
 *
 * Notes:
 * - It’s a shorthand for if-else.
 * - It can be nested, but too many nested ternaries reduce readability.
 */

public class TernaryOperator {

    public static void main(String[] args) {
        int number = 15;

        // 1. Basic example
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("Number is: " + result);

        // 2. Assigning directly to a variable
        boolean isPositive = (number > 0) ? true : false;
        System.out.println("Is positive? " + isPositive);

        // Simplified version (no ternary needed for booleans)
        boolean isPositive2 = number > 0;
        System.out.println("Simplified boolean: " + isPositive2);

        // 3. Nested ternary (like if-else-if ladder)
        int score = 85;
        String grade = (score >= 90) ? "A"
                : (score >= 80) ? "B"
                : (score >= 70) ? "C"
                : "D";
        System.out.println("Score = " + score + " → Grade = " + grade);

        // 4. Using ternary inside println
        System.out.println("Result: " + ((score >= 50) ? "Pass" : "Fail"));
    }
}
