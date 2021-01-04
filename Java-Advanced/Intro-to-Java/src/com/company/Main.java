package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Change the called method for testing exercises..
        blurFilter(scanner);
    }

    private static void rectangleArea(Scanner scanner) {
        // Using double for input values, because of softuni judge system.
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double sum = a * b;

        System.out.printf("%.2f%n", sum);
    }

    private static void triangleArea(Scanner scanner) {
        int firstPointX = scanner.nextInt();
        int firstPointY = scanner.nextInt();
        int secondPointX = scanner.nextInt();
        int secondPointY = scanner.nextInt();
        int thirdPointX = scanner.nextInt();
        int thirdPointY = scanner.nextInt();

        // Using coordinate geometry formula for area of a triangle.
        int area = ((firstPointX * (secondPointY - thirdPointY) +
                secondPointX * (thirdPointY - firstPointY) +
                thirdPointX * (firstPointY - secondPointY))) / 2;

        if (area < 0) {
            area *= -1;
        }

        System.out.print(area);
    }

    private static void formattingNumbers(Scanner scanner) {
        int firstNumber = scanner.nextInt();
        float secondNumber = scanner.nextFloat();
        float thirdNumber = scanner.nextFloat();

        // Using this format to have white space before/after string.
        String firstCol = String.format("%-10s", Integer.toHexString(firstNumber));
        String secondCol = String.format("%10s", Integer.toBinaryString(firstNumber))
                .replace(' ', '0');
        String thirdCol = String.format("%10s", String.format("%.2f", secondNumber));
        String fourthCol = String.format("%-10s", String.format("%.3f", thirdNumber));

        System.out.printf("|%s|%s|%s|%s|", firstCol.toUpperCase(), secondCol, thirdCol, fourthCol);
    }

    private static void calculateExpression(Scanner scanner) {
        // Using double for input values, because of softuni judge system.
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double firstExpression = Math.pow((Math.pow(a, 2) + Math.pow(b, 2)) /
                (Math.pow(a, 2) - Math.pow(b, 2)), (a + b + c) / Math.sqrt(c));

        double secondExpression = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), a - b);

        double inputNumbersAverage = (a + b + c) / 3;
        double expressionsAverage = (firstExpression + secondExpression) / 2;

        double averageAbsDiff = Math.abs(inputNumbersAverage - expressionsAverage);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",
                firstExpression, secondExpression, averageAbsDiff);
    }

    private static void oddAndEvenPairs(Scanner scanner) {
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        if (numbers.length % 2 != 0) {
            System.out.println("invalid length");
        } else {
            // Because the length is even, there is no way for the loop to go out of the scope of the array while using i+=2.
            for (int i = 0; i < numbers.length; i += 2) {
                int firstNum = Integer.parseInt(numbers[i]);
                int secondNum = Integer.parseInt(numbers[i + 1]);

                if (firstNum % 2 == 0 && secondNum % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", firstNum, secondNum);
                } else if (firstNum % 2 != 0 && secondNum % 2 != 0) {
                    System.out.printf("%d, %d -> both are odd%n", firstNum, secondNum);
                } else {
                    System.out.printf("%d, %d -> different%n", firstNum, secondNum);
                }
            }

        }
    }

    private static void hitTheTarget(Scanner scanner) {
        int target = scanner.nextInt();

        if (target <= 20) {
            // Prints the added result of target that is between 0 and 20.
            for (int i = 1; i < target; i++) {
                System.out.printf("%d + %d = %d%n", i, target - i, target);
            }
        } else {
            // Prints the added result of target that is greater than 20.
            for (int i = target - 20; i <= 20; i++) {
                System.out.printf("%d + %d = %d%n", i, target - i, target);
            }
        }

        if (target >= 0) {
            // Prints the subtracted result of target that is between 1 and 19.
            for (int i = target + 1; i <= 20; i++) {
                System.out.printf("%d - %d = %d%n", i, i - target, target);
            }
        } else {
            // Prints the subtracted result of target that is a negative number.
            target *= -1; // Change to positive number for loop.
            for (int i = 1; i < 20; i++) {
                if (target + i > 20) {
                    break;
                }
                System.out.printf("%d - %d = %d%n", i, target + i, target * -1);
            }
        }
    }

    private static void characterMultiplier(Scanner scanner) {
        String firstInput = scanner.next();
        String secondInput = scanner.next();

        int numberOfLoops = 0;
        // Finds longer string input.
        numberOfLoops = Math.max(firstInput.length(), secondInput.length());

        int sum = 0;

        for (int i = 0; i < numberOfLoops; i++) {
            int firstCode = 0;
            int secondCode = 0;

            // Code for when the inputs' lengths are not equal.
            if (firstInput.length() > i) {
                firstCode = firstInput.charAt(i);
            }

            if (secondInput.length() > i) {
                secondCode = secondInput.charAt(i);
            }

            if (firstCode != 0 && secondCode != 0) {
                sum += firstCode * secondCode;
            } else {
                // Checks if either of the inputs are shorter.
                if (firstCode != 0) {
                    sum += firstCode;
                }

                if (secondCode != 0) {
                    sum += secondCode;
                }
            }

            firstCode = 0;
            secondCode = 0;
        }

        System.out.println(sum);
    }

    private static void getFirstOddOrEvenElement(Scanner scanner) {
        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();
        String[] numbers = firstInput.split(" ");
        String[] command = secondInput.split(" ");

        int numberOfElements = Integer.parseInt(command[1]);
        // Using list to store the result.
        List<Integer> elements = new ArrayList<>();

        int counter = 0;
        for (String numbersIndex : numbers) {
            if (counter == numberOfElements) {
                break;
            }

            int number = Integer.parseInt(numbersIndex);
            if (command[2].equals("odd")) {
                if (number % 2 != 0) {
                    elements.add(number);
                    counter++;
                }
            } else if (command[2].equals("even")) {
                if (number % 2 == 0) {
                    elements.add(number);
                    counter++;
                }
            }
        }

        for (Integer element : elements) {
            System.out.printf("%d ", element);
        }
    }

    // Not Finished!
    private static void ByteParty(Scanner scanner) {
        int numberOfBytes = scanner.nextInt();

        int[] numbers = new int[numberOfBytes];

        for (int i = 0; i < numberOfBytes; i++) {
            int number = scanner.nextInt();
            numbers[i] = number;
        }

        String line = scanner.nextLine();
        while (!"party over".equals(line)) {
            String[] tokens = line.split(" ");
            int pattern = Integer.parseInt(tokens[0]);
            int position = Integer.parseInt(tokens[1]);


            line = scanner.nextLine();
        }
    }

    private static void gameOfNames(Scanner scanner) {
        final int minPlayerScore = -100000;
        int numberOfPlayers = scanner.nextInt();

        String winnerName = "";
        int winnerPoints = minPlayerScore;

        // Calculating winner, while inputting data.
        for (int i = 1; i <= numberOfPlayers; i++) {
            String playerName = scanner.next();
            int playerScore = scanner.nextInt();

            // Getting char code of every players name.
            for (int y = 0; y < playerName.length(); y++) {
                int code = playerName.charAt(y);

                if (code % 2 == 0) {
                    playerScore += code;
                } else {
                    playerScore -= code;
                }
            }

            if (playerScore > winnerPoints) {
                winnerName = playerName;
                winnerPoints = playerScore;
            }
        }

        System.out.printf("The winner is %s - %d points", winnerName, winnerPoints);
    }

    private static void vehiclePark(Scanner scanner) {
        String input = scanner.nextLine();
        String[] cars = input.split(" ");
        List<String> carsList = new ArrayList<>(Arrays.asList(cars));
        int vehicleSold = 0;

        String request = scanner.nextLine();
        while (!"End of customers!".equals(request)) {
            String vehicleType = request.split(" ")[0];
            int numberOfSeats = Integer.parseInt(request.split(" ")[2]);
            boolean isSold = false;

            for (String car : carsList) {
                char carType = car.charAt(0);
                int carSeats = Integer.parseInt(car.substring(1));

                // Hardcode vehicleType to lower, so I can check if I have the car in the list faster.
                if (carType == vehicleType.toLowerCase().charAt(0) && carSeats == numberOfSeats) {
                    int price = carType * carSeats;
                    System.out.printf("Yes, sold for %d$%n", price);
                    carsList.remove(car);
                    isSold = true;
                    vehicleSold++;
                    break;
                }
            }

            if (!isSold) {
                System.out.println("No");
            }

            request = scanner.nextLine();
        }

        System.out.printf("Vehicles left: %s%n", String.join(", ", carsList));
        System.out.printf("Vehicles sold: %d%n", vehicleSold);
    }

    private static void blurFilter(Scanner scanner) {
        long blurAmount = Long.parseLong(scanner.nextLine());
        String[] matrixSize = scanner.nextLine().split(" ");
        int matrixRow = Integer.parseInt(matrixSize[0]);
        int matrixCol = Integer.parseInt(matrixSize[1]);
        long[][] matrix = new long[matrixRow][matrixCol];

        for (int row = 0; row < matrixRow; row++) {
            for (int col = 0; col < matrixCol; col++) {
                matrix[row][col] = scanner.nextInt();
            }

            scanner.nextLine();
        }

        String[] blurCoordinates = scanner.nextLine().split(" ");
        int blurRow = Integer.parseInt(blurCoordinates[0]);
        int blurCol = Integer.parseInt(blurCoordinates[1]);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row == blurRow && col == blurCol) {
                    matrix[row][col] += blurAmount;
                    // Booleans to save information for already changed cols..
                    boolean isPastColBlurred = false;
                    boolean isNextColBlurred = false;


                    // Check for existing upper row..
                    if (row - 1 >= 0) {
                        matrix[row - 1][col] += blurAmount;

                        // Check for existing col before the coordinates' col
                        if (col - 1 >= 0) {
                            matrix[row - 1][col - 1] += blurAmount;
                            matrix[row][col - 1] += blurAmount;
                            isPastColBlurred = true;
                        }

                        // Check for existing col after the coordinates' col
                        if (col + 1 < matrix[0].length) {
                            matrix[row - 1][col + 1] += blurAmount;
                            matrix[row][col + 1] += blurAmount;
                            isNextColBlurred = true;
                        }
                    }

                    if (row + 1 < matrix.length) {
                        matrix[row + 1][col] += blurAmount;

                        // Check for existing col before the coordinates' col
                        if (col - 1 >= 0) {
                            matrix[row + 1][col - 1] += blurAmount;
                            if (!isPastColBlurred) {
                                matrix[row][col - 1] += blurAmount;
                            }
                        }

                        // Check for existing col after the coordinates' col
                        if (col + 1 < matrix[0].length) {
                            matrix[row + 1][col + 1] += blurAmount;
                            if (!isNextColBlurred) {
                                matrix[row][col + 1] += blurAmount;
                            }
                        }
                    }
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}

