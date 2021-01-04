package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentsEnrolled {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> students = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String facNumber = input[0];
            List<String> studentGrades = new ArrayList<>();

            for (int i = 1; i < input.length; i++) {
                studentGrades.add(input[i]);
            }

            students.put(facNumber, studentGrades);

            input = reader.readLine().split(" ");
        }

        students.entrySet().stream()
                .filter(s -> s.getKey().endsWith("14") || s.getKey().endsWith("15"))
                .forEach(s -> System.out.println(String.join(" ", s.getValue())));
    }
}
