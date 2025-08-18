package dev.learning.fundamental;

// Demonstrates usage of the Math class in Java.

/*
 * Math Class in Java:
 * -------------------
 * - Belongs to java.lang package (no import needed).
 * - Provides constants (Math.PI, Math.E).
 * - Provides static methods for common math operations:
 *   - Absolute value      : Math.abs(x)
 *   - Power               : Math.pow(a, b)
 *   - Square root         : Math.sqrt(x)
 *   - Max / Min           : Math.max(a, b), Math.min(a, b)
 *   - Rounding            : Math.round(x), Math.ceil(x), Math.floor(x)
 *   - Random number       : Math.random()  (0.0 ≤ x < 1.0)
 */

public class MathClass {

    public static void main(String[] args) {
        // Constants
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E = " + Math.E);

        // Absolute value
        int neg = -10;
        System.out.println("\nAbsolute value of -10 = " + Math.abs(neg));

        // Power and Square root
        System.out.println("2^3 = " + Math.pow(2, 3));   // 8.0
        System.out.println("Square root of 16 = " + Math.sqrt(16)); // 4.0

        // Max and Min
        System.out.println("Max of (5, 10) = " + Math.max(5, 10));
        System.out.println("Min of (5, 10) = " + Math.min(5, 10));

        // Rounding
        double num = 7.56;
        System.out.println("\nMath.round(7.56) = " + Math.round(num)); // 8
        System.out.println("Math.ceil(7.56) = " + Math.ceil(num));   // 8.0
        System.out.println("Math.floor(7.56) = " + Math.floor(num)); // 7.0

        // Trigonometry (radians)
        double angle = Math.toRadians(45); // convert degrees → radians
        System.out.println("\nSin(45°) = " + Math.sin(angle));
        System.out.println("Cos(45°) = " + Math.cos(angle));
        System.out.println("Tan(45°) = " + Math.tan(angle));

        // Random number
        double random = Math.random(); // 0.0 ≤ random < 1.0
        System.out.println("\nRandom number [0,1): " + random);

        // Random number in range (e.g., 1–6 for dice)
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Random dice roll (1–6): " + dice);
    }
}
