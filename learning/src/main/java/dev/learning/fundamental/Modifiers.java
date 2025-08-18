package dev.learning.fundamental;

// Demonstrates different modifiers in Java.

/*
 * Categories of Modifiers:
 * ========================
 *
 * 1. Access Modifiers (control visibility):
 *    - public    → accessible everywhere
 *    - private   → accessible only inside the class
 *    - protected → accessible in the same package + subclasses
 *    - (default) → accessible only in the same package (no keyword)
 *
 * 2. Non-Access Modifiers (provide special properties):
 *    - static    → belongs to class, not objects
 *    - final     → cannot be changed (constant, or prevent overriding/extension)
 *    - abstract  → must be implemented by subclasses (in classes/methods)
 *    - synchronized → used in multi-threading to lock methods/blocks
 *    - transient → variable not saved during serialization
 *    - volatile  → variable updated immediately across threads
 *    - strictfp  → ensures floating-point consistency across platforms
 */

public class Modifiers {

    // 1. Access modifiers
    public String publicVar = "I am public";        // visible everywhere
    private String privateVar = "I am private";     // visible only in this class
    protected String protectedVar = "I am protected"; // visible in package + subclasses
    String defaultVar = "I am default";             // visible in the same package

    // 2. Non-access modifiers
    static final double PI = 3.14159; // static + final = constant shared by all objects

    public static void main(String[] args) {
        Modifiers obj = new Modifiers();

        // Accessing different variables
        System.out.println(obj.publicVar);
        System.out.println(obj.privateVar);
        System.out.println(obj.protectedVar);
        System.out.println(obj.defaultVar);

        // Accessing constant
        System.out.println("PI = " + PI);
    }
}

// 3. final class (cannot be extended)
final class FinalClass {
    public void display() {
        System.out.println("I am a final class. No subclass allowed.");
    }
}

// 4. abstract class (cannot be instantiated directly)
abstract class AbstractShape {
    abstract void draw(); // abstract method (must be implemented in subclasses)
}

// Subclass implementing abstract method
class Circle extends AbstractShape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle...");
    }
}
