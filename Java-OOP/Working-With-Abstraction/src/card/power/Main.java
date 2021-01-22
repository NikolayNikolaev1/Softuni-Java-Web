package card.power;

import card.power.models.Card;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Exercise 3.
        Scanner scanner = new Scanner(System.in);
        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        Card card = new Card(cardRank, cardSuit);
        System.out.println(card.toString());
    }
}
