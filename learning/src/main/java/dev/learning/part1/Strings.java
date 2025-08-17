package dev.learning.part1;

// Demonstrates how Strings work in Java.

/*
 * Key Notes about Strings:
 * ------------------------
 * 1. Strings are reference types (they are objects of class java.lang.String).
 * 2. They are IMMUTABLE: once created, their value cannot change.
 * 3. Two ways to create Strings:
 *    - String literal: stored in the String Pool (inside JVM memory).
 *    - new String(): creates a new object in the heap (outside the pool).
 * 4. String methods return a NEW String instead of modifying the original.
 * 5. Comparing Strings:
 *    - == compares references (memory addresses).
 *    - .equals() compares actual content.
 */

public class Strings {

    public static void main(String[] args) {
        // Creating Strings
        String str1 = "Hello";            // String literal (goes into String Pool)
        String str2 = "Hello";            // Reuses the same literal from pool
        String str3 = new String("Hello"); // Forces creation of a new object

        // Comparing Strings
        System.out.println("str1 == str2 ? " + (str1 == str2));   // true (same object from pool)
        System.out.println("str1 == str3 ? " + (str1 == str3));   // false (different objects)
        System.out.println("str1.equals(str3) ? " + str1.equals(str3)); // true (same content)

        // Immutability demonstration
        String original = "Java";
        String modified = original.concat(" Programming"); // creates NEW string
        System.out.println("\nOriginal: " + original);   // "Java" (unchanged)
        System.out.println("Modified: " + modified);     // "Java Programming"

        // Common String methods
        String text = "  Learn Java  ";
        System.out.println("\nLength: " + text.length());            // count characters
        System.out.println("Uppercase: " + text.toUpperCase());      // convert to upper
        System.out.println("Trimmed: '" + text.trim() + "'");        // remove spaces
        System.out.println("Substring (0,5): " + text.substring(0, 5)); // extract part
        System.out.println("Contains 'Java'? " + text.contains("Java")); // check word
    }
}
