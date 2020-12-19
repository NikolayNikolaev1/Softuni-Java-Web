package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        // 1 am bad coding...
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] matrix = createMatrix(scanner, row, col);
        getMaximalSum(matrix);
    }

    private static int[][] createMatrix(Scanner scanner, int inputRows, int inputCols) {
        int[][] matrix = new int[inputRows][inputCols];

        for (int row = 0; row < inputRows; row++) {
            for (int col = 0; col < inputCols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static void getMaximalSum(int[][] matrix) {
        int maximumSum = 0;
        ArrayDeque<Integer> maximumMatrix = new ArrayDeque<>();;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                // Checks if the 3 x 3 matrix isn't out of boundaries of the main matrix.
                if (row + 3 <= matrix.length && col + 3 <= matrix[0].length) {
                    // Needs refactoring..
                    // Can use another loop in loop, but same functionality..
                    int currentSum = matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col]
                            + matrix[row][col + 1] + matrix[row + 1][col + 1] + matrix[row + 2][col + 1]
                            + matrix[row][col + 2] + matrix[row + 1][col + 2] + matrix[row + 2][col + 2];

                    if (currentSum > maximumSum) {
                        maximumSum = currentSum;
                        // Saving the matrix with the max sum in a queue, so I can print it in the final result.
                        // Needs refactoring..
                        // Can use another loop in loop, but same functionality..
                        maximumMatrix = new ArrayDeque<>();
                        maximumMatrix.offer(matrix[row][col]);
                        maximumMatrix.offer(matrix[row][col + 1]);
                        maximumMatrix.offer(matrix[row][col + 2]);
                        maximumMatrix.offer(matrix[row + 1][col]);
                        maximumMatrix.offer(matrix[row + 1][col + 1]);
                        maximumMatrix.offer(matrix[row + 1][col + 2]);
                        maximumMatrix.offer(matrix[row + 2][col]);
                        maximumMatrix.offer(matrix[row + 2][col + 1]);
                        maximumMatrix.offer(matrix[row + 2][col + 2]);
                    }
                }
            }
        }

        System.out.printf("Sum = %d%n", maximumSum);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d ", maximumMatrix.poll());
            }
            System.out.println();
        }
    }
}
