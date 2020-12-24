package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    private static final String STOP_COMMAND = "stop";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emailsCollection = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!STOP_COMMAND.equalsIgnoreCase(name)) {
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsCollection.put(name, email);
            }

            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emailsCollection.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
