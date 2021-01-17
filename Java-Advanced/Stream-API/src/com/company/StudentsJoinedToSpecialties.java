package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsJoinedToSpecialties {
    private static final String END_COMMAND = "end";
    private static final String STUDENTS_COMMAND = "students";
    // Class in same file for judge testing purposes.
    private static class StudentSpecialty {
        private String specialtyName;
        private String facultyNumber;

        public StudentSpecialty(String specialtyName, String facultyNumber) {
            this.specialtyName = specialtyName;
            this.facultyNumber = facultyNumber;
        }

        public String getFacultyNumber() {
            return facultyNumber;
        }

        public String getSpecialtyName() {
            return specialtyName;
        }
    }

    private static class Student {
        private String name;
        private String facultyNumber;

        public Student(String name, String facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;
        }

        public String getFacultyNumber() {
            return facultyNumber;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> studentSpecialtyList = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        String[] input = reader.readLine().split(" ");

        while (!STUDENTS_COMMAND.equalsIgnoreCase(input[0])) {
            String specialtyName = input[0] + " " + input[1];
            String facultyNumber = input[2];
            StudentSpecialty studentSpecialty = new StudentSpecialty(specialtyName, facultyNumber);
            studentSpecialtyList.add(studentSpecialty);

            input = reader.readLine().split(" ");
        }

        input = reader.readLine().split(" ");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String facultyNumber = input[0];
            String studentName = input[1] + " " + input[2];
            Student student = new Student(studentName, facultyNumber);
            students.add(student);

            input = reader.readLine().split(" ");
        }

        studentSpecialtyList.stream()
                .collect(Collectors.joining())
    }
}
