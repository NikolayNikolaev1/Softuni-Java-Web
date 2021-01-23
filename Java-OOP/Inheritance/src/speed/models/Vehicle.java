package speed.models;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setFuel(double fuel) {
        this.fuel = fuel;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers){
        if (this.fuel >= this.fuelConsumption * kilometers) {
            this.fuel -= this.fuelConsumption * kilometers;
        }
    }
}
