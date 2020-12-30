package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCapitals {
    private static final String INPUT_FILE_PATH = "Resources/input.txt";
    private static final String OUTPUT_FILE_PATH = "Resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT_FILE_PATH))) {
            String line = reader.readLine();
            StringBuilder output = new StringBuilder();

            while (line != null) {
                for (char letter : line.toCharArray()) {
                    output.append(Character.toUpperCase(letter));
                }

                output.append(String.format("%n"));
                Files.writeString(Paths.get(OUTPUT_FILE_PATH), output, StandardCharsets.UTF_8);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
