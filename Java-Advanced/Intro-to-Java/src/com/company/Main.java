package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        getFirstOddOrEvenElement(scanner);

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



}

