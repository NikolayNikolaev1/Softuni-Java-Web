package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int logsCount = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> logsAggregator = new TreeMap<>();

        for (int i = 0; i < logsCount; i++) {
            String[] logArgs = scanner.nextLine().split(" ");
            String ip = logArgs[0];
            String user = logArgs[1];
            int duration = Integer.parseInt(logArgs[2]);

            if (!logsAggregator.containsKey(user)) {
                // Creates a new user
                Map<String, Integer> logDuration = new TreeMap<>();
                logDuration.put(ip, duration);
                logsAggregator.put(user, logDuration);
                continue;
            }

            if (!logsAggregator.get(user).containsKey(ip)) {
                // Creates a new ip with duration to an existing user.
                Map<String, Integer> userLogs = logsAggregator.get(user);
                userLogs.put(ip, duration);
                logsAggregator.put(user, userLogs);
                continue;
            }

            // Add duration to an existing users' ip
            Integer currentDuration = logsAggregator.get(user).get(ip);
            logsAggregator.get(user).put(ip, currentDuration + duration);
        }

        printLogs(logsAggregator);
    }

    private static void printLogs(Map<String, Map<String, Integer>> logsAggregator) {
        for (Map.Entry<String, Map<String, Integer>> userLogsEntry : logsAggregator.entrySet()) {
            int durationSum = 0;
            String result = "";


            for (Map.Entry<String, Integer> logDurationEntry : userLogsEntry.getValue().entrySet()) {
                durationSum += logDurationEntry.getValue();

                result = userLogsEntry.getValue().keySet()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
            }

            System.out.printf("%s: %d [%s]%n", userLogsEntry.getKey(), durationSum, result);
        }
    }
}
