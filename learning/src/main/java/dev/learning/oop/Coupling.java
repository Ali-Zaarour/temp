package dev.learning.oop;

// Topic: Coupling in Java

/*
 * Coupling:
 * - The degree of dependency between classes.
 *
 * Types:
 * 1. Tight Coupling → Class is directly dependent on another specific class.
 * 2. Loose Coupling → Class depends on an abstraction (interface/abstract class),
 *                     not a concrete class.
 *
 * Best Practice: Aim for loose coupling → increases flexibility, easier to test and maintain.
 */

// === Example 1: Tight Coupling ===
class PetrolEngine {

    void start() {
        System.out.println("Petrol engine starting...");
    }
}

class CarTight {

    private PetrolEngine engine = new PetrolEngine(); // Direct dependency

    void drive() {
        engine.start();
        System.out.println("Car is driving (tight coupling).");
    }
}

// === Example 2: Loose Coupling (using Interface) ===
interface Engine {

    void start();
}

class DieselEngine implements Engine {

    public void start() {
        System.out.println("Diesel engine starting...");
    }
}

class ElectricEngine implements Engine {

    public void start() {
        System.out.println("Electric engine starting silently...");
    }
}

class CarLoose {

    private Engine engine; // Depends on abstraction, not a specific engine

    CarLoose(Engine engine) {
        this.engine = engine;
    }

    void drive() {
        engine.start();
        System.out.println("Car is driving (loose coupling).");
    }
}

public class Coupling {

    public static void main(String[] args) {

        // === Tight Coupling ===
        CarTight car1 = new CarTight();
        car1.drive();

        System.out.println("----------------");

        // === Loose Coupling ===
        CarLoose dieselCar = new CarLoose(new DieselEngine());
        dieselCar.drive();

        CarLoose electricCar = new CarLoose(new ElectricEngine());
        electricCar.drive();

        /*
         * Key Points:
         * - CarTight → tied only to PetrolEngine. If we want another engine,
         *   we must rewrite the CarTight class.
         *
         * - CarLoose → can work with ANY engine that implements Engine interface
         *   (Diesel, Electric, Hybrid, etc.). Much more flexible.
         */
    }
}

