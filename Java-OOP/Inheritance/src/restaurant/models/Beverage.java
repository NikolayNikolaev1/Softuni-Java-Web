package restaurant.models;

import java.math.BigDecimal;

public class Beverage extends Product {
    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.setMilliliters(milliliters);
    }

    public double getMilliliters() {
        return milliliters;
    }

    private void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }
}
