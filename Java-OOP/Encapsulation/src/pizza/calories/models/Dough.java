package pizza.calories.models;

import pizza.calories.enums.BakingTechnique;
import pizza.calories.enums.FlourType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Dough {
    private static final double BASE_CALORIES_PER_GRAM = 2.0;

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        boolean isValidType = Arrays.stream(FlourType.values())
                .map(Enum::toString)
                .collect(Collectors.toList())
                .contains(flourType.toUpperCase());

        if (!isValidType) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        boolean isValidTechnique = Arrays.stream(BakingTechnique.values())
                .map(Enum::toString)
                .collect(Collectors.toList())
                .contains(bakingTechnique.toUpperCase());

        if (!isValidTechnique) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        double flourTypeModifier = FlourType.valueOf(this.flourType.toUpperCase()).getModifier();
        double bakingTechniqueModifier = BakingTechnique.valueOf(this.bakingTechnique.toUpperCase()).getModifier();

        return (BASE_CALORIES_PER_GRAM * this.weight) * flourTypeModifier * bakingTechniqueModifier;
    }
}
