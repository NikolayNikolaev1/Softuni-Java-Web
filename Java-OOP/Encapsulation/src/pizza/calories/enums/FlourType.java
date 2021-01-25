package pizza.calories.enums;

public enum FlourType {
    WHITE(1.5),
    WHOLEGRAIN(1.0);

    private final double modifier;

    FlourType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
