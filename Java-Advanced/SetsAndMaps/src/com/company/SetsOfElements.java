package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputCount = scanner.nextLine();
        int firstSetLength = Integer.parseInt(inputCount.split(" ")[0]);
        int secondSetLength = Integer.parseInt(inputCount.split(" ")[1]);
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        Set<String> repeatingNumbersSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            firstSet.add(scanner.nextLine());
        }

        for (int i = 0; i < secondSetLength; i++) {
            secondSet.add(scanner.nextLine());
        }

        for (String firstSetNum : firstSet) {
            for (String secondSetNum : secondSet) {
                if (firstSetNum.equals(secondSetNum)) {
                    repeatingNumbersSet.add(firstSetNum);
                }
            }
        }

        System.out.println(String.join(" ", repeatingNumbersSet));
    }
}
