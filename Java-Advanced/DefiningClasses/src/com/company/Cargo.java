package com.company;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        setWeight(weight);
        setType(type);
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }
}
