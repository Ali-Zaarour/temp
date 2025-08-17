package dev.learning.part1;

// Demonstrates 1D (one-dimensional) arrays in Java.

/*
 * Arrays in Java:
 * ---------------
 * - An array is a collection of elements of the SAME type stored in contiguous memory.
 * - In Java, arrays are reference types (objects).
 *
 * Declaring arrays:
 *   dataType[] arrayName;         // declaration
 *   dataType[] arrayName = new dataType[size]; // declaration + memory allocation
 *   dataType[] arrayName = {val1, val2, val3}; // declaration + initialization
 *
 * Indexing:
 * - Arrays are zero-based: first element at index 0.
 * - Last element at index (length - 1).
 */

public class Array1D {

    public static void main(String[] args) {
        // 1. Declaration + allocation
        int[] numbers = new int[5]; // array of size 5 (default values = 0)
        numbers[0] = 10; // assign values
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // 2. Declaration + initialization
        String[] fruits = {"Apple", "Banana", "Cherry"};

        // 3. Accessing elements
        System.out.println("First number: " + numbers[0]);
        System.out.println("Second fruit: " + fruits[1]);

        // 4. Length of array
        System.out.println("Numbers array length: " + numbers.length);
        System.out.println("Fruits array length: " + fruits.length);

        // 5. Iterating over arrays
        System.out.println("\nIterating with for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println("\nIterating with enhanced for loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 6. Default values
        int[] defaultValues = new int[3]; // initialized to {0, 0, 0}
        System.out.println("\nDefault int array values:");
        for (int val : defaultValues) {
            System.out.println(val);
        }
    }
}
