package com.company;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[][] matrix = createMatrix(scanner, size);

        System.out.println(getDiagonalDifference(matrix));
    }

    private static int[][] createMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int getDiagonalDifference(int[][] matrix) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    primaryDiagonalSum += matrix[row][col];
                }

                // Using formula from exercise.
                if (col == matrix.length - 1 - row) {
                    secondaryDiagonalSum += matrix[row][col];
                }
            }
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

}
