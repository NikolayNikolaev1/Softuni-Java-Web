package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStudents {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();

        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String firstName = input[0];
            String lastName = input[1];
            students.add(firstName + " " + lastName);

            input = reader.readLine().split(" ");
        }

        students.stream()
                .sorted(Comparator.reverseOrder())
                .sorted(Comparator.comparing(a -> a.split(" ")[1]))
                .forEach(System.out::println);
    }
}
