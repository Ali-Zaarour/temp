package dev.learning.oop;

// Topic: Reducing Coupling in Java

/*
 * Problem:
 *   If a class creates its own dependencies (new objects inside),
 *   it becomes tightly coupled → hard to change later.
 *
 * Solution:
 *   - Use interfaces (abstraction).
 *   - Inject dependencies (constructor or setter injection).
 *   - This way, classes are loosely coupled → more flexible and testable.
 */

// === Step 1: Define an abstraction ===
interface PaymentMethod {
    void pay(double amount);
}

// === Step 2: Provide multiple implementations ===
class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

// === Step 3: Depend on abstraction, not concrete class ===
class ShoppingCart {

    private final PaymentMethod paymentMethod;

    // Dependency Injection (constructor injection)
    ShoppingCart(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    void checkout(double total) {
        paymentMethod.pay(total);
    }
}

public class ReducingCoupling {

    public static void main(String[] args) {
        // Pass different payment strategies at runtime
        ShoppingCart cart1 = new ShoppingCart(new CreditCardPayment());
        cart1.checkout(100.0);

        ShoppingCart cart2 = new ShoppingCart(new PayPalPayment());
        cart2.checkout(200.0);

        /*
         * Key Points:
         * - ShoppingCart does NOT know which payment system it uses.
         * - If tomorrow we add ApplePay, just create a new class
         *   implementing PaymentMethod (no change to ShoppingCart).
         * - Loose coupling achieved via interface + dependency injection.
         */
    }
}

