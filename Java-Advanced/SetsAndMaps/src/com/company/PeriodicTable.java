package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLinesCount = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 1; i <= inputLinesCount; i++) {
            // Creates array of elements from the inputLine and adds it in the elements set.
            elements.addAll(Arrays.asList(scanner.nextLine().split(" ")));
        }

        System.out.println(String.join(" ", elements));
    }
}
