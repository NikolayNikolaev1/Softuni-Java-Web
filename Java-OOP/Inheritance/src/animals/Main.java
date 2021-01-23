package animals;

import animals.enums.AnimalType;
import animals.enums.ExceptionMessage;
import animals.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String END_COMMAND = "Beast!";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();
        // Input
        readNextAnimalCommands(reader, animals);
        // Output
        animals.forEach(animal -> System.out.println(animal.toString()));
    }

    private static void readNextAnimalCommands(BufferedReader reader, List<Animal> animals)  throws IOException{
        String animalTypeCommand = reader.readLine();

        while (!END_COMMAND.equalsIgnoreCase(animalTypeCommand)) {
            String[] animalArgs = reader.readLine().split("\\s+");

            try {
                Animal animal = createAnimal(animalTypeCommand, animalArgs);
                animals.add(animal);
                animalTypeCommand = reader.readLine();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                animalTypeCommand = reader.readLine();
            }
        }
    }

    private static Animal createAnimal(String animalTypeCommand, String... animalArgs) {
        Animal animal;
        AnimalType animalType = AnimalType.valueOf(animalTypeCommand.toUpperCase());
        String name = animalArgs[0];
        int age = Integer.parseInt(animalArgs[1]);
        String gender = animalArgs[2];

        switch (animalType) {
            case DOG:
                animal = new Dog(name, age, gender);
                break;
            case FROG:
                animal = new Frog(name, age, gender);
                break;
            case CAT:
                animal = new Cat(name, age, gender);
                break;
            case TOMCAT:
                animal = new Tomcat(name, age, gender);
                break;
            case KITTEN:
                animal = new Kitten(name, age, gender);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
        }

        return animal;
    }
}
