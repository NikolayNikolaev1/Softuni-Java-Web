package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupByGroup {
    // Class in same file for judge testing purposes.
    public static class Student {
        private String name;
        private int group;

        public Student(String name, int group) {
            this.name = name;
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public int getGroup() {
            return group;
        }
    }

    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String[] input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String studentName = input[0] + " " + input[1];
            int studentGroup = Integer.parseInt(input[2]);
            Student student = new Student(studentName, studentGroup);
            students.add(student);

            input = reader.readLine().split(" ");
        }

        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup))
                .forEach((key, value) -> {
                    System.out.printf("%d - ", key);
                    System.out.println(value.stream()
                            .map(Student::getName)
                            .collect(Collectors.joining(", ")));
                });
    }
}
