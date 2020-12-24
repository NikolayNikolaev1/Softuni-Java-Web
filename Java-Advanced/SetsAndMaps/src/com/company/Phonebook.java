package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private static final String SEARCH_COMMAND = "search";
    private static final String STOP_COMMAND = "stop";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        String[] input = scanner.nextLine().split("-");

        while (!SEARCH_COMMAND.equalsIgnoreCase(input[0])) {
            String name = input[0];
            String phoneNumber = input[1];
            phonebook.put(name, phoneNumber);

            input = scanner.nextLine().split("-");
        }

        String searchName = scanner.nextLine();

        while (!STOP_COMMAND.equalsIgnoreCase(searchName)) {
            if (!phonebook.containsKey(searchName)) {
                System.out.printf("Contact %s does not exist.%n", searchName);
                searchName = scanner.nextLine();
                continue;
            }

            String phoneNumber = phonebook.get(searchName);
            System.out.printf("%s -> %s%n", searchName, phoneNumber);

            searchName = scanner.nextLine();
        }

    }
}
