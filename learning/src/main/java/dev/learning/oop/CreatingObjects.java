package dev.learning.oop;

// Topic: How to create objects in Java
/*
 * A class is a blueprint.
 * An object is an instance of that class.
 * We use the "new" keyword to create objects.
 */

class Student {
    // === Fields (properties) ===
    String name;
    int age;
    double grade;

    // === Constructor ===
    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // === Method (behavior) ===
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}

public class CreatingObjects {

    public static void main(String[] args) {
        // === Creating Objects ===
        // Each "new Student(...)" creates a unique student object

        Student s1 = new Student("Alice", 20, 88.5);   // First student
        Student s2 = new Student("Bob", 22, 91.0);     // Second student
        Student s3 = new Student("Charlie", 19, 76.3); // Third student

        // === Using the objects ===
        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();

        /*
         * Note:
         * - Each object stores its own data.
         * - s1, s2, s3 are separate objects, each representing a student.
         */
    }
}
