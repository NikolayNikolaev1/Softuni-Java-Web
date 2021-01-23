package restaurant.models;

import java.math.BigDecimal;

public class Dessert extends Food {
    private double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.setCalories(calories);
    }

    public double getCalories() {
        return calories;
    }

    private void setCalories(double calories) {
        this.calories = calories;
    }
}
