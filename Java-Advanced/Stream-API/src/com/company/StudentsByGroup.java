package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByGroup {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> students = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String name = input[0] + " " + input[1];
            String group = input[2];
            students.put(name, group);

            input = reader.readLine().split(" ");
        }

        students.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().split(" ")[0]))
                .filter(entry -> entry.getValue().equals("2"))
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}
