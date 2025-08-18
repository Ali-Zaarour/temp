package dev.learning.fundamental;

// Demonstrates the CORRECT operator precedence and associativity in Java,
// with small runnable examples for each major level.

/*
 * Operator Precedence in Java (highest → lowest)
 * ==============================================
 *  1) Postfix           : expr++  expr--
 *     Associativity     : left → right (but the operation is applied after the value is used)
 *
 *  2) Unary             : ++expr  --expr  +expr  -expr  ~  !
 *     Associativity     : right → left
 *
 *  3) Multiplicative    : *  /  %
 *     Associativity     : left → right
 *
 *  4) Additive          : +  -
 *     Associativity     : left → right
 *
 *  5) Shift             : <<  >>  >>>
 *     Associativity     : left → right
 *
 *  6) Relational        : <  >  <=  >=  instanceof
 *     Associativity     : left → right
 *
 *  7) Equality          : ==  !=
 *     Associativity     : left → right
 *
 *  8) Bitwise AND       : &
 *     Associativity     : left → right
 *
 *  9) Bitwise XOR       : ^
 *     Associativity     : left → right
 *
 * 10) Bitwise OR        : |
 *     Associativity     : left → right
 *
 * 11) Logical AND       : &&
 *     Associativity     : left → right (short-circuit)
 *
 * 12) Logical OR        : ||
 *     Associativity     : left → right (short-circuit)
 *
 * 13) Ternary           : ? :
 *     Associativity     : right → left
 *
 * 14) Assignment        : =  +=  -=  *=  /=  %=  &=  ^=  |=  <<=  >>=  >>>=
 *     Associativity     : right → left
 *
 * Notes:
 * - Parentheses () always override precedence.
 * - For operators with the same precedence, use the associativity rule above.
 * - && and || short-circuit: if the result is decided by the left side, the right side is not evaluated.
 */

public class OrderOfOperations {

    public static void main(String[] args) {
        int a = 10, b = 5, c = 2;

        // 1) Postfix vs Prefix
        int x = 5;
        System.out.println("Postfix x++ (prints old value): " + (x++)); // prints 5, x becomes 6
        System.out.println("After x++ x is: " + x);                     // 6
        System.out.println("Prefix ++x (increments then prints): " + (++x)); // x becomes 7, prints 7

        // 2) Unary (+, -, ~, !)
        int u = 3;
        System.out.println("\nUnary -u: " + (-u));       // -3
        System.out.println("Bitwise ~u: " + (~u));       // ~3 = -4 (two's complement)
        boolean flag = false;
        System.out.println("Logical !flag: " + (!flag)); // true

        // 3) Multiplicative *, /, %
        System.out.println("\nMultiplicative: a*b = " + (a * b)); // 50
        System.out.println("a/b (int div) = " + (a / b));         // 2
        System.out.println("a%b = " + (a % b));                   // 0

        // 4) Additive +, -
        System.out.println("\nAdditive: a + b * c = " + (a + b * c)); // 10 + (5*2)=20
        System.out.println("(a + b) * c = " + ((a + b) * c));         // (10+5)*2=30

        // 5) Shift <<, >>, >>>
        int sh = 1;
        System.out.println("\nShift: 1 << 3 = " + (sh << 3)); // 8
        int neg = -8;
        System.out.println("-8 >> 1 (arith shift) = " + (neg >> 1));   // -4
        System.out.println("-8 >>> 1 (logical shift) = " + (neg >>> 1)); // large positive, depends on JVM word size (prints 2147483644 on 32-bit int)

        // 6) Relational <, >, <=, >=, instanceof
        System.out.println("\nRelational: a > b ? " + (a > b));       // true
        System.out.println("a <= b ? " + (a <= b));                   // false
        String s = "hi";
        System.out.println("s instanceof String ? " + (s instanceof String)); // true

        // 7) Equality ==, !=
        System.out.println("\nEquality: a == 10 ? " + (a == 10)); // true
        System.out.println("b != 5 ? " + (b != 5));               // false

        // 8–10) Bitwise AND, XOR, OR: &, ^, |
        int m = 0b1010; // 10
        int n = 0b0110; // 6
        System.out.println("\nBitwise AND (1010 & 0110) = " + (m & n)); // 0b0010 = 2
        System.out.println("Bitwise XOR (1010 ^ 0110) = " + (m ^ n));   // 0b1100 = 12
        System.out.println("Bitwise  OR (1010 | 0110) = " + (m | n));   // 0b1110 = 14

        // 11–12) Logical AND && and OR || (with short-circuit)
        int p = 0;
        boolean logical = (a > b) && (b > c) || (p != 0 && (10 / p > 0));
        // Evaluates: (true && true) || (p!=0 && ...). Left is true, so right side of || is short-circuited (safe).
        System.out.println("\nLogical &&, || short-circuit result: " + logical); // true

        // 13) Ternary ? :
        String size = (a > 9) ? "large" : "small";
        System.out.println("\nTernary (a>9 ? \"large\":\"small\") = " + size); // "large"

        // 14) Assignment right-to-left
        int r1, r2, r3;
        r1 = r2 = r3 = 100; // r3=100 → r2=100 → r1=100
        System.out.println("\nAssignments: r1=" + r1 + ", r2=" + r2 + ", r3=" + r3);

        // Combined precedence example
        boolean combo = a + b * c > 20 && (a == 10 || b < 0);
        // Steps:
        //  b*c = 10
        //  a + (b*c) = 20
        //  20 > 20  -> false
        //  (a == 10) -> true, (b < 0) -> false, so (true || false) -> true
        //  false && true -> false
        System.out.println("\nCombined example result: " + combo); // false
    }
}
