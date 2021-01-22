package card.enums;

public enum CardRank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    @Override
    public String toString() {
        return String.format("Ordinal value: %s; Name value: %s",
                this.ordinal(), this.name());
    }
}
