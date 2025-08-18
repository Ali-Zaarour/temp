package dev.learning.part1;

// Demonstrates different ways of formatting numbers in Java.

/*
 * Ways to format numbers in Java:
 * -------------------------------
 * 1. String.format()        → simple placeholders (like printf in C).
 * 2. System.out.printf()    → same as String.format but prints directly.
 * 3. DecimalFormat (class)  → customizable patterns.
 * 4. NumberFormat (class)   → locale-aware (currency, percentage, etc.).
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatting {

    public static void main(String[] args) {
        double num = 12345.6789;

        // 1. Using String.format
        String formatted1 = String.format("%.2f", num); // 2 decimal places
        System.out.println("String.format (2 decimals): " + formatted1);

        // 2. Using printf
        System.out.printf("printf (with commas, 2 decimals): %, .2f%n", num);

        // 3. Using DecimalFormat (custom pattern)
        DecimalFormat df = new DecimalFormat("#,###.00"); // grouping + 2 decimals
        System.out.println("DecimalFormat: " + df.format(num));

        // 4. Using NumberFormat (locale-aware)
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        nf.setMaximumFractionDigits(2);
        System.out.println("NumberFormat (US): " + nf.format(num));

        // 5. Currency format
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Currency (US): " + currency.format(num));

        // 6. Percentage format
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(1);
        double ratio = 0.856;
        System.out.println("Percentage: " + percent.format(ratio));
    }
}
