package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] range = reader.readLine().split(" ");
        String option = reader.readLine();

        Predicate<Integer> isEven = num -> num % 2 == 0;

        switch (option) {
            case "even" :
                for (int i = Integer.parseInt(range[0]); i <= Integer.parseInt(range[1]); i++) {
                    if (isEven.test(i)) {
                        System.out.printf("%d ", i);
                    }
                }
                break;
            case "odd" :
                for (int i = Integer.parseInt(range[0]); i <= Integer.parseInt(range[1]); i++) {
                    if (!isEven.test(i)) {
                        System.out.printf("%d ", i);
                    }
                }
                break;
        }
    }
}
