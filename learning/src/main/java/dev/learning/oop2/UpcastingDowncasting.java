package dev.learning.oop2;

// Topic: Upcasting and Downcasting in Java


// Upcasting: Child -> Parent (safe, implicit).
// Downcasting: Parent -> Child (explicit, may fail if object is not that type).

class Shape {
    public void draw() {
        System.out.println("Drawing a generic shape...");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle!");
    }

    public void circleSpecificMethod() {
        System.out.println("Circle-specific behavior: calculating radius...");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle!");
    }

    public void rectangleSpecificMethod() {
        System.out.println("Rectangle-specific behavior: calculating area...");
    }
}

public class UpcastingDowncasting {

    public static void main(String[] args) {
        System.out.println("=== Upcasting ===");

        // Upcasting: Circle object → Shape reference
        Shape s1 = new Circle();   // implicit upcast
        Shape s2 = new Rectangle();// implicit upcast

        s1.draw(); // Calls Circle's overridden version
        s2.draw(); // Calls Rectangle's overridden version

        // But s1 and s2 cannot directly call circleSpecificMethod() or rectangleSpecificMethod()

        System.out.println("\n=== Downcasting ===");

        // Downcast back to Circle
        if (s1 instanceof Circle) {
            Circle c1 = (Circle) s1; // explicit downcast
            c1.circleSpecificMethod();
        }

        // Downcast back to Rectangle
        if (s2 instanceof Rectangle) {
            Rectangle r1 = (Rectangle) s2;
            r1.rectangleSpecificMethod();
        }

        System.out.println("\n=== Unsafe Downcasting Example ===");
        Shape s3 = new Circle();

        // This would compile but fail at runtime:
        // Rectangle wrongCast = (Rectangle) s3; // ClassCastException
        // wrongCast.rectangleSpecificMethod();

        // Always check before downcasting:
        if (s3 instanceof Rectangle) {
            Rectangle safeCast = (Rectangle) s3;
            safeCast.rectangleSpecificMethod();
        } else {
            System.out.println("s3 is NOT a Rectangle, cannot downcast safely.");
        }

        /*
         * Key Points:
         * - Upcasting is implicit and safe.
         * - Downcasting is explicit and may cause ClassCastException.
         * - Use instanceof to check before downcasting.
         * - Polymorphism: Upcast allows us to use parent references for child objects.
         */
    }
}
