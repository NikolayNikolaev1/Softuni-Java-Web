package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private static final String DEFAULT_MISSING_DATA = "n/a";

    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;
    private int weight;
    private String color;

    public Car(String model, double fuelAmount, double fuelCost) {
        setModel(model);
        setFuelAmount(fuelAmount);
        setFuelCost(fuelCost);
        setDistanceTraveled(0);
    }

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double firstTirePressure, int firstTireAge, double secondTirePressure, int secondTireAge,
               double thirdTirePressure, int thirdTireAge, double fourthTirePressure, int fourthTireAge) {
        setModel(model);
        Engine engine = new Engine(engineSpeed, enginePower);
        setEngine(engine);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        setCargo(cargo);
        Tire firstTire = new Tire(firstTirePressure, firstTireAge);
        Tire secondTire = new Tire(secondTirePressure, secondTireAge);
        Tire thirdTire = new Tire(thirdTirePressure, thirdTireAge);
        Tire fourthTire = new Tire(fourthTirePressure, fourthTireAge);
        tires = new ArrayList<>();
        tires.addAll(Arrays.asList(firstTire, secondTire, thirdTire, fourthTire));
    }

    public Car(String model, Engine engine, int weight, String color) {
        setModel(model);
        setEngine(engine);
        setWeight(weight);
        setColor(color);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, DEFAULT_MISSING_DATA);
    }

    public Car(String model, Engine engine, String color) {
        // Using -1 for missing integer values. Later will change them into 'n/a'.
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine) {
        // Using -1 for missing integer values. Later will change them into 'n/a'.
        this(model, engine, -1, DEFAULT_MISSING_DATA);
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    private void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    private void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    private void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Cargo getCargo() {
        return cargo;
    }

    private void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    private void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public void drive(int amountOfKm) {
        double neededFuelAmount = amountOfKm * this.fuelCost;
        if (neededFuelAmount <= this.fuelAmount) {
            setFuelAmount(this.fuelAmount -= neededFuelAmount);
            setDistanceTraveled(this.distanceTraveled += amountOfKm);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.getModel(), this.getFuelAmount(), this.getDistanceTraveled());
    }

    public String withEngineDetailsToString() {
        String weightToString;
        if (this.weight == -1) {
            weightToString = "n/a";
        } else {
            weightToString = Integer.toString(this.weight);
        }

        return String.format("%s:%n%s%nWeight: %s%nColor: %s",
                this.getModel(), this.engine.toString(), weightToString, this.color);
    }
}
