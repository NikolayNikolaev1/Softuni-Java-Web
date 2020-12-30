package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class WordCount {
    private static final String WORDS_FILE_PATH = "Resources/words.txt";
    private static final String TEXT_FILE_PATH = "Resources/text.txt";
    private static final String OUTPUT_FILE_PATH = "Resources/results.txt";

    public static void main(String[] args) {
        Set<String> words = new LinkedHashSet<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(WORDS_FILE_PATH))) {
            String[] input = reader.readLine().split(" ");
            words.addAll(Arrays.asList(input));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(TEXT_FILE_PATH))) {
            String[] inputText = reader.readLine().split(" ");
            StringBuilder output = new StringBuilder();

            for (String word : words) {
                int counter = 0;

                for (String inputWord : inputText) {
                    if (word.equals(inputWord)) {
                        counter++;
                    }
                }

                output.append(String.format("%s - %d%n", word, counter));
            }

            Files.writeString(Paths.get(OUTPUT_FILE_PATH), output, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
