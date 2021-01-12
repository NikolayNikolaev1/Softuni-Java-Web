package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MatchPhoneNumbers {
    private static final String REGEX_PATTERN = "^\\+359( |-)2\\1\\d{3}\\1\\d{4}$";
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!END_COMMAND.equalsIgnoreCase(input)) {
            if (Pattern.matches(REGEX_PATTERN, input)) {
                System.out.println(input);
            }

            input = reader.readLine();
        }
    }
}
