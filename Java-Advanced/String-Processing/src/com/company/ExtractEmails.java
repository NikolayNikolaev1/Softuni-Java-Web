package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ExtractEmails {
    private static final String REGEX_PATTERN = "[a-zA-Z0-9][\\w-\\.]*[a-zA-Z0-9]@([a-zA-Z][a-zA-Z-]*\\.[a-zA-Z-]*[a-zA-Z])+";
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!END_COMMAND.equalsIgnoreCase(input)) {
            String[] inputArg = input.split(" |,|");

            for (String arg : inputArg) {
                if (Pattern.matches(REGEX_PATTERN, arg)) {
                    System.out.println(arg);
                }
            }

            input = reader.readLine();
        }
    }
}
