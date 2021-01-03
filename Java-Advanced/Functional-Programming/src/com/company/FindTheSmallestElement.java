package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\W+");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        Function<List<Integer>, Integer> getSmallestIndex = nums -> {
            int smallestNum = nums.get(0);
            for (Integer num : nums) {
                if (num < smallestNum) {
                    smallestNum = num;
                }
            }

            return nums.indexOf(smallestNum);
        };

        System.out.println(getSmallestIndex.apply(numbers));
    }
}
