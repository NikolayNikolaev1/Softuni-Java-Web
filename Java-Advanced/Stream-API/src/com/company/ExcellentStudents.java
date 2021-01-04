package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcellentStudents {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String studentName = input[0] + " " + input[1];
            List<Integer> studentGrades = new ArrayList<>();

            for (int i = 2; i < input.length; i++) {
                studentGrades.add(Integer.parseInt(input[i]));
            }

            students.put(studentName, studentGrades);

            input = reader.readLine().split(" ");
        }

        students.entrySet().stream()
                .filter(s -> s.getValue().contains(6))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
