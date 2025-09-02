package dev.learning.oop2;

// Topic: Method Overriding in Java

// What is Method Overriding?
// ---------------------------
// - When a subclass provides its own implementation of a method
//   that already exists in the parent class.
// - Happens at runtime (Runtime Polymorphism).
// - Requires: same method name, same parameter list, same return type (or covariant type).
// - Access level cannot be more restrictive in the child.
// - Annotate with @Override to catch mistakes at compile-time.

class Animal {
    // Parent method
    public void makeSound() {
        System.out.println("Some generic animal sound...");
    }

    public void sleep() {
        System.out.println("The animal is sleeping...");
    }
}

// Child class 1
class Dog extends Animal {
    @Override
    public void makeSound() { // override parent's method
        System.out.println("Dog barks: Woof Woof!");
    }
}

// Child class 2
class Cat extends Animal {
    @Override
    public void makeSound() { // override parent's method
        System.out.println("Cat meows: Meow Meow!");
    }
}

public class OverridingMethod {

    public static void main(String[] args) {
        System.out.println("=== Method Overriding Demo ===");

        // Parent reference, parent object
        Animal a1 = new Animal();
        a1.makeSound(); // Calls Animal version
        a1.sleep();

        System.out.println();

        // Parent reference, child object (Upcasting)
        Animal a2 = new Dog();
        a2.makeSound(); // Calls Dog version (runtime polymorphism)
        a2.sleep();     // Inherited, not overridden → calls an Animal version

        System.out.println();

        Animal a3 = new Cat();
        a3.makeSound(); // Calls Cat version
        a3.sleep();

        /*
         * Key Points:
         * - Overriding happens when a child redefines the parent's method.
         * - The method to run is chosen at RUNTIME based on the object type,
         *   not the reference type.
         * - This is the foundation of polymorphism in OOP.
         */
    }
}

