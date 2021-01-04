package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByEmailDomain {
    private static final String END_COMMAND = "end";
    private static final String GMAIL_DOMAIN = "@gmail.com";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> students = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String studentName = input[0] + " " + input[1];
            String studentEmail = input[2];
            students.put(studentEmail, studentName);

            input = reader.readLine().split(" ");
        }

        students.entrySet().stream()
                .filter(s -> s.getKey().contains(GMAIL_DOMAIN))
                .forEach(s -> System.out.println(s.getValue()));
    }
}
