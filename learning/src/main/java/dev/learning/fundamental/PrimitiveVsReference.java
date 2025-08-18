package dev.learning.fundamental;

// This class compares primitive types and reference types in Java.

/*
 * Key Difference:
 * ---------------
 * 1. Primitive types store values directly (int, double, char, etc.)
 * 2. Reference types store a reference (memory address) to an object (String, arrays, custom classes).
 *
 * - Assignment of primitives copies the value.
 * - Assignment of references copies the reference (two variables point to the same object).
 */

public class PrimitiveVsReference {

    public static void main(String[] args) {
        // ----------- Primitive Example -----------
        int a = 10;
        int b = a;  // The Value of 'a' is copied into 'b'

        System.out.println("Primitive before change: a = " + a + ", b = " + b);

        b = 20; // Change 'b' does not affect 'a'
        System.out.println("Primitive after change: a = " + a + ", b = " + b);

        // ----------- Reference Example -----------
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;  // arr2 now refers to the SAME array as arr1

        System.out.println("\nReference before change: arr1[0] = " + arr1[0] + ", arr2[0] = " + arr2[0]);

        arr2[0] = 99; // Change through arr2 also affects arr1
        System.out.println("Reference after change: arr1[0] = " + arr1[0] + ", arr2[0] = " + arr2[0]);

        // ----------- Null Reference -----------
        arr2 = null; // arr2 no longer points to the array
        System.out.println("\narr2 is now: " + arr2); // Prints null
        System.out.println("arr1 still exists, arr1[0] = " + arr1[0]);
    }
}
