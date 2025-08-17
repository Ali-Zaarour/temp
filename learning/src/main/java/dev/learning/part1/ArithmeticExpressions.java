package dev.learning.part1;

// Demonstrates arithmetic expressions in Java.

/*
 * Arithmetic Operators in Java:
 * ------------------------------
 * +  : addition
 * -  : subtraction
 * *  : multiplication
 * /  : division
 * %  : modulus (remainder)
 *
 * Operator Precedence (order of evaluation):
 * 1. Parentheses ()
 * 2. Unary operators (+, -, ++, --)
 * 3. Multiplication (*), Division (/), Modulus (%)
 * 4. Addition (+), Subtraction (-)
 * 5. Left to right evaluation if same precedence
 */

public class ArithmeticExpressions {

    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        // Basic operations
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3 (integer division)
        System.out.println("a % b = " + (a % b)); // 1 (remainder)

        // Using double for division
        double x = 10;
        double y = 3;
        System.out.println("x / y = " + (x / y)); // 3.333...

        // Expression with precedence
        int result = a + b * 2; // b*2 evaluated first, then added to a
        System.out.println("a + b * 2 = " + result);

        // Using parentheses to change precedence
        int result2 = (a + b) * 2;
        System.out.println("(a + b) * 2 = " + result2);

        // Increment & Decrement
        int num = 5;
        System.out.println("\nInitial num = " + num);
        System.out.println("num++ = " + (num++)); // post-increment (uses value, then adds 1)
        System.out.println("After num++: " + num);
        System.out.println("++num = " + (++num)); // pre-increment (adds 1, then uses value)

        // Compound assignment
        int z = 10;
        z += 5; // z = z + 5
        System.out.println("\nCompound assignment (z += 5): " + z);
    }
}
