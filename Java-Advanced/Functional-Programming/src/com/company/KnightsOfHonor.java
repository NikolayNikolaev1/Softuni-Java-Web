package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Consumer<String> consumer = names -> Arrays.asList(names.split(" "))
                .forEach(name -> System.out.printf("Sir %s%n", name));

        consumer.accept(input);
    }
}
