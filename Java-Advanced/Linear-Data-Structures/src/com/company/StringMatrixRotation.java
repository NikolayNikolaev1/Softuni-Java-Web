package com.company;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class StringMatrixRotation {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotationCommand = scanner.nextLine();
        String input = scanner.nextLine();
        ArrayDeque<String> inputQueue = new ArrayDeque<>();
        int inputMaxLength = 0;

        while (!END_COMMAND.equals(input.toLowerCase())) {
            inputQueue.offer(input);

            if (input.length() > inputMaxLength) {
                inputMaxLength = input.length();
            }

            input = scanner.nextLine();
        }

        char[][] matrix = createMatrix(inputQueue, inputMaxLength);
        char[][] rotatedMatrix = rotateMatrix(matrix, rotationCommand);
        printMatrix(rotatedMatrix);

    }

    private static char[][] createMatrix (ArrayDeque<String> queue, int inputMaxLength) {
        int rowsCount = queue.size();
        char[][] matrix = new char[rowsCount][inputMaxLength]; // inputMaxLength is colsCount

        for (int row = 0; row < rowsCount; row++) {
            char[] charRow = Objects.requireNonNull(queue.poll()).toCharArray();

            for (int col = 0; col < inputMaxLength; col++) {
                // Validation for out of boundaries exception for char array.
                if (charRow.length > col) {
                    matrix[row][col] = charRow[col];
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        return matrix;
    }

    private static char[][] rotateMatrix(char[][] matrix, String rotationCommand) {
        // Get rotation degrees from command with regex.
        int rotation = Integer.parseInt(rotationCommand.replaceAll("[^0-9]", ""));

        if ((rotation / 90) % 4 == 0) {
            return matrix;
        } else if ((rotation / 90) % 3 == 0) {
            return rotateMatrix270Degrees(matrix);
        } else if ((rotation / 90) % 2 == 0) {
            return rotateMatrix180Degrees(matrix);
        } else {
            return rotateMatrix90Degrees(matrix);
        }
    }

    private static char[][] rotateMatrix270Degrees(char[][] matrix) {
        char[][] rotatedMatrix = new char[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

            }
        }

        return rotatedMatrix;
    }

    private static char[][] rotateMatrix180Degrees(char[][] matrix) {
        char[][] rotatedMatrix = new char[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                // Creates reversed matrix.
                rotatedMatrix[row][col] = matrix[(matrix.length - 1) - row][(matrix[0].length - 1) - col];
            }
        }

        return rotatedMatrix;
    }

    private static char[][] rotateMatrix90Degrees(char[][] matrix) {
        char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                rotatedMatrix[row][col] = matrix[(col + matrix.length - 1 - col*2)][row];
            }
        }

        return rotatedMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
