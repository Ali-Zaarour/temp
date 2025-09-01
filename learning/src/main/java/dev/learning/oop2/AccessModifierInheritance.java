package dev.learning.oop2;

// File: AccessModifierInheritanceDemo.java
// Topic: Access Modifiers and Inheritance
// Example: Vehicle -> Car -> Bus
//
// This example shows how private, default, protected, and public members
// behave in parent-child relationships across same and different packages.

/*
 * Access Modifier Recap:
 * ----------------------
 * private → Only inside the same class.
 * (default) → Visible in the same package, not outside.
 * Protected → Visible in subclasses (even in another package).
 * Public → Visible everywhere.
 */

// =========== PARENT CLASS ===========
class Vehicle {
    private String engineNumber = "ENG-999";  // private: only in Vehicle
    String brand = "Generic";        // default (package-private)
    protected int wheels = 4;                 // protected: visible in subclasses
    public int maxSpeed = 120;                // public: visible everywhere

    public void showVehicleInfo() {
        System.out.println("[Vehicle Info]");
        System.out.println("  engineNumber=" + engineNumber);
        System.out.println("  brand=" + brand);
        System.out.println("  wheels=" + wheels);
        System.out.println("  maxSpeed=" + maxSpeed);
    }
}

// =========== CHILD CLASS (same package) ===========
class Car extends Vehicle {
    private String model = "Sedan";

    public void showCarInfo() {
        System.out.println("[Car Info]");
        // System.out.println("  engineNumber=" + engineNumber); // private not visible
        System.out.println("  brand=" + brand);   // default visible in same package
        System.out.println("  wheels=" + wheels); // protected visible via inheritance
        System.out.println("  maxSpeed=" + maxSpeed); // public always visible
        System.out.println("  model=" + model);
    }
}

// =========== CHILD CLASS (simulate different package) ===========
/*
 * Imagine Bus is in a different package like:
 *   package transport;
 *   import package.Vehicle;
 *
 * Here we simulate it in the same file for simplicity,
 * but treat it as if it were in another package.
 */
class Bus extends Vehicle {
    private int capacity = 50;

    public void showBusInfo() {
        System.out.println("[Bus Info]");
        // System.out.println("  brand=" + brand);   // default not visible outside package
        System.out.println("  wheels=" + wheels);   // protected visible in subclass
        System.out.println("  maxSpeed=" + maxSpeed); // public always visible
        System.out.println("  capacity=" + capacity);
    }
}

public class AccessModifierInheritance {

    public static void main(String[] args) {
        System.out.println("=== Vehicle ===");
        Vehicle v = new Vehicle();
        v.showVehicleInfo();

        System.out.println("\n=== Car (same package child) ===");
        Car c = new Car();
        c.showCarInfo();

        System.out.println("\n=== Bus (different package child simulation) ===");
        Bus b = new Bus();
        b.showBusInfo();
    }
}
