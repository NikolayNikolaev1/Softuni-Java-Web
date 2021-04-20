package farm.models.animals;

import farm.models.food.Food;
import farm.models.food.Vegetable;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %f, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), this.breed, super.getAnimalWeight(), this.getLivingRegion(), super.getFoodEaten());
    }
}
