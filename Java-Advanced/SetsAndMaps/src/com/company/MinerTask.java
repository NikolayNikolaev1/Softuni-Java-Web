package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    private static final String STOP_COMMAND = "stop";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resourceQuantities = new LinkedHashMap<>();

        String resource = scanner.nextLine();

        while (!STOP_COMMAND.equalsIgnoreCase(resource)) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceQuantities.containsKey(resource)) {
                resourceQuantities.put(resource, quantity);
                resource = scanner.nextLine();
                continue;
            }

            resourceQuantities.put(resource, resourceQuantities.get(resource) + quantity);
            resource = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourceQuantities.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
