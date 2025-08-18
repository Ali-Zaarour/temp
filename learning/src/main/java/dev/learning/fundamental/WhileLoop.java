package dev.learning.fundamental;

// Demonstrates while loops in Java.

/*
 * while loop syntax:
 * ------------------
 * while (condition) {
 *     // code to repeat
 * }
 *
 * Flow:
 * 1. Condition is checked.
 * 2. If true, → loop body executes.
 * 3. After body → go back and re-check condition.
 * 4. Loop ends when the condition is false.
 */

import java.util.Scanner;

public class WhileLoop {

    public static void main(String[] args) {
        // 1. Basic while loop (counting 1 to 5)
        System.out.println("Counting 1 to 5:");
        int i = 1;
        while (i <= 5) {
            System.out.println("i = " + i);
            i++; // update
        }

        // 2. Reverse counting
        System.out.println("\nReverse counting (5 to 1):");
        int j = 5;
        while (j >= 1) {
            System.out.println("j = " + j);
            j--; // decrement
        }

        // 3. Reading input until user types "exit"
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("\nType words (type 'exit' to quit):");
        while (!input.equals("exit")) {
            System.out.print("Enter text: ");
            input = scanner.nextLine();
            System.out.println("You entered: " + input);
        }
        scanner.close();

        // 4. Infinite loop example (be careful - uncomment to test)
        // while (true) {
        //     System.out.println("This runs forever!");
        // }
    }
}
