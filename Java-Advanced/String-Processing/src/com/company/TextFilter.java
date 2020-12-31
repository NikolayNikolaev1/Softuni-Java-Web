package com.company;

import java.util.Scanner;

public class TextFilter {
    private static final String CENSORING = "*";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWords) {
            text = text.replaceAll(word, CENSORING.repeat(word.length())); // JAVA 11
        }

        System.out.println(text);
    }
}
