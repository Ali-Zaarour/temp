package dev.learning.oop;

// Topic: Static Members in Java

/*
 * Static Members:
 * 1. Static Variable → shared among all objects of the class.
 * 2. Static Method → can be called without creating an object.
 * 3. Static Block → executed once when the class is loaded.
 *
 * Benefits:
 * - Saves memory (common data shared across objects).
 * - Useful for utility methods and constants.
 */

class Library {
    // === Static variable (shared by all objects) ===
    static int totalBooks = 0;

    // === Instance variable (unique per object) ===
    String bookTitle;

    // Constructor
    Library(String bookTitle) {
        this.bookTitle = bookTitle;
        totalBooks++; // Every new book increases total count
    }

    // === Instance method ===
    void showBook() {
        System.out.println("Book: " + bookTitle);
    }

    // === Static method ===
    static void showTotalBooks() {
        System.out.println("Total books in library: " + totalBooks);
    }

    // === Static block ===
    static {
        System.out.println("Library system is initializing...");
    }
}

public class StaticMember {

    public static void main(String[] args) {
        // Create objects
        Library b1 = new Library("Java Basics");
        Library b2 = new Library("OOP Concepts");
        Library b3 = new Library("Data Structures");

        // Instance methods (per object)
        b1.showBook();
        b2.showBook();
        b3.showBook();

        // Static method (can be called via class name, no object needed)
        Library.showTotalBooks();

        /*
         * Key Points:
         * - totalBooks is static → shared across all Library objects.
         * - Every new book increments the same totalBooks variable.
         * - Static block runs only once when the class is first loaded.
         * - Static methods are called with ClassName.methodName().
         */
    }
}
