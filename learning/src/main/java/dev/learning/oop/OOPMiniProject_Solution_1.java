package dev.learning.oop;

// Complete solution for OOP mini-project exercise 1.
// Compare your work against this, but feel free to keep your own messages/text.

import java.util.ArrayList;
import java.util.List;

class Product_1 {
    private final String id;
    private String name;
    private double price;

    public Product_1(String id, String name, double price) {
        this.id = id;
        setName(name);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("[Product] Invalid name. Keeping previous or default.");
            if (this.name == null) this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("[Product] Negative price is not allowed. Setting to 0.");
            this.price = 0.0;
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Product[id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}

interface DiscountStrategy_1 {
    double apply(double total);
}

class PercentageDiscount_1 implements DiscountStrategy_1 {
    private final double percent; // 0..1

    public PercentageDiscount_1(double percent) {
        if (percent < 0) percent = 0;
        if (percent > 1) percent = 1;
        this.percent = percent;
    }

    @Override
    public double apply(double total) {
        return total * (1 - percent);
    }
}

class FixedAmountDiscount_1 implements DiscountStrategy_1 {
    private final double amount;

    public FixedAmountDiscount_1(double amount) {
        if (amount < 0) amount = 0;
        this.amount = amount;
    }

    @Override
    public double apply(double total) {
        double res = total - amount;
        return (res < 0) ? 0 : res;
    }
}

abstract class User_1 {
    protected String name;

    public User_1(String name) {
        this.name = name;
    }

    public abstract String role();

    public String displayName() {
        return name;
    }
}

class Customer_1 extends User_1 {
    public Customer_1(String name) {
        super(name);
    }

    @Override
    public String role() {
        return "Customer";
    }
}

class ShoppingCart_1 {
    static class Item_1 {
        Product_1 product;
        int qty;

        Item_1(Product_1 p, int q) {
            product = p;
            qty = q;
        }
    }

    private final List<Item_1> items = new ArrayList<>();
    private DiscountStrategy_1 strategy;

    public ShoppingCart_1(DiscountStrategy_1 strategy) {
        this.strategy = (strategy == null) ? new PercentageDiscount_1(0.0) : strategy;
    }

    public ShoppingCart_1() {
        this(new PercentageDiscount_1(0.0));
    }

    public void addItem(Product_1 p) {
        addItem(p, 1);
    }

    public void addItem(Product_1 p, int qty) {
        if (p == null) {
            System.out.println("[Cart] Cannot add null product.");
            return;
        }
        if (qty <= 0) {
            System.out.println("[Cart] Quantity must be > 0. Skipping.");
            return;
        }
        items.add(new Item_1(p, qty));
    }

    public void setStrategy(DiscountStrategy_1 strategy) {
        if (strategy == null) {
            System.out.println("[Cart] Null strategy not allowed. Keeping previous.");
            return;
        }
        this.strategy = strategy;
    }

    public double subtotal() {
        double sum = 0;
        for (Item_1 it : items) sum += it.product.getPrice() * it.qty;
        return sum;
    }

    public double totalAfterDiscount() {
        return strategy.apply(subtotal());
    }

    public void printItems() {
        for (Item_1 it : items) {
            System.out.println("- " + it.product + " x " + it.qty);
        }
    }
}

class Order_1 {
    private static int nextOrderNo = 1;

    private final int orderNo;
    private final Customer_1 customer;
    private final double amount;

    public Order_1(Customer_1 customer, double amount) {
        this.orderNo = nextOrderNo++;
        this.customer = customer;
        this.amount = amount;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public String summary() {
        return "Order#" + orderNo + " by " + customer.displayName()
                + " (" + customer.role() + ") → $" + String.format("%.2f", amount);
    }
}

public class OOPMiniProject_Solution_1 {

    public static void main(String[] args) {
        // Memory allocation reminder:
        // Product p1 is a reference; "new Product(...)" allocates the object on the heap.

        Product_1 p1 = new Product_1("P-100", "Notebook", 5.50);
        Product_1 p2 = new Product_1("P-200", "Pen", 1.20);
        Product_1 p3 = new Product_1("P-300", "Backpack", 29.99);

        // Probe validation:
        p2.setPrice(-10);      // will clamp to 0.0
        p3.setName("");        // will keep previous

        Customer_1 customerMaya = new Customer_1("Maya");

        ShoppingCart_1 cart = new ShoppingCart_1(new PercentageDiscount_1(0.10)); // 10% off
        cart.addItem(p1);            // default qty 1
        cart.addItem(p2, 3);         // qty 3
        cart.addItem(p3, 2);

        System.out.println("=== Cart Items ===");
        cart.printItems();
        System.out.println("Subtotal = " + cart.subtotal());
        System.out.println("Total (10% off) = " + String.format("%.2f", cart.totalAfterDiscount()));

        // Swap strategy at runtime (loose coupling)
        cart.setStrategy(new FixedAmountDiscount_1(15));
        System.out.println("Total (fixed $15 off) = " + String.format("%.2f", cart.totalAfterDiscount()));

        // Orders use static order number
        Order_1 o1 = new Order_1(customerMaya, cart.totalAfterDiscount());
        System.out.println(o1.summary());

        // Another order to show static counter-increments
        cart.setStrategy(new PercentageDiscount_1(0.25)); // 25% off
        Order_1 o2 = new Order_1(customerMaya, cart.totalAfterDiscount());
        System.out.println(o2.summary());
    }
}

