package dev.learning.oop2;

// Topic: The java.lang.Object class
// Example shows how all classes inherit from Object
// and demonstrates overriding toString(), equals(), and hashCode().

/*
 * Key Points:
 * - Every class in Java extends Object (directly or indirectly).
 * - So methods like toString(), equals(), and hashCode() are available everywhere.
 * - Often we override them to give meaningful behavior.
 */

class Product {

    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Override toString() to provide a friendly string representation
    @Override
    public String toString() {
        return "Product[id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    // Override equals() to compare logical equality (not just memory address)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;             // same reference
        if (obj == null || getClass() != obj.getClass()) return false; // type check
        Product other = (Product) obj;
        return id.equals(other.id); // consider two products equal if IDs match
    }

    // Always override hashCode when overriding equals
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

public class ObjectClass {

    public static void main(String[] args) {
        Product p1 = new Product("P100", "Laptop", 1200.0);
        Product p2 = new Product("P100", "Laptop (duplicate)", 1200.0);
        Product p3 = new Product("P200", "Phone", 800.0);

        // === toString() ===
        System.out.println("p1 toString(): " + p1); // implicitly calls p1.toString()

        // === equals() ===
        System.out.println("p1.equals(p2)? " + p1.equals(p2)); // true (same id)
        System.out.println("p1.equals(p3)? " + p1.equals(p3)); // false

        // === hashCode() ===
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p3.hashCode(): " + p3.hashCode());

        // === getClass() ===
        System.out.println("p1 class: " + p1.getClass().getName());

        // === default behavior (if not overridden) ===
        Object o = new Object();
        System.out.println("Default Object toString(): " + o.toString());
        System.out.println("Default Object equals(): " + o.equals(new Object()));
    }
}

