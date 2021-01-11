package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    private static final String END_COMMAND = "end";
    private static final String VALID_INPUT_REGEX = "^(\\D+\\s{1,3})@(\\S\\D+\\s{1,3})(\\d+)\\s(\\d+)$";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();
        String input = reader.readLine();

        while (!END_COMMAND.equalsIgnoreCase(input)) {
            Matcher matcher = Pattern.compile(VALID_INPUT_REGEX).matcher(input);

            if (matcher.find()) {
                String singer = matcher.group(1).trim();
                String venue = matcher.group(2).trim();
                int ticketsPrice = Integer.parseInt(matcher.group(3));
                int ticketsCount = Integer.parseInt(matcher.group(4));
                // Check if current venue exists.
                if (venues.containsKey(venue)) {
                    // Check if current singer already exists.
                    if (venues.get(venue).containsKey(singer)) {
                        // Add the money to singer.
                        int money = venues.get(venue).get(singer) + ticketsCount * ticketsPrice;
                        venues.get(venue).put(singer, money);
                        input = reader.readLine();
                        continue;
                    }
                    // Creates a new singer and add it to the venue.
                    venues.get(venue).put(singer, ticketsCount * ticketsPrice);
                    input = reader.readLine();
                    continue;
                }
                // Create new venue and adds singer nad money made.
                Map<String, Integer> concert = new LinkedHashMap<>();
                concert.put(singer, ticketsCount * ticketsPrice);
                venues.put(venue, concert);
            }

            input = reader.readLine();
        }

        venues.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                    .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));

        });
    }
}
