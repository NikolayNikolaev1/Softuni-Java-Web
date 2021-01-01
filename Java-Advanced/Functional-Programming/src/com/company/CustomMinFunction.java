package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArg = reader.readLine().split(" ");
        Integer[] numbers = new Integer[inputArg.length];

        for (int i = 0; i < inputArg.length; i++) {
            numbers[i] = Integer.parseInt(inputArg[i]);
        }

        Function<Integer[], Integer> function = nums -> {
            Arrays.sort(nums, Integer::compareTo);

            return nums[0];
        };

        System.out.println(function.apply(numbers));
    }
}
