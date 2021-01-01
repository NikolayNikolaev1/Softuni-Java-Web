package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class AppliedArithmetic {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Integer[] numbers = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        // FIXME: 31-Dec-20 
        Consumer<Integer[]> addCommand = nums -> Arrays.asList(nums).forEach(num -> num++);
        Consumer<Integer[]> multiplyCommand = nums -> Arrays.asList(nums).forEach(num -> num *= 2);
        Consumer<Integer[]> subtractCommand = nums -> Arrays.asList(nums).forEach(num -> num--);
        Consumer<Integer[]> printCommand = nums -> Arrays.asList(nums)
                .forEach(num -> System.out.println(String.join(" ", num.toString())));

        String command = reader.readLine();

        while (!END_COMMAND.equals(command)) {
            switch (command) {
                case "add":
                    addCommand.accept(numbers);
                    break;
                case "multiply":
                    multiplyCommand.accept(numbers);
                    break;
                case "subtract":
                    subtractCommand.accept(numbers);
                case "print":
                    printCommand.accept(numbers);
                    break;
            }

            command = reader.readLine();
        }
    }
}
