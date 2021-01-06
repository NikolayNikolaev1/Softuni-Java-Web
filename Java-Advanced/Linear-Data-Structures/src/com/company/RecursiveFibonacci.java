package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        // FIXME: 05-Jan-21 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());

        Integer start = 1;
        Function<Integer, Integer> getFibonacci = n -> {
            return 1 + n;
        };


        System.out.println(getFibonacci.apply(input - 1) + getFibonacci.apply(input - 2));
    }
}
