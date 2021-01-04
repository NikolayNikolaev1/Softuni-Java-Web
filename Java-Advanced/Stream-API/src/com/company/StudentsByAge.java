package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByAge {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> students = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String name = input[0] + " " + input[1];
            Integer age = Integer.parseInt(input[2]);
            students.put(name, age);

            input = reader.readLine().split(" ");
        }

        students.entrySet().stream()
                .filter(s -> s.getValue() >= 18 && s.getValue() <= 24)
                .forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));
    }
}
