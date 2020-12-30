package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    private static final String FILE_PATH = "Resources/input.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            String line = reader.readLine();

            while (line != null) {
                int sum = 0;

                for (char letter : line.toCharArray()) {
                    sum += letter;
                }

                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
