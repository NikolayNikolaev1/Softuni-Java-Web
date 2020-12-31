package com.company;

import java.util.Scanner;

public class SumBigNumbers {
    // bad variable naming..
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();
        StringBuilder sum = new StringBuilder();
        int stringMaxLength = Math.max(firstNumber.length(), secondNumber.length());
        boolean hasOne = false;

        for (int i = 0; i < stringMaxLength; i++) {
            int sumResult;

            if ((firstNumber.length() - 1 - i) >= 0 && (secondNumber.length() - 1 - i) >= 0) {
                sumResult = Character.getNumericValue(firstNumber.charAt(firstNumber.length() - 1 - i)) + Character.getNumericValue(secondNumber.charAt(secondNumber.length() - 1 - i));;
            } else {
                if (firstNumber.length() == stringMaxLength) {
                    sumResult = Character.getNumericValue(firstNumber.charAt(firstNumber.length() - 1 - i));
                } else {
                    sumResult = Character.getNumericValue(secondNumber.charAt(secondNumber.length() - 1 - i));
                }
            }

            if (hasOne) {
                sumResult++;
                hasOne = false;
            }

            if (sumResult >= 10) {
                sumResult -= 10;
                hasOne = true;
            }

            sum.insert(0, sumResult);
        }

        if (hasOne) {
            sum.insert(0, 1);
        }

        System.out.println(sum);
    }
}
