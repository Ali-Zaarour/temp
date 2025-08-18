package dev.learning.part1;

// Demonstrates type casting in Java.

/*
 * Casting in Java:
 * ----------------
 * 1. Widening Casting (automatic, safe)
 *    byte → short → int → long → float → double
 *
 * 2. Narrowing Casting (explicit, possible data loss)
 *    double → float → long → int → char → short → byte
 *
 * Syntax:
 *   (targetType) value
 */

public class Casting {

    public static void main(String[] args) {
        // --------- Widening Casting (Implicit) ---------
        int intVal = 100;       // 32-bit
        long longVal = intVal;  // int → long (64-bit)
        double doubleVal = longVal; // long → double (decimal)

        System.out.println("Widening Casting:");
        System.out.println("int value = " + intVal);
        System.out.println("long value = " + longVal);
        System.out.println("double value = " + doubleVal);

        // --------- Narrowing Casting (Explicit) ---------
        double pi = 3.14159;
        int intPi = (int) pi; // double → int (fraction lost)
        byte bytePi = (byte) intPi; // int → byte (may overflow)

        System.out.println("\nNarrowing Casting:");
        System.out.println("double pi = " + pi);
        System.out.println("int pi (after cast) = " + intPi);
        System.out.println("byte pi (after cast) = " + bytePi);

        // --------- Overflow Example ---------
        int bigNumber = 130;
        byte smallNumber = (byte) bigNumber; // valid, but wraps around (-128 to 127)
        System.out.println("\nOverflow Example:");
        System.out.println("Original int = " + bigNumber);
        System.out.println("After casting to byte = " + smallNumber);

        // --------- Char Casting ---------
        int ascii = 65;
        char letter = (char) ascii; // 65 → 'A'
        System.out.println("\nChar Casting:");
        System.out.println("int ascii = " + ascii);
        System.out.println("char letter = " + letter);
    }
}
