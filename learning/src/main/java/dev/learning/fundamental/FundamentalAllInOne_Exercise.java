package dev.learning.fundamental;

// Purpose: Practice core Java fundamentals in ONE program.
// How to use: Read the tasks, follow the HINTS, and implement each TODO.
// Topics: variables, primitives, strings, arrays (1D/2D), constants, casting,
// math class, number formatting, input, comparison & logical operators,
// if/else, ternary, switch, loops (for/while/do-while/for-each), break/continue,
// methods, modifiers.
//
// Recommended order: Do sections 1 → 10 in order.

// ======= Imports you will likely need (read inputs & format numbers) =======

public class FundamentalAllInOne_Exercise {

    // ======= Section 9 uses methods; implement these (see TODOs & hints) =======
    // TODO(9.a): Implement a static method int sumArray(int[] arr)
    // HINT: Use an enhanced for (for-each) loop to accumulate.
    // public static int sumArray(int[] arr) { /* your code */ }

    // TODO(9.b): Implement a static method double average(int[] arr)
    // HINT: Reuse sumArray(arr) and cast to double for precise division.
    // public static double average(int[] arr) { /* your code */ }

    public static void main(String[] args) {
        // ===== Section 1: Variables & Primitive Types =====
        // TODO(1): Declare primitives: int age, double height, boolean student, char initial.
        //          Assign reasonable demo values and print them in a single line:
        //          Example: "Age=..., Height=..., Student=..., Initial=..."
        // HINT: Use string concatenation with + .


        // ===== Section 2: Strings & Escape Sequences =====
        // TODO(2.a): Create a String fullName with your name ("First Last").
        // TODO(2.b): Print "Hello, <NAME_IN_UPPERCASE>!" using String.toUpperCase().
        // TODO(2.c): Print a small table using \t and \n with headers: ID, Name, Score (2 rows).
        // HINT: Example header -> "ID\tName\tScore\n"


        // ===== Section 3: Constants & Math & Casting =====
        // TODO(3.a): Declare static final double PI = 3.141592653589793 (inside main is fine for now).
        // TODO(3.b): Given double radius = 5.0, compute circle area and circumference.
        // HINT: area = PI * r * r, circ = 2 * PI * r
        // TODO(3.c): Print sqrt(16), pow(2,8), and a random dice roll (1..6) using Math class.
        // TODO(3.d): Show casting by computing 7/2 as double using (double)a / b.


        // ===== Section 4: Number Formatting =====
        // TODO(4): Format a subtotal=1234.5 with taxRate=0.11.
        //          Print subtotal, tax (as currency), and taxRate as percentage.
        // HINT: NumberFormat.getCurrencyInstance(Locale.US), getPercentInstance().


        // ===== Section 5: Arrays 1D & 2D =====
        // TODO(5.a): Create int[] scores = {90, 75, 82, 100, 67}.
        // TODO(5.b): Print length, first, last; then loop to print all values on one line.
        // TODO(5.c): Create a 3x3 matrix int[][] m = {{1,2,3},{4,5,6},{7,8,9}} and
        //            print the sum of main diagonal (m[i][i]) and secondary diagonal (m[i][n-1-i]).
        // HINT: Use for loops; n = m.length.


        // ===== Section 6: Input (Scanner) & Validation =====
        // TODO(6.a): Ask the user for name (line), age (int), and height (double).
        // TODO(6.b): If age < 0 → print error and skip the rest of section 6; else print a summary line.
        // NOTE: Close the scanner at the very end of main (after all sections that need it).
        // Scanner sc = new Scanner(System.in);


        // ===== Section 7: Comparison, Logical, If/Else, Ternary =====
        // TODO(7.a): Using your earlier age and a boolean 'student', print:
        //            "Adult student? <true/false>" for (age >= 18 && student).
        // TODO(7.b): Using a char grade ('A','B','C','D','F'), print a message:
        //            'A' -> "Excellent", 'B' -> "Good", others -> "Keep improving" (use if/else or ternary).


        // ===== Section 8: Switch =====
        // TODO(8): Given int month (1..12), use switch expression (Java 14+) to set String season:
        //          12,1,2 -> "Winter"; 3,4,5 -> "Spring"; 6,7,8 -> "Summer"; 9,10,11 -> "Autumn"; default -> "Invalid".
        // HINT: String season = switch(month) { case 12,1,2 -> "Winter"; ... default -> "Invalid"; };


        // ===== Section 9: Methods (sum & average) =====
        // TODO(9): Call sumArray(scores) and average(scores) and print:
        //          "Sum=<...>, Avg=<...>"


        // ===== Section 10: Loops + break/continue =====
        // TODO(10.a): for loop: print numbers 1..20; skip multiples of 3 (continue); stop entirely at 17 (break).
        // TODO(10.b): while loop: count down from 5 to 1, then print "Done!".
        // TODO(10.c): do-while loop: simple menu: 1)Say Hi 2)Say Bye 3)Exit. Repeat until 3.
        // HINT: Use switch for menu actions. Read int choice with Scanner.


        // ===== Final clean-up =====
        // sc.close();
    }
}
