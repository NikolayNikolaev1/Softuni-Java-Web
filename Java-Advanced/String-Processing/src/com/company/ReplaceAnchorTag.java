package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceAnchorTag {
    private static final String OPENING_ANCHOR_TAG_REGEX = "<a[\\w\\W]+?(>)";
    private static final String CLOSING_ANCHOR_TAG_REGEX = "<\\/a>";
    private static final String OPENING_URL_TAG = "";
    private static final String CLOSING_URL_TAG = "[/URL]";
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = reader.readLine();

        while (!END_COMMAND.equalsIgnoreCase(input)) {
            Matcher matcher = Pattern.compile(OPENING_ANCHOR_TAG_REGEX).matcher(input);
            if (matcher.find()) {
                input = input.replaceAll("<a", "[URL");
                input = matcher.group(1);
                System.out.println(input);
            }

            input = input.replaceAll(CLOSING_ANCHOR_TAG_REGEX, CLOSING_URL_TAG);
            sb.append(input + "\n");

            input = reader.readLine();
        }

        System.out.println(sb);
    }
}
