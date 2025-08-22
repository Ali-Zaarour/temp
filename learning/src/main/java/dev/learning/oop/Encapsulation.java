package dev.learning.oop;

// Topic: Encapsulation in Java

/*
 * Encapsulation:
 * - Wrapping data (fields) and methods (behaviors) into a single unit (class).
 * - Making fields private → they cannot be accessed directly from outside.
 * - Providing public getters/setters → controlled access to the fields.
 *
 * Benefits:
 * - Protects data from unauthorized access.
 * - Allows validation before changing values.
 * - Increases code maintainability and security.
 */

class BankAccounts {
    // === Private fields (hidden from outside classes) ===
    private String accountNumber;
    private double balance;

    // === Constructor ===
    BankAccounts(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // === Getter for balance (read-only access) ===
    public double getBalance() {
        return balance;
    }

    // === Method to deposit money (validates input) ===
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // === Method to withdraw money (validates input) ===
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance!");
        }
    }
}

public class Encapsulation {

    public static void main(String[] args) {
        // === Create an object of BankAccount ===
        BankAccounts account = new BankAccounts("ACC123", 1000);

        // Cannot access account.balance directly (it's private!)
        // System.out.println(account.balance); ERROR

        // Use public methods instead
        System.out.println("Initial Balance: $" + account.getBalance());

        account.deposit(500);
        System.out.println("After Deposit: $" + account.getBalance());

        account.withdraw(300);
        System.out.println("After Withdrawal: $" + account.getBalance());

        account.withdraw(2000); // Invalid, more than balance
    }
}

