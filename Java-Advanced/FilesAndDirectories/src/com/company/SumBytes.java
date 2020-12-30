package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    private static final String FILE_PATH = "Resources/input.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            String line = reader.readLine();
            long sum = 0;

            while (line != null) {
                for (char letter : line.toCharArray()) {
                    sum += letter;
                }

                line = reader.readLine();
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
