package com.company;

import java.util.Scanner;

public class MatrixShuffling {

    private static final String END_COMMAND = "end";
    private static final String SWAP_COMMAND = "swap";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputRow = scanner.nextInt();
        int inputCol = scanner.nextInt();

        String[][] matrix = createMatrix(scanner, inputRow, inputCol);
        commandsHandler(scanner, matrix);
    }

    private static String[][] createMatrix(Scanner scanner, int inputRows, int inputCols) {
        String[][] matrix = new String[inputRows][inputCols];

        for (int row = 0; row < inputRows; row++) {
            for (int col = 0; col < inputCols; col++) {
                matrix[row][col] = scanner.next();
            }
        }

        // This is for going on the next line for reading the upcoming commands.
        scanner.nextLine();

        return  matrix;
    }

    private  static void commandsHandler(Scanner scanner, String[][] matrix) {
        String[] command = scanner.nextLine().split(" ");

        while (!END_COMMAND.equals(command[0].toLowerCase())) {
            String swapCommand = command[0].toLowerCase();

            // Validation for command name "Swap".
            if (!SWAP_COMMAND.equals(swapCommand)) {
                System.out.println("Invalid input!");
                command = scanner.nextLine().split(" ");
                continue;
            }

            // Validation for command "Swap" length.
            if (command.length != 5) {
                System.out.println("Invalid input!");
                command = scanner.nextLine().split(" ");
                continue;
            }

            int row = matrix.length;
            int col = matrix[0].length;
            int firstCoordinateRow = Integer.parseInt(command[1]);
            int firstCoordinateCol = Integer.parseInt(command[2]);
            int secondCoordinateRow = Integer.parseInt(command[3]);
            int secondCoordinateCol = Integer.parseInt(command[4]);

            // Validation for command "Swap" coordinates
            if (firstCoordinateRow > row || secondCoordinateRow > row
                    || firstCoordinateCol > col || secondCoordinateCol > col) {
                System.out.println("Invalid input!");
                command = scanner.nextLine().split(" ");
                continue;
            }

            String[][] swappedMatrix = swapCoordinates(matrix,
                    firstCoordinateRow, firstCoordinateCol,
                    secondCoordinateRow, secondCoordinateCol);

            printMatrix(swappedMatrix);

            command = scanner.nextLine().split(" ");
        }
    }

    private static String[][] swapCoordinates(String[][] matrix
            , int firstCoordinateRow, int firstCoordinateCol
            , int secondCoordinateRow, int secondCoordinateCol) {
        String firstCoordinatesValue = " ";
        String secondCoordinatesValue = " ";

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (firstCoordinateRow == row && firstCoordinateCol == col) {
                    firstCoordinatesValue = matrix[row][col];
                }

                if (secondCoordinateRow == row && secondCoordinateCol == col) {
                    secondCoordinatesValue = matrix[row][col];
                }
            }
        }

        matrix[firstCoordinateRow][firstCoordinateCol] = secondCoordinatesValue;
        matrix[secondCoordinateRow][secondCoordinateCol] = firstCoordinatesValue;

        return matrix;
    }

    private  static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }

            System.out.println();
        }
    }
}
