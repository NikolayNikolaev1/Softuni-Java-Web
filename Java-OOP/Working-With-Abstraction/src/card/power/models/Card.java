package card.power.models;

import card.power.enums.Rank;
import card.power.enums.Suit;

public class Card {
    private Rank rank;
    private Suit suit;
    private int power;

    public Card(String rank, String suit) {
        this.setRank(rank);
        this.setSuit(suit);
        this.setPower();
    }

    private void setRank(String rank) {
        this.rank = Rank.valueOf(rank);
    }

    private void setSuit(String suit) {
        this.suit = Suit.valueOf(suit);
    }

    private void setPower() {
        this.power = this.rank.getPower() + this.suit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank, this.suit, this.power);
    }
}
