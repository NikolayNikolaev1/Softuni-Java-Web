package farm.models.animals;

import farm.models.food.Food;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.setBreed(breed);
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void eat(Food food) {

    }
}
