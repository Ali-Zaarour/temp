package dev.learning.oop;

// Topic: Abstraction in Java

/*
 * Abstraction:
 * - Hides implementation details, only exposes essential behavior.
 * - Achieved via abstract classes or interfaces.
 * - Abstract class: can have abstract (unimplemented) methods and normal methods.
 *
 * Why?
 * - Forces subclasses to implement important behavior.
 * - Provides a common template for related classes.
 */

abstract class Shapes {

    // Abstract method (no body → must be implemented by subclasses)
    abstract double calculateArea();

    // Concrete (normal) method
    void display() {
        System.out.println("This is a shape.");
    }
}

// Subclass 1
class Circles extends Shapes {

    private double radius;

    Circles(double radius) {
        this.radius = radius;
    }

    // Implement abstract method
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass 2
class Rectangle extends Shapes {

    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Implement abstract method
    @Override
    double calculateArea() {
        return width * height;
    }
}

public class Abstraction {

    public static void main(String[] args) {

        // We cannot create an object of Shape directly (it's abstract)
        // Shape s = new Shape(); ERROR

        Shapes circle = new Circles(5);   // polymorphism in action
        Shapes rectangle = new Rectangle(4, 6);

        circle.display();
        System.out.println("Circle area: " + circle.calculateArea());

        rectangle.display();
        System.out.println("Rectangle area: " + rectangle.calculateArea());

        /*
         * Key points:
         * - Shape defines a template (abstract class).
         * - Circle & Rectangle provide their own implementations of calculateArea().
         * - We can work with Shape references without knowing details of each shape.
         */
    }
}
