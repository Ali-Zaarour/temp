package dev.learning.part1;

// Demonstrates reading different types of input from the user in Java.

/*
 * Ways to read input in Java:
 * ---------------------------
 * 1. Scanner (most common for beginners, simple to use)
 * 2. BufferedReader (faster, but more complex, good for large input)
 * 3. Console (useful for passwords, interactive input)
 *
 * In this example, we use Scanner.
 */

import java.util.Scanner;

public class ReadingInput {

    public static void main(String[] args) {
        // Create a Scanner object linked to standard input (keyboard)
        Scanner scanner = new Scanner(System.in);

        // Reading a string
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // reads full line (with spaces)
        System.out.println("Hello, " + name + "!");

        // Reading an integer
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // reads an int
        System.out.println("You are " + age + " years old.");

        // Reading a double
        System.out.print("Enter your height (in meters): ");
        double height = scanner.nextDouble(); // reads a double
        System.out.println("Your height: " + height + " meters.");

        // Reading a single word (no spaces)
        System.out.print("Enter your favorite color (one word): ");
        String color = scanner.next(); // reads next token (until space)
        System.out.println("Favorite color: " + color);

        // Always close the scanner when done (best practice)
        scanner.close();
    }
}
