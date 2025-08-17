package dev.learning.part1;

// Demonstrates escape sequences in Java Strings.

/*
 * Escape Sequences in Java:
 * --------------------------
 * - \n  : new line
 * - \t  : tab space
 * - \"  : double quote
 * - \'  : single quote
 * - \\  : backslash
 * - \r  : carriage return
 * - \b  : backspace (removes previous char in output)
 *
 * Used inside strings to represent characters
 * that cannot be typed directly.
 */

public class EscapeSequence {

    public static void main(String[] args) {
        // New line
        System.out.println("Hello\nWorld");

        // Tab
        System.out.println("Column1\tColumn2\tColumn3");

        // Quotes inside string
        System.out.println("She said: \"Java is awesome!\"");
        System.out.println("It\'s a sunny day!");

        // Backslash
        System.out.println("This is a backslash: \\");

        // Carriage return (overwrites from start of line)
        System.out.println("12345\rABCDE");

        // Backspace (deletes previous character in output)
        System.out.println("Hello\b World");
    }
}
