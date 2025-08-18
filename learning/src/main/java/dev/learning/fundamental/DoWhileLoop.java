package dev.learning.fundamental;

// Demonstrates do-while loops in Java.

/*
 * do-while loop syntax:
 * ---------------------
 * do {
 *     // code to repeat
 * } while (condition);
 *
 * Key difference from while:
 * - while → check condition first, then run
 * - do-while → run first, then check condition
 * - So do-while always executes at least once
 */

import java.util.Scanner;

public class DoWhileLoop {

    public static void main(String[] args) {
        // 1. Basic do-while loop
        System.out.println("Counting 1 to 5:");
        int i = 1;
        do {
            System.out.println("i = " + i);
            i++;
        } while (i <= 5);

        // 2. Example with user input (runs at least once)
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("\nEnter text (type 'exit' to quit): ");
            input = scanner.nextLine();
            System.out.println("You entered: " + input);
        } while (!input.equals("exit"));
        scanner.close();

        // 3. Example where condition is false initially
        int num = 100;
        do {
            System.out.println("\nThis runs once even though num < 0 is false!");
        } while (num < 0); // false, but body still ran once
    }
}
