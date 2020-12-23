package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= commandCount; i++) {
            String[] command = scanner.nextLine().split(" ");
            String commandType = command[0];

            switch (commandType) {
                case "1":
                    int element = Integer.parseInt(command[1]);
                    stack.push(element);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    // TODO: NEEDS TO BE FIXED AND FINISHED
                    int maxElement = 0;
                    Object[] stackArr = stack.toArray();

                    for (int j = 0; j < stackArr.length; j++) {
                        if (maxElement < Integer.parseInt((String) stackArr[i])) {
                            maxElement = Integer.parseInt((String) stackArr[i]);
                        }
                    }

                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
