package farm;

import farm.models.animals.*;
import farm.models.food.Food;
import farm.models.food.Meat;
import farm.models.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Stack;

public class Main {
    private static final String END_COMMAND = "END";
    private static final String CAT_TYPE = "cat";
    private static final String TIGER_TYPE = "tiger";
    private static final String MOUSE_TYPE = "mouse";
    private static final String ZEBRA_TYPE = "zebra";
    private static final String VEGETABLE_TYPE = "vegetable";
    private static final String MEAT_TYPE = "meat";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Animal> animalStack = new Stack<>();

        boolean inputFlag = true; // animal - true; fod - false

        while (true) {
            String input = reader.readLine();

            if (input.equalsIgnoreCase(END_COMMAND)) {
                break;
            }

            if (inputFlag) {
                String[] animalArgs = input.split(" ");
                String animalType = animalArgs[0];
                String animalName = animalArgs[1];
                double animalWeight = Double.parseDouble(animalArgs[2]);
                String animalLivingRegion = animalArgs[3];

                switch (animalType.toLowerCase(Locale.ROOT)) {
                    case CAT_TYPE:
                        String catBreed = animalArgs[4];
                        Cat cat = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                        animalStack.push(cat);
                        break;
                    case TIGER_TYPE:
                        Tiger tiger = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                        animalStack.push(tiger);
                        break;
                    case MOUSE_TYPE:
                        Mouse mouse = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                        animalStack.push(mouse);
                        break;
                    case ZEBRA_TYPE:
                        Zebra zebra = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                        animalStack.push(zebra);
                        break;
                }
                inputFlag = false;
            } else {
                String foodType = input.split(" ")[0];
                int foodQuantity = Integer.parseInt(input.split(" ")[1]);
                Food food;

                switch (foodType.toLowerCase(Locale.ROOT)) {
                    case VEGETABLE_TYPE:
                        food = new Vegetable(foodQuantity);
                        break;
                    case MEAT_TYPE:
                        food = new Meat(foodQuantity);
                        break;
                    default:
                        food = null;// compile check..
                        break;
                }

                Animal lastAnimal = animalStack.peek();
                lastAnimal.makeSound();
                lastAnimal.eat(food);
                inputFlag = true;
            }
        }

        for (Animal animal : animalStack) {
            System.out.println(animal.toString());
        }
    }
}
