package com.company;

import java.util.Scanner;

public class CountSubstringOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(" ");
        String searchString = scanner.nextLine();
        int counter = 0;

        for (String word : text) {
            int index = 0;

            while (index + searchString.length() - 1 < word.length()) {
                if (word.substring(index, index + searchString.length()).equalsIgnoreCase(searchString)) {
                    counter++;
                }

                index++;
            }
        }

        System.out.println(counter);
    }
}
