package com.company;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        switch (pattern) {
            case "A":
                patternA(size);
                break;
            case "B":
                patternB(size);
                break;
        }
    }

    private static void patternA(int size) {
        int[][] matrix = new int[size][size];

        int counter = 1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[col][row] = counter;
                counter++;
            }
        }

        printMatrix(matrix);
    }

    private static void patternB(int size) {
        int[][] matrix = new int[size][size];

        int counter = 1;

        for (int row = 0; row < size; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < size; col++) {
                    matrix[col][row] = counter;
                    counter++;
                }
            } else {
                for (int col = size - 1; col >= 0; col--) {
                    matrix[col][row] = counter;
                    counter++;
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
