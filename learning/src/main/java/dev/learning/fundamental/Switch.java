package dev.learning.fundamental;

// Demonstrates the switch statement in Java.

/*
 * Switch Statement:
 * -----------------
 * Syntax:
 *   switch (variable) {
 *       case value1:
 *           // code
 *           break;
 *       case value2:
 *           // code
 *           break;
 *       ...
 *       default:
 *           // code if no case matches
 *   }
 *
 * Notes:
 * - Works with: byte, short, char, int, String, enum.
 * - break; is needed to stop execution, otherwise "fall-through" happens.
 * - Default is optional.
 */

public class Switch {

    public static void main(String[] args) {
        int day = 3;

        // 1. Classic switch
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // 2. Switch with String (Java 7+)
        String fruit = "Apple";
        switch (fruit) {
            case "Apple":
                System.out.println("You chose an Apple");
                break;
            case "Banana":
                System.out.println("You chose a Banana");
                break;
            default:
                System.out.println("Unknown fruit");
        }

        // 3. Switch expression (Java 14+, modern style)
        int month = 2;
        String season = switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "Invalid month";
        };
        System.out.println("Month " + month + " → " + season);
    }
}
