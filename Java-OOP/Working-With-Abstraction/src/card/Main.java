package card;

import card.enums.CardRank;
import card.enums.CardSuit;

import java.util.Scanner;

public class Main {
    private static final String CARD_SUITS_HEADLINE = "Card Suits:";
    private static final String CARD_RANKS_HEADLINE = "Card Ranks:";
    private static final String CARD_SUITS_COMMAND = "Card Suits";
    private static final String CARD_RANKS_COMMAND = "Card Ranks";

    public static void main(String[] args) {
        // Exercise 1 and 2.
        Scanner scanner = new Scanner(System.in);
        String inputCommand = scanner.nextLine();

        runCommand(inputCommand);
    }

    private static void runCommand(String commandName) {
        switch (commandName) {
            case CARD_SUITS_COMMAND:
                System.out.println(CARD_SUITS_HEADLINE);
                for (CardSuit suit : CardSuit.values())
                    System.out.println(suit.toString());
                break;
            case CARD_RANKS_COMMAND:
                System.out.println(CARD_RANKS_HEADLINE);
                for (CardRank rank : CardRank.values())
                    System.out.println(rank.toString());
                break;
        }
    }
}
