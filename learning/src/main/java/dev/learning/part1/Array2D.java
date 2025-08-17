package dev.learning.part1;

// Demonstrates 2D (two-dimensional) arrays in Java.

/*
 * 2D Arrays in Java:
 * ------------------
 * - A 2D array is essentially an "array of arrays".
 * - Syntax:
 *     dataType[][] arrayName = new dataType[rows][cols];
 *     dataType[][] arrayName = { {val1, val2}, {val3, val4} };
 *
 * - Accessing elements:
 *     array[row][col]
 *
 * - Number of rows = array.length
 * - Number of columns (in row i) = array[i].length
 */

public class Array2D {

    public static void main(String[] args) {
        // 1. Declaration + allocation
        int[][] matrix = new int[2][3]; // 2 rows, 3 columns
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        // 2. Declaration + initialization
        String[][] names = {
                {"Alice", "Bob"},
                {"Charlie", "Diana"},
                {"Eve", "Frank"}
        };

        // 3. Accessing elements
        System.out.println("matrix[0][1] = " + matrix[0][1]); // 2
        System.out.println("names[2][0] = " + names[2][0]);   // Eve

        // 4. Iterating with nested loops
        System.out.println("\nMatrix elements:");
        for (int row = 0; row < matrix.length; row++) {          // number of rows
            for (int col = 0; col < matrix[row].length; col++) { // number of columns
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); // new line after each row
        }

        // 5. Using enhanced for loop
        System.out.println("\nNames:");
        for (String[] row : names) {
            for (String name : row) {
                System.out.print(name + " ");
            }
            System.out.println();
        }

        // 6. Jagged Array (rows with different column sizes)
        int[][] jagged = {
                {1, 2, 3},
                {4, 5},
                {6}
        };
        System.out.println("\nJagged array:");
        for (int[] row : jagged) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
