package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer lengthCheck  =Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");

        BiPredicate<String, Integer> checkNameLength = (name, length) -> name.length() <= length;

        for (String name : names) {
            if (checkNameLength.test(name, lengthCheck)) {
                System.out.println(name);
            }
        }
    }
}
