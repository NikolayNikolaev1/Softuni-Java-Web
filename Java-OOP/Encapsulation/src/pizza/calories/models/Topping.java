package pizza.calories.models;

import pizza.calories.enums.ToppingType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Topping {
    private static final double BASE_CALORIES_PER_GRAM = 2.0;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        boolean isValidType = Arrays.stream(ToppingType.values())
                .map(Enum::toString)
                .collect(Collectors.toList())
                .contains(toppingType);

        if (!isValidType) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50]", this.toppingType));
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingTypeModifier = ToppingType.valueOf(this.toppingType).getModifier();

        return (BASE_CALORIES_PER_GRAM * this.weight) * toppingTypeModifier;
    }
}
