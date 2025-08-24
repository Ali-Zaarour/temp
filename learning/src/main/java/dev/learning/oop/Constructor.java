package dev.learning.oop;

// Topic: Constructors in Java

/*
 * Types of Constructors:
 * 1. Default Constructor → no parameters, sets default values.
 * 2. Parameterized Constructor → accepts arguments to initialize object.
 * 3. Constructor Overloading → multiple constructors with different parameters.
 */

class Books {
    String title;
    String author;
    int year;

    // === 1. Default Constructor ===
    Books() {
        title = "Unknown";
        author = "Unknown";
        year = 0;
    }

    // === 2. Parameterized Constructor ===
    Books(String title, String author, int year) {
        this.title = title;   // "this" refers to current object's field
        this.author = author;
        this.year = year;
    }

    // === Method to display book info ===
    void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year);
    }
}

public class Constructor {

    public static void main(String[] args) {
        // === Using Default Constructor ===
        Books b1 = new Books(); // calls default constructor
        b1.displayInfo();     // prints default values

        // === Using Parameterized Constructor ===
        Books b2 = new Books("Effective Java", "Joshua Bloch", 2018);
        b2.displayInfo();

        // Another book
        Books b3 = new Books("Clean Code", "Robert C. Martin", 2008);
        b3.displayInfo();

        /*
         * Key Points:
         * - Constructor runs automatically when we use "new".
         * - Default constructor provides fallback values.
         * - Parameterized constructor allows flexible initialization.
         * - We can overload constructors with different parameter lists.
         */
    }
}

