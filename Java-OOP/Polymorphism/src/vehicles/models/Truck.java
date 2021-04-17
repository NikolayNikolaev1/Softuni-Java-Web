package vehicles.models;

import vehicles.interfaces.Vehicle;

public class Truck implements Vehicle {
    static final double FUEL_CONSUMPTION_INCREASE = 1.6;

    private double fuelQuantity;
    private double fuelConsumption;

    public Truck(double fuelQuantity, double fuelConsumption) {
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
            return "Truck needs refueling";
        }

        this.fuelQuantity -= neededFuel;
        return String.format("Truck travelled %.0f km", distance);
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += (liters * 95) / 100;
    }
}
