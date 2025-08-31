package dev.learning.oop2;

// Topic: Constructors and Inheritance in Java

// DEMONSTRATES:
// 1) Constructor chaining (super(...))
// 2) Order of execution (top-down)
// 3) Explicit vs. implicit constructor calls

public class ConstructorInheritance {

    public static void main(String[] args) {
        System.out.println("=== Creating Person with default constructor ===");
        Person p1 = new Person();

        System.out.println("\n=== Creating Person with parameterized constructor ===");
        Person p2 = new Person("Layla");

        System.out.println("\n=== Creating Employee with default constructor ===");
        Employee e1 = new Employee();

        System.out.println("\n=== Creating Employee with parameterized constructor ===");
        Employee e2 = new Employee("Omar", "EMP-1001");

        System.out.println("\n=== Creating Manager with default constructor ===");
        Manager m1 = new Manager();

        System.out.println("\n=== Creating Manager with parameterized constructor ===");
        Manager m2 = new Manager("Nadia", "EMP-2001", 5);
    }

    static class Person {

        protected String name;

        // Default constructor
        public Person() {
            System.out.println("Person() constructor called (default).");
            this.name = "Unknown";
        }

        // Parameterized constructor
        public Person(String name) {
            System.out.println("Person(String) constructor called.");
            this.name = name;
        }
    }

    static class Employee extends Person {

        protected String employeeId;

        // Default constructor
        public Employee() {
            // Implicitly calls super() if not written
            // But here we explicitly call it:
            super(); // calls Person()
            System.out.println("Employee() constructor called (default).");
            this.employeeId = "N/A";
        }

        // Parameterized constructor
        public Employee(String name, String employeeId) {
            super(name); // calls Person(String)
            System.out.println("Employee(String, String) constructor called.");
            this.employeeId = employeeId;
        }
    }

    static class Manager extends Employee {

        private int teamSize;

        // Default constructor
        public Manager() {
            // If omitted, compiler inserts super()
            super(); // calls Employee()
            System.out.println("Manager() constructor called (default).");
            this.teamSize = 0;
        }

        // Parameterized constructor
        public Manager(String name, String employeeId, int teamSize) {
            super(name, employeeId); // goes to Employee(String, String)
            System.out.println("Manager(String, String, int) constructor called.");
            this.teamSize = teamSize;
        }
    }
}

