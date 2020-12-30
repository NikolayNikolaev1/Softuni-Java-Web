package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MergeTwoFiles {
    private static final String FIRST_FILE_PATH = "Resources/inputOne.txt";
    private static final String SECOND_FILE_PATH = "Resources/inputTwo.txt";
    private static final String OUTPUT_FILE_PATH = "Resources/output.txt";

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FIRST_FILE_PATH))) {
            String line = reader.readLine();

            while (line != null) {
                output.append(String.format("%s%n", line));
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(SECOND_FILE_PATH))) {
            String line = reader.readLine();

            while (line != null) {
                output.append(String.format("%s%n", line));
                line = reader.readLine();
            }

            Files.writeString(Paths.get(OUTPUT_FILE_PATH), output, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
