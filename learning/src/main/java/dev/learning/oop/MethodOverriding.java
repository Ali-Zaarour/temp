package dev.learning.oop;

// Topic: Method Overriding in Java

/*
 * Method Overriding:
 * - Subclass redefines a method from its superclass.
 * - Runtime polymorphism: JVM decides which version to call at runtime.
 * - Allows different behaviors for the same method call.
 */

class Animal {
    // Method to be overridden
    void sound() {
        System.out.println("The animal makes a sound");
    }
}

// Subclass 1
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("The dog barks: Woof Woof!");
    }
}

// Subclass 2
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("The cat meows: Meow Meow!");
    }
}

public class MethodOverriding {

    public static void main(String[] args) {
        // === Parent reference, child objects (runtime polymorphism) ===
        Animal a1 = new Animal();
        Animal a2 = new Dog();
        Animal a3 = new Cat();

        // Calls are resolved at runtime, not compile-time
        a1.sound(); // Animal version
        a2.sound(); // Dog version
        a3.sound(); // Cat version

        /*
         * Key Points:
         * - Method overriding enables polymorphism.
         * - Same "sound()" method behaves differently depending on the object type.
         * - In real projects: e.g., UI frameworks, payment systems, etc.
         */
    }
}

