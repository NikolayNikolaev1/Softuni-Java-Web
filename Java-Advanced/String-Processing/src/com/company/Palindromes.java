package com.company;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[ ,.?!]+");
        Set<String> palindromes = new TreeSet<>();

        for (String word : input) {
            StringBuilder sb = new StringBuilder(word);

            if (word.equals(sb.reverse().toString())) {
                palindromes.add(word);
            }
        }

        System.out.printf("[%s]", String.join(", ", palindromes));
    }
}
