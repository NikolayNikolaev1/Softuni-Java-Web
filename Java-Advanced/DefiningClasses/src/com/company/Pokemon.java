package com.company;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        setName(name);
        setElement(element);
        setHealth(health);
    }

    public Pokemon(String name, String element) {
        setName(name);
        setElement(element);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    private void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public void loseHealth() {
        this.health -= 10;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.getName(), this.getElement());
    }
}
