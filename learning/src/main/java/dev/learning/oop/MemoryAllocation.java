package dev.learning.oop;

// Topic: Memory Allocation in Java

/*
 * Memory in Java is divided mainly into:
 * 1. Stack → Stores local variables and references (e.g., "Book b1").
 * 2. Heap → Stores actual objects created with "new" (e.g., new Book(...)).
 *
 * Example:
 * Book b1 = new Book ("Java Basics", "John Doe");
 * - "b1" (the reference) is stored in the stack.
 * - The actual Book object ("Java Basics", "John Doe") is stored in the heap.
 */

class Book {
    String title;
    String author;

    // Constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method
    void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

public class MemoryAllocation {
    public static void main(String[] args) {
        // === Memory Allocation Demonstration ===

        // b1 and b2 are references (stored in stack).
        Book b1 = new Book("Java Basics", "John Doe");   // Object in heap
        Book b2 = new Book("OOP Concepts", "Alice Lee"); // Another object in heap

        // Each "new" creates a new object in heap memory.
        b1.displayInfo();
        b2.displayInfo();

        // Two references can point to the same object.
        Book b3 = b1; // b3 now points to the same heap object as b1
        b3.displayInfo();

        /*
         * Memory Picture:
         *
         * Stack: (holds references)
         *   b1 → (heap: Book "Java Basics")
         *   b2 → (heap: Book "OOP Concepts")
         *   b3 → (same as b1 → "Java Basics")
         *
         * Heap: (holds actual objects)
         *   [Book Object: "Java Basics", "John Doe"]
         *   [Book Object: "OOP Concepts", "Alice Lee"]
         */
    }
}

