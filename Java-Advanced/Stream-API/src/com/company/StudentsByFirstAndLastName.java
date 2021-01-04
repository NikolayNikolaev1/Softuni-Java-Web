package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByFirstAndLastName {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();

        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String name = input[0] + " " + input[1];
            students.add(name);

            input = reader.readLine().split(" ");
        }

        students.stream()
                .filter(s -> s.split(" ")[1].compareTo(s.split(" ")[0]) > 0)
                .forEach(System.out::println);
    }
}
