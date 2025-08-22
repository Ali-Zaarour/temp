package dev.learning.oop;

// Topic: Getters and Setters in Java

/*
 * Getters and Setters:
 * - Getter → method that returns (reads) the value of a private field.
 * - Setter → method that updates (writes) the value of a private field.
 *
 * Why use them?
 * - Protects data (fields are private).
 * - Provides controlled access.
 * - Allows validation before updating values.
 */

class Students {

    // === Private fields (cannot be accessed directly from outside) ===
    private String name;
    private int age;

    // === Constructor ===
    Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // === Getter for name ===
    public String getName() {
        return name;
    }

    // === Setter for name ===
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }

    // === Getter for age ===
    public int getAge() {
        return age;
    }

    // === Setter for age ===
    public void setAge(int age) {
        if (age > 0) { // Validation to avoid negative ages
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }
}

public class GetterSetter {

    public static void main(String[] args) {

        // === Create Student object ===
        Students s1 = new Students("Alice", 20);

        // Access values using getters
        System.out.println("Name: " + s1.getName());
        System.out.println("Age: " + s1.getAge());

        // Update values using setters
        s1.setName("Bob"); // Valid update
        s1.setAge(25);     // Valid update

        // Invalid updates (triggers validation)
        s1.setName("");    // Invalid
        s1.setAge(-5);     // Invalid

        // Display updated info
        System.out.println("Updated Name: " + s1.getName());
        System.out.println("Updated Age: " + s1.getAge());
    }
}

