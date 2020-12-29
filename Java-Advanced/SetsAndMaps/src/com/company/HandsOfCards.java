package com.company;

import java.util.*;

public class HandsOfCards {
    private static final String END_COMMAND = "JOKER";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();
        String inputLine = scanner.nextLine();

        while (!END_COMMAND.equalsIgnoreCase(inputLine)) {
            String playerName = inputLine.split(":")[0];
            String[] playerCards = inputLine.split(":")[1].trim().split(", ");

            if (players.containsKey(playerName)) {
                Collections.addAll(players.get(playerName), playerCards);
                inputLine = scanner.nextLine();
                continue;
            }
            Set<String> playerHand = new HashSet<>(Arrays.asList(playerCards));
            players.put(playerName, playerHand);

            inputLine = scanner.nextLine();
        }

        printPlayerScores(players);
    }

    private static void printPlayerScores(Map<String, Set<String>> players) {
        for (Map.Entry<String, Set<String>> player : players.entrySet()) {
            int playerValue = 0;

            for (String card : player.getValue()) {
                char cardPower = card.charAt(0);
                char cardType = card.charAt(card.length() - 1); // Hardcode for card 10*
                int powerValue = 0;
                int typeValue = 0;

                switch (Character.toUpperCase(cardPower)) {
                    case 'J':
                        powerValue = 11;
                        break;
                    case 'Q':
                        powerValue = 12;
                        break;
                    case 'K':
                        powerValue = 13;
                        break;
                    case 'A':
                        powerValue = 14;
                        break;
                    case '1':
                        powerValue = 10;
                        break;
                    default:
                        powerValue = Character.getNumericValue(cardPower);
                        break;
                }

                switch (Character.toUpperCase(cardType)) {
                    case 'S':
                        typeValue = 4;
                        break;
                    case 'H':
                        typeValue = 3;
                        break;
                    case 'D':
                        typeValue = 2;
                        break;
                    case 'C':
                        typeValue = 1;
                        break;
                }
                playerValue += powerValue * typeValue;
            }

            System.out.printf("%s: %d%n", player.getKey(), playerValue);
        }
    }
}
