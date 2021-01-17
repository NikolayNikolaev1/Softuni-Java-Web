package com.company;

public class Engine {
    private static final String DEFAULT_MISSING_DATA = "n/a";

    private int speed;
    private int power;
    private String model;
    private int displacement;
    private String efficiency;

    public Engine(int speed, int power) {
        setSpeed(speed);
        setPower(power);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        setModel(model);
        setPower(power);
        setDisplacement(displacement);
        setEfficiency(efficiency);
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, DEFAULT_MISSING_DATA);
    }

    public Engine(String model, int power, String efficiency) {
        // Using -1 for missing integer values. Later will change them into 'n/a'.
        this(model, power, -1, efficiency);
    }

    public Engine(String model, int power) {
        // Using -1 for missing integer values. Later will change them into 'n/a'.
        this(model, power, -1, DEFAULT_MISSING_DATA);
    }

    public int getSpeed() {
        return speed;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public int getDisplacement() {
        return displacement;
    }

    private void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    private void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacementToString;
        if (this.displacement == -1) {
            displacementToString = "n/a";
        } else {
            displacementToString = Integer.toString(this.displacement);
        }

        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s",
                this.model, this.power, displacementToString, this.efficiency);
    }
}
