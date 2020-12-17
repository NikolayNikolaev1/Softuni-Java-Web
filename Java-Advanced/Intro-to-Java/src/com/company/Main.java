package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        hitTheTarget(scanner);

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
}

