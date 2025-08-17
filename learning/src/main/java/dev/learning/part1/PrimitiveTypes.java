package dev.learning.part1;

// This class demonstrates all 8 primitive data types in Java.

/*
 * In Java, primitive types are the most basic data types.
 * They are not objects and store simple values directly in memory.
 *
 * Java has 8 primitive types:
 *
 * 1. byte (8-bit, -128 to 127)
 * 2. Short (16-bit, -32,768 to 32,767)
 * 3. Int (32-bit, ~ -2 billion to +2 billion)
 * 4. Long (64-bit, very large numbers)
 * 5. Float (32-bit, decimal numbers with ~7 digits precision)
 * 6. Double (64-bit, decimal numbers with ~15 digits precision)
 * 7. Char (16-bit Unicode character, e.g. 'A', '9', '#')
 * 8. boolean (true / false)
 *
 * Note: 'String' is NOT primitive (it is an object).
 */

public class PrimitiveTypes {

    public static void main(String[] args) {
        // 1. byte: small integers
        byte b = 100;
        System.out.println("byte value: " + b);

        // 2. short: larger than byte
        short s = 30000;
        System.out.println("short value: " + s);

        // 3. int: most commonly used integer type
        int i = 100000;
        System.out.println("int value: " + i);

        // 4. long: used for very large numbers, add 'L' at the end
        long l = 10000000000L;
        System.out.println("long value: " + l);

        // 5. float: decimal number, must end with 'f' or 'F'
        float f = 3.14f;
        System.out.println("float value: " + f);

        // 6. double: default type for decimals, more precise than float
        double d = 3.14159265358979;
        System.out.println("double value: " + d);

        // 7. char: stores a single character, in single quotes
        char c = 'A';
        System.out.println("char value: " + c);

        // 8. boolean: true or false
        boolean bool = true;
        System.out.println("boolean value: " + bool);

        // Example of combining primitive values
        int sum = i + b; // int + byte → int result
        System.out.println("Sum of int + byte = " + sum);
    }
}
