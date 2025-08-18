package dev.learning.fundamental;

// Demonstrates break and continue statements in Java.

/*
 * break:
 * ------
 * - Immediately exits the loop (or switch).
 * - Control goes to the statement after the loop.
 *
 * continue:
 * ---------
 * - Skips the current iteration of the loop.
 * - Control jumps back to the loop condition for the next iteration.
 */

public class BreakAndContinue {

    public static void main(String[] args) {
        // 1. break example in a for loop
        System.out.println("Break example (stop at 5):");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("i = 5 → break!");
                break; // exits loop entirely
            }
            System.out.println("i = " + i);
        }

        // 2. continue example in a for loop
        System.out.println("\nContinue example (skip 5):");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("i = 5 → continue (skip this iteration)");
                continue; // skip rest of body, go to next iteration
            }
            System.out.println("i = " + i);
        }

        // 3. break in a while loop
        System.out.println("\nBreak in while loop:");
        int j = 1;
        while (j <= 10) {
            if (j == 7) {
                System.out.println("j = 7 → break!");
                break;
            }
            System.out.println("j = " + j);
            j++;
        }

        // 4. continue in a while loop
        System.out.println("\nContinue in while loop:");
        int k = 0;
        while (k < 10) {
            k++;
            if (k % 2 == 0) {
                continue; // skip even numbers
            }
            System.out.println("Odd number: " + k);
        }
    }
}
