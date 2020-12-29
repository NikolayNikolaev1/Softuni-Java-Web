package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UserLogs {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        String inputLine = scanner.nextLine();

        while (!END_COMMAND.equalsIgnoreCase(inputLine)) {
            String ip = inputLine.split(" ")[0].split("=")[1];
            String user = inputLine.split(" ")[2].split("=")[1];

            if (!logs.containsKey(user)) {
                // Creates new user entry
                Map<String, Integer> logsCount = new LinkedHashMap<>();
                logsCount.put(ip, 1);
                logs.put(user, logsCount);

                inputLine = scanner.nextLine();
                continue;
            }

            if (!logs.get(user).containsKey(ip)) {
                // Creates new ip entry for existing user
                Map<String, Integer> userLogs = logs.get(user);
                userLogs.put(ip, 1);
                logs.put(user, userLogs);

                inputLine = scanner.nextLine();
                continue;
            }

            // Adds another count to the existing ip of the user.
            Map<String, Integer> userLogs = logs.get(user);
            userLogs.put(ip, userLogs.get(ip) + 1);
            logs.put(user, userLogs);


            inputLine = scanner.nextLine();
        }

        printUserLogs(logs);
    }

    private static void printUserLogs(Map<String, Map<String, Integer>> logs) {
        for (Map.Entry<String, Map<String, Integer>> log : logs.entrySet()) {
            System.out.printf("%s:%n", log.getKey());
            // Joins the KeyValuePairs of the map with ", ". Didn't want to use stream, but couldn't find another solution.
            String formattedOutput = log.getValue()
                    .entrySet()
                    .stream()
                    .map(e -> e.getKey() + " => " + e.getValue())
                    .collect(Collectors.joining(", "));
            System.out.printf("%s.%n", formattedOutput);
        }
    }
}
