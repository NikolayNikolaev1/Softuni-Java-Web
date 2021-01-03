package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Integer[] numbers = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Function<Integer[], Integer[]> addCommand = nums -> {
            for (int i = 0; i < nums.length; i++) {
                nums[i]++;
            }
            return nums;
        };
        Function<Integer[], Integer[]> multiplyCommand = nums -> {
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= 2;
            }
            return nums;
        };
        Function<Integer[], Integer[]> subtractCommand = nums -> {
            for (int i = 0; i < nums.length; i++) {
                nums[i]--;
            }
            return nums;
        };
        Consumer<Integer[]> printCommand = nums -> {
            String[] result = new String[nums.length];

            for (int i = 0; i < result.length; i++) {
                result[i] = nums[i].toString();
            }

            System.out.println(String.join(" ", result));
        };

        String command = reader.readLine();

        while (!END_COMMAND.equals(command)) {
            switch (command) {
                case "add":
                    numbers = addCommand.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyCommand.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractCommand.apply(numbers);
                    break;
                case "print":
                    printCommand.accept(numbers);
                    break;
            }

            command = reader.readLine();
        }
    }
}
