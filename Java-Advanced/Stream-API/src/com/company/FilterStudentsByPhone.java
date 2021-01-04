package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByPhone {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> students = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String studentName = input[0] + " " + input[1];
            String studentPhone = input[2];
            students.put(studentPhone, studentName);

            input = reader.readLine().split(" ");
        }

        students.entrySet().stream()
                .filter(s -> s.getKey().startsWith("02") || s.getKey().startsWith("+3592"))
                .forEach(s -> System.out.println(s.getValue()));
    }
}
