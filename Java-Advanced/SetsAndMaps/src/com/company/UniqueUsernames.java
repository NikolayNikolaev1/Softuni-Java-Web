package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputCount = Integer.parseInt(scanner.nextLine());
        Set<String> nameSet = new LinkedHashSet<String>();

        for (int i = 1; i <= inputCount; i++) {
            nameSet.add(scanner.nextLine());
        }

        for (String name : nameSet) {
            System.out.println(name);
        }
    }
}
