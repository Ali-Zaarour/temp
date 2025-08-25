package dev.learning.oop;

// Topic: One cohesive exercise that practices the most important OOP concepts.
// ALWAYS READ COMMENTS. Every step has hints and TODOs.
// Concepts used here:
// - Creating classes/objects, memory allocation (references vs heap)
// - Encapsulation (private fields + getters/setters with validation)
// - Abstraction (interface + abstract class)
// - Reducing coupling via Dependency Injection (DI)
// - Constructor + Constructor Overloading
// - Method Overloading and Overriding
// - Static members (shared counters / constants)
// - Clean "main" to drive a small e-commerce-like flow

import java.util.ArrayList;
import java.util.List;

/* ==========================
   DOMAIN OVERVIEW (READ ME)
   ==========================
   We'll model a tiny cart checkout:

   - Product (encapsulated)
   - DiscountStrategy (abstraction via interface) with two concrete strategies:
       * PercentageDiscount
       * FixedAmountDiscount
   - User hierarchy (abstraction via abstract class): User -> Customer
   - ShoppingCart (uses DI to accept a DiscountStrategy)
       * addItem(...) is overloaded
   - Order uses a static counter to generate order numbers

   MEMORY NOTES:
   - Variables like `Product p = new Product(...);` put reference `p` on the stack,
     and the Product object on the heap. Assigning `Product q = p;` makes q point
     to the same heap object (two refs, one object).
*/

// ===== 1) ENCAPSULATION: Product with private fields + getters/setters =====
class Product {
    private final String id;   // immutable after construction
    private String name;
    private double price;

    // TODO(1): Complete this constructor to initialize id, name, price.
    // HINT: validate price >= 0. If invalid, set to 0 and print a warning.
    public Product(String id, String name, double price) {
        // TODO
        this.id = null; // replace
    }

    // TODO(2): Add getter for id (no setter; id is final).
    // TODO(3): Add getter/setter for name (validate not null/empty).
    // TODO(4): Add getter/setter for price (validate >= 0).

    // TODO(5): Override toString() to print: Product[id=..., name=..., price=...]
    // HINT: @Override public String toString() { ... }
}

// ===== 2) ABSTRACTION VIA INTERFACE: DiscountStrategy =====
interface DiscountStrategy {
    double apply(double total); // total in, discounted total out
}

// Two concrete strategies (loose coupling via interface)
class PercentageDiscount implements DiscountStrategy {
    private final double percent; // e.g., 0.10 for 10%

    // TODO(6): Constructor taking percent; clamp to [0, 1].
    public PercentageDiscount(double percent) {
        // TODO
        this.percent = 0.0; // replace
    }

    @Override
    public double apply(double total) {
        // TODO(7): return discounted total (total * (1 - percent))
        return total; // replace
    }
}

class FixedAmountDiscount implements DiscountStrategy {
    private final double amount;

    // TODO(8): Constructor taking amount; clamp to >= 0.
    public FixedAmountDiscount(double amount) {
        // TODO
        this.amount = 0.0; // replace
    }

    @Override
    public double apply(double total) {
        // TODO(9): return max(total - amount, 0)
        return total; // replace
    }
}

// ===== 3) ABSTRACTION VIA ABSTRACT CLASS: User -> Customer =====
abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    // Abstract: forces subclasses to define role label
    public abstract String role();

    // Concrete: shared behavior
    public String displayName() {
        return name;
    }
}

class Customer extends User {
    // TODO(10): Override role() to return "Customer"
    public Customer(String name) {
        super(name);
    }

    // TODO
    public String role() {
        return "";
    } // replace
}

// ===== 4) SHOPPING CART with DI + METHOD OVERLOADING =====
class ShoppingCart_0 {
    // Simple item model
    static class Item {
        Product product;
        int qty;

        Item(Product product, int qty) {
            this.product = product;
            this.qty = qty;
        }
    }

    private final List<Item> items = new ArrayList<>();
    private DiscountStrategy strategy; // injected

    // TODO(11): Constructor Overloading:
    //  - One constructor that accepts a DiscountStrategy (DI).
    //  - One no-arg constructor that defaults to PercentageDiscount(0.0).
    public ShoppingCart_0(DiscountStrategy strategy) {
        // TODO
    }

    public ShoppingCart_0() {
        // TODO
    }

    // METHOD OVERLOADING:
    // TODO(12): addItem(Product p) -> default qty 1
    // TODO(13): addItem(Product p, int qty) -> if qty <= 0, ignore with a warning
    public void addItem(Product p) {
        // TODO
    }

    public void addItem(Product p, int qty) {
        // TODO
    }

    public void setStrategy(DiscountStrategy strategy) {
        // allow swapping strategy at runtime (reducing coupling)
        this.strategy = strategy;
    }

    public double subtotal() {
        double sum = 0;
        for (Item it : items) {
            // requires getters in Product
            //sum += it.product.getPrice() * it.qty;
        }
        return sum;
    }

    public double totalAfterDiscount() {
        return strategy.apply(subtotal());
    }

    public void printItems() {
        for (Item it : items) {
            System.out.println("- " + it.product + " x " + it.qty);
        }
    }
}

// ===== 5) STATIC MEMBER: Order number generator =====
class Order {

    private static int nextOrderNo = 1; // shared across all orders
    private final int orderNo;
    private final Customer customer;
    private final double amount;

    // TODO(14): Constructor assigns unique orderNo using static counter,
    //           then increments the counter.
    public Order(Customer customer, double amount) {
        // TODO
        this.orderNo = 0; // replace
        this.customer = customer;
        this.amount = amount;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public String summary() {
        return "Order#" + orderNo + " by " + customer.displayName() + " (" + customer.role() + ") → $" + amount;
    }
}

// ===== 6) MAIN: Drive the exercise =====
public class OOPMiniProject_Exercise_1 {

    public static void main(String[] args) {
        // HINT: Memory Allocation note
        // Product pRef is a reference on the stack; new Product(...) creates the object on the heap.
        // Product qRef = pRef; → both references point to the same heap object.

        // TODO(15): Create 3 products with different prices.
        // NOTE: Use setters to test validation (e.g., try setting a negative price).
        Product p1 = null; // replace it with real product
        Product p2 = null; // replace
        Product p3 = null; // replace

        // TODO(16): Create a Customer.
        Customer cust = null; // replace

        // TODO(17): Create a ShoppingCart with a PercentageDiscount(0.10) using DI.
        ShoppingCart_0 cart = null; // replace

        // TODO(18): Add items using BOTH overloaded methods (with & without qty).
        // Example: cart.addItem(p1); cart.addItem(p2, 2);

        // Show cart
        System.out.println("=== Cart Items ===");
        cart.printItems();
        System.out.println("Subtotal = " + cart.subtotal());
        System.out.println("Total (10% off) = " + cart.totalAfterDiscount());

        // TODO(19): Swap discount strategy at runtime to FixedAmountDiscount(15)
        //           and print the new total.
        // HINT: cart.setStrategy(new FixedAmountDiscount(15));

        // TODO(20): Create an Order for this customer with the discounted total
        //           and print order summary. Then create a second Order to confirm
        //           static counter increments (Order numbers should differ).
        Order o1 = null; // replace
        System.out.println(o1.summary());

        Order o2 = null; // replace
        System.out.println(o2.summary());
    }
}

