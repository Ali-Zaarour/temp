package dev.learning.oop;

/**
 * Demonstrates the benefits of Object-Oriented Programming (OOP) in Java.
 * <p>
 * Benefits covered:
 * 1. Modularity → Separate classes with clear responsibilities.
 * 2. Encapsulation → Hides internal data with private fields and public methods.
 * 3. Inheritance → Reuse code through class hierarchies.
 * 4. Polymorphism → Same method behaves differently for different objects.
 * 5. Abstraction → Focus on "what" not "how" (using abstract classes / interfaces).
 * 6. Scalability is Easy to extend (add new features without breaking old code).
 * 7. Real-world Model → Classes represent real-world entities (Car, ElectricCar, etc.).
 */

public class Benefits {

    public static void main(String[] args) {
        System.out.println("=== 1. Encapsulation & Modularity ===");
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        account.withdraw(30);
        System.out.println("Balance after transactions: $" + account.getBalance());

        System.out.println("\n=== 2. Inheritance & Polymorphism ===");
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Car();         // polymorphism
        Vehicle v3 = new ElectricCar(); // polymorphism
        v1.startEngine();
        v2.startEngine();
        v3.startEngine();

        System.out.println("\n=== 3. Abstraction ===");
        Shape s1 = new Circle(3);
        Shape s2 = new Square(4);
        System.out.println("Circle area: " + s1.area());
        System.out.println("Square area: " + s2.area());

        System.out.println("\n=== 4. Scalability & Real-world Modeling ===");
        // Adding new shapes or vehicles does NOT break old code:
        Shape s3 = new Circle(5); // new instance, same interface
        System.out.println("Another Circle area: " + s3.area());

        System.out.println("\n✅ OOP makes programs modular, secure, flexible, and scalable!");
    }
}

// ===== 1. Encapsulation & Modularity =====
class BankAccount {
    private double balance; // Encapsulation: private field

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public double getBalance() { // controlled access
        return balance;
    }
}

// ===== 2. Inheritance & Polymorphism =====
class Vehicle {
    public void startEngine() {
        System.out.println("The vehicle engine starts...");
    }
}

class Car extends Vehicle { // Inherits Vehicle
    @Override
    public void startEngine() { // Polymorphism: override
        System.out.println("Car engine roars to life!");
    }
}

class ElectricCar extends Vehicle { // Another subclass
    @Override
    public void startEngine() {
        System.out.println("Electric car powers up silently...");
    }
}

// ===== 3. Abstraction =====
abstract class Shape {
    abstract double area(); // Abstract: only defines "what", not "how"
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }
}

