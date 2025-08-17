package dev.learning.part1;

// This class demonstrates reference types in Java.

/*
 * Reference Types in Java:
 * ------------------------
 * Unlike primitive types, reference types store a reference (memory address)
 * to the actual object stored in the heap.
 *
 * Common reference types include:
 * 1. Classes (e.g., String, custom classes)
 * 2. Arrays
 * 3. Interfaces
 * 4. Enums
 *
 * Key Points:
 * - All reference types are created using the 'new' keyword (except String literals).
 * - They can be null (which means "no object reference").
 * - They support methods and properties (unlike primitives).
 */

import java.util.Date; // Example of a built-in class

public class ReferenceTypes {

    public static void main(String[] args) {
        // 1. String (a class, not primitive!)
        String str1 = "Hello"; // String literal (stored in String Pool)
        String str2 = new String("World"); // explicitly creating a new String object
        System.out.println("String values: " + str1 + " " + str2);

        // 2. Arrays (reference type because it is an object)
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("First element of array: " + numbers[0]);
        System.out.println("Array length: " + numbers.length);

        // 3. Custom Class object
        Person person = new Person("Alice", 25); // Creating an object using 'new'
        person.sayHello();

        // 4. Built-in class object
        Date date = new Date(); // java.util.Date object
        System.out.println("Current date: " + date);

        // 5. Null reference
        String emptyRef = null;
        System.out.println("Null reference example: " + emptyRef);

        // Comparing reference types
        System.out.println("Are str1 and str2 the same object? " + (str1 == str2));
        System.out.println("Do str1 and str2 have the same content? " + str1.equals(str2));
    }
}

// A simple custom class to demonstrate a reference type
class Person {
    String name;  // Instance variable (reference type: String)
    int age;      // Primitive type

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method
    void sayHello() {
        System.out.println("Hello, my name is " + name + " and I'm " + age + " years old.");
    }
}
