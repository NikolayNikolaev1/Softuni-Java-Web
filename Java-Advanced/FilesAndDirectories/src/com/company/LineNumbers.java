package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    private static final String INPUT_FILE_PATH = "Resources/inputLineNumbers.txt";
    private static final String OUTPUT_FILE_PATH = "Resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT_FILE_PATH))) {
            String line = reader.readLine();
            StringBuilder output = new StringBuilder();
            int lineCounter = 0;

            while (line != null) {
                lineCounter++;
                output.append(String.format("%d. %s%n", lineCounter, line));
                Files.writeString(Paths.get(OUTPUT_FILE_PATH), output, StandardCharsets.UTF_8);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
