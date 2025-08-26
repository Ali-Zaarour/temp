package dev.learning.oop2;

// Topic: Basic Inheritance in Java
// This file explains the core concepts of inheritance with a runnable demo.
//
// WHAT YOU'LL SEE:
// 1) "extends" to create a child class from a parent class (IS-A relationship)
// 2) "super(...)" to chain to the parent constructor
// 3) "super.someMethod()" to call the parent method implementation
// 4) Method overriding (child changes behavior of a parent method)
// 5) Upcasting (Parent ref = new Child(...)) + dynamic dispatch at runtime
// 6) "instanceof" checks
//
// NOTE ON ACCESS:
// - private members are NOT directly visible to subclasses (use protected or getters).
// - protected members are visible in subclasses (and package).
// - Public members are visible everywhere.
//
// REAL-WORLD MAPPING:
// Person -> base type (has a name)
// Employee extends Person -> adds employeeId and salary
// Manager extends Employee -> adds teamSize and overrides describe()

// ========================= PARENT CLASS =========================
class Person {

    // Use protected so subclasses can see it (private would hide it)
    protected String name;

    // Parent constructor
    public Person(String name) {
        this.name = name;
    }

    // Method that children can inherit/override
    public String describe() {
        return "Person[name=" + name + "]";
    }
}

// ========================= CHILD CLASS 1 =========================
class Employee extends Person {

    private String employeeId;   // private: not directly visible to grandchildren
    protected double salary;     // protected: visible to Manager

    // Child constructor MUST call a parent constructor (first statement)
    public Employee(String name, String employeeId, double salary) {
        super(name); // calls Person(String)
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Override a parent method to add more details
    @Override
    public String describe() {
        // We can reuse the parent's text via super.describe()
        return super.describe() + " -> Employee[id=" + employeeId + ", salary=" + salary + "]";
    }
}

// ========================= CHILD CLASS 2 =========================
class Manager extends Employee {

    private int teamSize;

    // Constructor chaining: Manager -> Employee -> Person
    public Manager(String name, String employeeId, double salary, int teamSize) {
        super(name, employeeId, salary); // must be the first call
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int n) {
        this.teamSize = n;
    }

    // Override again to provide Manager-specific description
    @Override
    public String describe() {
        // Optionally include the parent (Employee) description using super
        return super.describe() + " -> Manager[teamSize=" + teamSize + "]";
    }

    // Manager-specific behavior
    public void approveBudget(double amount) {
        System.out.println("Manager " + name + " approved budget: $" + amount);
    }
}

// ========================= DEMO (main) =========================
public class InheritanceBasics {

    public static void main(String[] args) {
        // 1) Constructing objects (note the constructor chain calls)
        Person p = new Person("Layla");
        Employee e = new Employee("Omar", "EMP-1001", 2200.0);
        Manager m = new Manager("Nadia", "EMP-2001", 3500.0, 8);

        // 2) Basic calls: each class has/overrides describe()
        System.out.println("Person   : " + p.describe());
        System.out.println("Employee : " + e.describe()); // overridden vs Person
        System.out.println("Manager  : " + m.describe()); // overridden vs Employee

        // 3) Upcasting: Parent reference = Child object
        Person p2 = new Manager("Karim", "EMP-3001", 4200.0, 12);
        // Even though p2 is typed as Person, at runtime it points to a Manager
        // Dynamic dispatch calls the most overridden version available
        System.out.println("Upcasted Person->Manager describe(): " + p2.describe());

        // 4) instanceof: check actual runtime type
        System.out.println("p2 instanceof Person  ? " + (p2 instanceof Person));   // true
        System.out.println("p2 instanceof Employee? " + (p2 instanceof Employee)); // true
        System.out.println("p2 instanceof Manager ? " + (p2 instanceof Manager));  // true

        // 5) Down casting (with care): we know p2 is actually a Manager
        if (p2 instanceof Manager) {
            Manager p2AsManager = (Manager) p2;      // safe downcast
            p2AsManager.approveBudget(5000.0);       // Manager-specific method
        }

        // 6) Access control reminder:
        // - name is protected in Person → accessible in subclasses (used in Manager.approveBudget()).
        // - employeeId is private in Employee → not accessible in Manager directly; use getters if needed.

        // 7) IS-A vs. HAS-A:
        //    Manager IS-A Employee (inheritance)
        //    Employee IS-A Person (inheritance)
        //    If we wanted composition (HAS-A), e.g., Employee HAS-A Address, we would add an Address field.

        // 8) Why inheritance?
        //    - Code reuse (Manager gets Employee+Person features)
        //    - Polymorphism (Person ref can hold Employee/Manager objects)
        //    - Clear hierarchy of specialization
    }
}
