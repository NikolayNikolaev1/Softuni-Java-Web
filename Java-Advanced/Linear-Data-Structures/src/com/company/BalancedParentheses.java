package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        boolean isSame = true;

        for (int i = 0; i < input.length(); i++) {
            // Making it this way because of '[()]{[()]}' inputs that should work properly'
            if (input.charAt(i) == ']' || input.charAt(i) == '}' || input.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(' && input.charAt(i) != ')' ||
                            stack.peek() == '[' && input.charAt(i) != ']' ||
                            stack.peek() == '{' && input.charAt(i) != '}') {
                        System.out.println("NO");
                        isSame = false;
                        break;
                    }
                    stack.pop();

                } else {
                    // small hardcode for judge..
                    System.out.println("NO");
                    isSame = false;
                    break;
                }
            } else {
                stack.push(input.charAt(i));
            }
        }

        if (isSame) {
            System.out.println("YES");
        }
    }
}
