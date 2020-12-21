package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pushElementsCount = scanner.nextInt();
        int popElementsCount = scanner.nextInt();
        int checkElement = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        scanner.nextLine();

        for (int i = 0; i < pushElementsCount; i++) {
            stack.push(scanner.nextInt());
        }

        for (int i = 0; i < popElementsCount; i++) {
            stack.pop();
        }

        if (stack.contains(checkElement)) {
            System.out.println("true");
        } else {
            Integer[] stackArr = stack.clone().toArray(new Integer[0]);
            int minNum = stack.clone().toArray(new Integer[0])[0];
            for (int i = 0; i < stackArr.length; i++) {
                if (minNum > stackArr[i]) {
                    minNum = stackArr[i];
                }
            }

            System.out.println(minNum);
        }
    }
}
