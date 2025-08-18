package dev.learning.fundamental;

// Demonstrates different forms of if statements in Java.

/*
 * Forms of if statements:
 * -----------------------
 * 1. Simple if
 * 2. If-else
 * 3. If-else-if ladder
 * 4. Nested if
 */

public class IfStatement {

    public static void main(String[] args) {
        int number = 15;

        // 1. Simple if
        if (number > 10) {
            System.out.println("Number is greater than 10");
        }

        // 2. if-else
        if (number % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }

        // 3. if-else-if ladder
        if (number < 0) {
            System.out.println("Number is negative");
        } else if (number == 0) {
            System.out.println("Number is zero");
        } else {
            System.out.println("Number is positive");
        }

        // 4. Nested if
        if (number > 0) {
            if (number < 20) {
                System.out.println("Number is positive and less than 20");
            }
        }
    }
}
