package com.company;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputRows = scanner.nextInt();
        int inputCols = scanner.nextInt();

        createMatrix(inputRows, inputCols);


    }

    private static void createMatrix(int rowsLength, int colsLength) {
        String[][] matrix = new String[rowsLength][colsLength];

        for (int row = 0; row < rowsLength; row++) {
            for (int col = 0; col < colsLength; col++) {
                char firstAndLastLetters = (char) ('a' + row);
                char middleLetter = (char) ('a' + row + col);

                // Converting the characters' code into string of that char code and concatenating them into one string.
                matrix[row][col] = String.valueOf(firstAndLastLetters)
                        .concat(String.valueOf(middleLetter))
                        .concat(String.valueOf(firstAndLastLetters));
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }

            System.out.println();
        }
    }
}
