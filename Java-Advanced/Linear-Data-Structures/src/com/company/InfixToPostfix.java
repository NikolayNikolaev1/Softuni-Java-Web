package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class InfixToPostfix {
    private static final String PLUS_TOKEN = "+";
    private static final String MINUS_TOKEN = "-";
    private static final String MULTIPLY_TOKEN = "*";
    private static final String DIVIDE_TOKEN = "/";
    private static final String[] OPERATORS = {"+", "-", "*", "/"};
    private static final String OPEN_BRACKET_TOKEN = "(";
    private static final String CLOSED_BRACKET_TOKEN = ")";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Deque<String> symbols = new ArrayDeque<>();
        Deque<String> outputQueue = new ArrayDeque<>();

//        for (String symbol : input) {
//            if (PLUS_TOKEN.equals(symbol) || MINUS_TOKEN.equals(symbol) || MULTIPLY_TOKEN.equals(symbol) || OPEN_BRACKET_TOKEN.equals(symbol)) {
//                symbols.push(symbol);
//            } else if (DIVIDE_TOKEN.equals(symbol)) {
//                if (PLUS_TOKEN.equals(symbols.peek()) || MINUS_TOKEN.equals(symbols.peek())) {
//                    System.out.print(symbols.pop() + " ");
//                }
//                if (MULTIPLY_TOKEN.equals(symbols.peek()) || DIVIDE_TOKEN.equals(symbols.peek()) || symbols.isEmpty()) {
//                    symbols.push(symbol);
//                }
//            } else if (CLOSED_BRACKET_TOKEN.equals(symbol)) {
//                while (!OPEN_BRACKET_TOKEN.equals(symbols.peek())) {
//                    if (CLOSED_BRACKET_TOKEN.equals(symbols.peek())) {
//                        symbols.pop();
//                        break;
//                    }
//                    System.out.print(symbols.pop() + " ");
//                }
//
//                symbols.pop();
//            } else {
//                // else it is number
//                System.out.print(symbol + " ");
//            }
//        }
//
//        while (!symbols.isEmpty()) {
//            System.out.print(symbols.pop());
//        }

        for (String symbol : input) {
            if (Character.isDigit(symbol.charAt(0))) {
                outputQueue.offer(symbol);
            } else if (PLUS_TOKEN.equals(symbol) || MINUS_TOKEN.equals(symbol)
                    || MULTIPLY_TOKEN.equals(symbol) || DIVIDE_TOKEN.equals(symbol)) {
                while (Arrays.asList(OPERATORS).contains(symbol)) {

                }
            }
        }
    }
}
