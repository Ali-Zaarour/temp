package dev.learning.fundamental;

// Demonstrates the for-each (enhanced for) loop in Java.

/*
 * For-each loop syntax:
 * ---------------------
 * for (dataType variable : collection/array) {
 *     // code using variable
 * }
 *
 * Notes:
 * - Works on arrays and any class that implements Iterable (e.g., ArrayList).
 * - Simpler than traditional for loop (no index handling).
 * - You cannot modify the structure of the collection inside it (use Iterator for that).
 */

import java.util.ArrayList;

public class ForEachLoop {

    public static void main(String[] args) {
        // 1. For-each loop with an array
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array elements:");
        for (int num : numbers) {
            System.out.println(num);
        }

        // 2. For-each loop with a String array
        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.println("\nFruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 3. For-each loop with an ArrayList
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("\nNames in ArrayList:");
        for (String name : names) {
            System.out.println(name);
        }

        // 4. Limitation: cannot directly modify array/collection structure
        System.out.println("\nTrying to double numbers inside for-each:");
        for (int num : numbers) {
            // num is a copy → changing it won't affect array
            System.out.println("num*2 = " + (num * 2));
        }

        System.out.println("Original array after for-each:");
        for (int num : numbers) {
            System.out.println(num); // unchanged
        }
    }
}
