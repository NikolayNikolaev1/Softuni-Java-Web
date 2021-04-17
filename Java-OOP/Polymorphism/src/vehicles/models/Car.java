package vehicles.models;

import vehicles.interfaces.Vehicle;

import java.text.DecimalFormat;

public class Car implements Vehicle {
    static final double FUEL_CONSUMPTION_INCREASE = 0.9;

    private double fuelQuantity;
    private double fuelConsumption;

    public Car(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    @Override
    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    @Override
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance) {
        double neededFuel = distance * (this.fuelConsumption + FUEL_CONSUMPTION_INCREASE);

        if (this.fuelQuantity < neededFuel) {
            return "Car needs refueling";
        }

        this.fuelQuantity -= neededFuel;
        DecimalFormat format = new DecimalFormat("^###.#");
        return String.format("Car travelled %f km", distance);
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }
}
