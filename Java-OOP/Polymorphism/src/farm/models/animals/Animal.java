package farm.models.animals;

import farm.models.food.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    public Animal(String animalName, String animalType, double animalWeight, int foodEaten) {

    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    private void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    private void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }


    protected abstract void makeSound();

    protected abstract void eat(Food food);
}
