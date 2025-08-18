package dev.learning.fundamental;

// Reference solution for the "all-in-one" fundamentals exercise.
// Your results can differ slightly (messages/format), that’s fine.

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FundamentalAllInOne_Solution {

    // Section 9 methods
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;
        return sum;
    }

    public static double average(int[] arr) {
        return arr.length == 0 ? 0.0 : sumArray(arr) / (double) arr.length;
    }

    public static void main(String[] args) {
        // ===== Section 1 =====
        int age = 20;
        double height = 1.78;
        boolean student = true;
        char initial = 'A';
        System.out.println("Age=" + age + ", Height=" + height + ", Student=" + student + ", Initial=" + initial);

        // ===== Section 2 =====
        String fullName = "Ali Zaarour";
        System.out.println("Hello, " + fullName.toUpperCase() + "!");
        System.out.println("ID\tName\tScore\n1\tAli\t95\n2\tSara\t88");

        // ===== Section 3 =====
        final double PI = 3.141592653589793;
        double radius = 5.0;
        double area = PI * radius * radius;
        double circum = 2 * PI * radius;
        System.out.println("Circle area=" + area + ", circum=" + circum);

        System.out.println("sqrt(16)=" + Math.sqrt(16));
        System.out.println("pow(2,8)=" + Math.pow(2, 8));
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Dice roll=" + dice);

        int a = 7, b = 2;
        double precise = (double) a / b;
        System.out.println("7/2 as double = " + precise);

        // ===== Section 4 =====
        double subtotal = 1234.5;
        double taxRate = 0.11;
        double tax = subtotal * taxRate;
        double total = subtotal + tax;
        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(0);
        System.out.println("Subtotal: " + money.format(subtotal));
        System.out.println("Tax (" + percent.format(taxRate) + "): " + money.format(tax));
        System.out.println("Total: " + money.format(total));

        // ===== Section 5 =====
        int[] scores = {90, 75, 82, 100, 67};
        System.out.println("scores.length=" + scores.length + ", first=" + scores[0] + ", last=" + scores[scores.length - 1]);
        System.out.print("All scores: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + (i < scores.length - 1 ? " " : "\n"));
        }

        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int n = m.length;
        int mainDiag = 0, secDiag = 0;
        for (int i = 0; i < n; i++) {
            mainDiag += m[i][i];
            secDiag += m[i][n - 1 - i];
        }
        System.out.println("Main diagonal sum=" + mainDiag + ", Secondary diagonal sum=" + secDiag);

        // ===== Section 6 =====
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String nameIn = sc.nextLine().trim();
        System.out.print("Enter age: ");
        int ageIn = sc.nextInt();
        System.out.print("Enter height (m): ");
        double heightIn = sc.nextDouble();
        if (ageIn < 0) {
            System.out.println("Error: negative age not allowed.");
        } else {
            System.out.println("Summary: " + nameIn + ", age=" + ageIn + ", height=" + heightIn + "m");
        }

        // ===== Section 7 =====
        System.out.println("Adult student? " + (age >= 18 && student));
        char grade = 'B';
        String msg = (grade == 'A') ? "Excellent" : (grade == 'B') ? "Good" : "Keep improving";
        System.out.println("Grade message: " + msg);

        // ===== Section 8 =====
        int month = 2;
        String season = switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "Invalid";
        };
        System.out.println("Month " + month + " → " + season);

        // ===== Section 9 =====
        int sum = sumArray(scores);
        double avg = average(scores);
        System.out.println("Sum=" + sum + ", Avg=" + avg);

        // ===== Section 10 =====
        System.out.print("for 1..20 (skip %3, stop at 17): ");
        for (int i = 1; i <= 20; i++) {
            if (i == 17) { System.out.println("\nHit 17 → break"); break; }
            if (i % 3 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("while countdown: ");
        int c = 5;
        while (c >= 1) {
            System.out.print(c + " ");
            c--;
        }
        System.out.println("Done!");

        int choice;
        do {
            System.out.println("\nMenu: 1) Say Hi  2) Say Bye  3) Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Hi!");
                case 2 -> System.out.println("Bye!");
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 3);

        sc.close();
    }
}

