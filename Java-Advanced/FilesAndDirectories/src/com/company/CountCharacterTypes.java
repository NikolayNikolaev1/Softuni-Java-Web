package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes {
    private static final String FILE_PATH = "Resources/input.txt";
    private static final String OUTPUT_FILE_PATH = "Resources/output.txt";
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final Set<Character> PUNCTUATIONS = new HashSet<>(Arrays.asList('!', ',', '.', '?'));

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            String line = reader.readLine();
            int vowelCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            while (line != null) {
                for (char letter : line.toCharArray()) {
                    if (VOWELS.contains(letter)) {
                        vowelCount++;
                    } else if (PUNCTUATIONS.contains(letter)) {
                        punctuationCount++;
                    } else if (letter != ' ') {
                        consonantsCount++;
                    }
                }

                line = reader.readLine();
            }

            String output = String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d%n",
                    vowelCount, consonantsCount, punctuationCount);
            System.out.printf("Vowels: %d%n", vowelCount);
            System.out.printf("Consonants: %d%n", consonantsCount);
            System.out.printf("Punctuation: %d%n", punctuationCount);

            Files.writeString(Paths.get(OUTPUT_FILE_PATH), output, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
