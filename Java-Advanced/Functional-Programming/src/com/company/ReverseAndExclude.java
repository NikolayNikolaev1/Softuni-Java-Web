package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiFunction;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Integer divider = Integer.parseInt(reader.readLine());
        Integer[] numbers = new Integer[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        BiFunction<Integer[], Integer, String[]> reverseAndExtract = (nums, div) -> {
            Deque<Integer> extractedNumbers = new ArrayDeque<>();

            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] % div != 0) {
                    extractedNumbers.offer(nums[i]);
                }
            }

            String[] reversedNumbers = new String[extractedNumbers.size()];

            for (int i = 0; i < reversedNumbers.length; i++) {
                reversedNumbers[i] = extractedNumbers.poll().toString();
            }

            return reversedNumbers;
        };

        System.out.println(String.join(" ", reverseAndExtract.apply(numbers, divider)));
    }
}
