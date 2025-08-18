package dev.learning.fundamental;

// Demonstrates different types of for loops in Java.

/*
 * For loop syntax:
 * ----------------
 * for (initialization; condition; update) {
 *     // code to repeat
 * }
 *
 * Flow:
 * 1. Initialization → runs once
 * 2. Condition → checked before every iteration
 * 3. Loop body → runs if condition is true
 * 4. Update → runs after each loop iteration
 */

public class ForLoop {

    public static void main(String[] args) {
        // 1. Basic for loop
        System.out.println("Basic for loop (counting 1 to 5):");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        // 2. Reverse counting
        System.out.println("\nReverse counting (5 to 1):");
        for (int i = 5; i >= 1; i--) {
            System.out.println("i = " + i);
        }

        // 3. Loop with step (increment by 2)
        System.out.println("\nEven numbers (0 to 10):");
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }

        // 4. Using for loop with array
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("\nArray elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // 5. Infinite loop (be careful - press stop to end!)
        // for (;;) {
        //     System.out.println("This will run forever...");
        // }
    }
}
