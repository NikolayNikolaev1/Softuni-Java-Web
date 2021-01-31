package person;

import person.interfaces.Birthable;
import person.interfaces.Identifiable;
import person.interfaces.Person;
import person.models.Citizen;
import person.models.Pet;
import person.models.Rebel;
import person.models.Robot;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArgs = scanner.nextLine().split("\\s+");
        List<Birthable> birthableList = new ArrayList<>();

        while (!END_COMMAND.equalsIgnoreCase(inputArgs[0])) {
            String commandName = inputArgs[0];

            switch (commandName) {
                case "Citizen":
                    String citizenName = inputArgs[1];
                    int citizenAge = Integer.parseInt(inputArgs[2]);
                    String citizenId = inputArgs[3];
                    String citizenBirthdate = inputArgs[4];
                    Birthable citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthdate);
                    birthableList.add(citizen);
                    break;
                case "Pet":
                    String petName = inputArgs[1];
                    String petBirthdate = inputArgs[2];
                    Birthable pet = new Pet(petName, petBirthdate);
                    birthableList.add(pet);
                    break;
                case "Robot":
                    String robotModel = inputArgs[1];
                    String robotId = inputArgs[2];
                    Robot robot = new Robot(robotModel, robotId);
                    break;
            }

            inputArgs = scanner.nextLine().split("\\s+");
        }

        String year = scanner.nextLine();

        birthableList.stream()
                .filter(b -> b.getBirthDate().split("/")[2].equalsIgnoreCase(year))
                .forEach(b -> System.out.println(b.getBirthDate()));
    }


    private static void firstExercise() {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Person.class)) {
            Method[] fields = Person.class.getDeclaredMethods();
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            Person person = new Citizen(name, age);
            System.out.println(fields.length);
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }

    private static void secondExercise() {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            methods = Identifiable.class.getDeclaredMethods();
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();
            Identifiable identifiable = new Citizen(name, age, id, birthDate);
            Birthable birthable = new Citizen(name, age, id, birthDate);
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
        }
    }

    private static void thirdExercise() {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (peopleCount-- > 0) {
            String[] personArgs = scanner.nextLine().split("\\s+");
            String name = personArgs[0];
            int age = Integer.parseInt(personArgs[1]);

            if (personArgs.length == 4) {
                String id = personArgs[2];
                String birthdate = personArgs[3];

                Person citizen = new Citizen(name, age, id, birthdate);
                people.add(citizen);
            } else if (personArgs.length == 3) {
                String group = personArgs[2];

                Person rebel = new Rebel(name, age, group);
                people.add(rebel);
            }
        }

        String input = scanner.nextLine();

        while (!END_COMMAND.equalsIgnoreCase(input)) {
            String name = input;
            Optional<Person> doesPersonExist = people
                    .stream()
                    .filter(p -> p.getName().equalsIgnoreCase(name))
                    .findFirst();

            if (!doesPersonExist.isPresent()) {
                input = scanner.nextLine();
                continue;
            }

            doesPersonExist.get().buyFood();
            input = scanner.nextLine();
        }

        long foodPurchased = people.stream()
                .mapToInt(Person::getFood)
                .summaryStatistics()
                .getSum();

        System.out.println(foodPurchased);
    }
}
