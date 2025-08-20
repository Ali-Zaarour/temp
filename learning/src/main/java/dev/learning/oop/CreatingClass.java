package dev.learning.oop;

// Topic: How to create a class in Java
// This example shows how to define a class, its fields, methods, and how to use it in main.

/*
 * A class is a blueprint for creating objects.
 * - Fields (variables) describe the properties of the object.
 * - Methods (functions) describe the behaviors/actions of the object.
 * - A constructor initializes the object when created.
 */

class Cars{
    // === Fields (object properties) ===
    String brand;  // Brand of the car (e.g., Toyota, BMW)
    String color;  // Color of the car (e.g., Red, Blue)
    int year;      // Manufacturing year of the car

    // === Constructor (special method used to create objects) ===
    Cars(String brand, String color, int year) {
        // "this" refers to the current object
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    // === Method (behavior/action of the class) ===
    void startEngine() {
        System.out.println(brand + " engine is starting...");
    }

    void displayInfo() {
        System.out.println("Brand: " + brand + ", Color: " + color + ", Year: " + year);
    }
}

public class CreatingClass {

    public static void main(String[] args) {
        // === Object Creation ===
        // Create an instance of the Car class using the constructor
        Cars myCar = new Cars("Toyota", "Red", 2022);

        // === Method Calls ===
        // Call methods on the object
        myCar.startEngine();    // prints: Toyota engine is starting...
        myCar.displayInfo();    // prints details about the car
    }
}

