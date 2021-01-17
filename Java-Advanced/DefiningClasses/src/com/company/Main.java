package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    private static final String END_COMMAND = "end";
    private static final String FRAGILE_COMMAND = "fragile";
    private static final String FLAMABLE_COMMAND = "flamable";
    private static final String TOURNAMENT_COMMAND = "tournament";
    private static final String POKEMON_ELEMENT_ELECTRICITY = "electricity";
    private static final String POKEMON_ELEMENT_FIRE = "fire";
    private static final String POKEMON_ELEMENT_WATER = "water";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Each exercise has its own method. Call the method name to do the exercise.
        pokemonTrainer((reader));
    }

    private static void opinionPoll(BufferedReader reader) throws IOException {
        List<Person> people = new ArrayList<>();
        int inputLength = Integer.parseInt(reader.readLine());

        while (inputLength-- > 0) {
            String[] inputArgs = reader.readLine().split(" ");
            String name = inputArgs[0];
            int age = Integer.parseInt(inputArgs[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(p -> p.getAge() > 30)
                .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
    }

    private static void companyRoster(BufferedReader reader) throws IOException {
        int inputLength = Integer.parseInt(reader.readLine());
        List<Department> departments = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        while (inputLength-- > 0) {
            String[] inputArgs = reader.readLine().split(" ");
            String name = inputArgs[0];
            double salary = Double.parseDouble(inputArgs[1]);
            String position = inputArgs[2];
            String departmentName = inputArgs[3];
            Employee employee;
            Department department;

            var currentDepartment = departments.stream().filter(d -> d.getName().equals(departmentName)).findFirst();

            // TODO: make isEmpty()
            if (!currentDepartment.isPresent()) {
                department = new Department(departmentName);
                departments.add(department);
            } else {
                department = currentDepartment.get();
            }

            switch (inputArgs.length) {
                case 5:
                    if (inputArgs[4].matches("\\d+")) {
                        // Missing email.
                        int age = Integer.parseInt(inputArgs[4]);
                        employee = new Employee(name, salary, position, departmentName, age);
                    } else {
                        // Missing age.
                        String email = inputArgs[4];
                        employee = new Employee(name, salary, position, departmentName, email);
                    }
                    break;
                case 6:
                    String email = inputArgs[4];
                    int age = Integer.parseInt(inputArgs[5].trim());
                    employee = new Employee(name, salary, position, departmentName, email, age);
                    break;
                default:
                    // case 4:
                    employee = new Employee(name, salary, position, departmentName);
                    break;
            }

            employees.add(employee);
            department.addEmployee(employee);
        }


        var highestAvgSalaryDepartment = departments.stream()
                .sorted(Comparator.comparingDouble(Department::getAverageSalary).reversed())
                .findFirst();

        if (highestAvgSalaryDepartment.isPresent()) {
            System.out.printf("Highest Average Salary: %s%n", highestAvgSalaryDepartment.get().getName());
            employees.stream()
                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                    .filter(e -> e.getDepartment().equals(highestAvgSalaryDepartment.get().getName()))
                    .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));

        }
    }

    private static void speedRacing(BufferedReader reader) throws IOException {
        int carsCount = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        while (carsCount-- > 0) {
            String[] inputArgs = reader.readLine().split("\\s+");
            String model = inputArgs[0];
            double fuelAmount = Double.parseDouble(inputArgs[1]);
            double fuelCost = Double.parseDouble(inputArgs[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            cars.add(car);
        }

        String[] command = reader.readLine().split("\\s+");

        while (!END_COMMAND.equalsIgnoreCase(command[0])) {
            String driveModel = command[1];
            int driveAmount = Integer.parseInt(command[2]);

            cars.stream()
                    .filter(c -> c.getModel().equals(driveModel))
                    .findFirst()
                    .ifPresent(c -> c.drive(driveAmount));

            command = reader.readLine().split("\\s+");
        }

        cars.forEach(c -> System.out.println(c.toString()));
    }

    private static void rawData(BufferedReader reader) throws IOException {
        List<Car> cars = new ArrayList<>();
        int carsCount = Integer.parseInt(reader.readLine());

        while (carsCount-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double firstTirePressure = Double.parseDouble(input[5]);
            int firstTireAge = Integer.parseInt(input[6]);
            double secondTirePressure = Double.parseDouble(input[5]);
            int secondTireAge = Integer.parseInt(input[6]);
            double thirdTirePressure = Double.parseDouble(input[5]);
            int thirdTireAge = Integer.parseInt(input[6]);
            double fourthTirePressure = Double.parseDouble(input[5]);
            int fourthTireAge = Integer.parseInt(input[6]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, firstTirePressure, firstTireAge,
                    secondTirePressure, secondTireAge, thirdTirePressure, thirdTireAge, fourthTirePressure, fourthTireAge);
            cars.add(car);
        }

        String command = reader.readLine();

        switch (command) {
            case FRAGILE_COMMAND:
                cars.stream()
                        .filter(c -> c.getCargo().getType().equals("fragile")
                                && c.getTires().stream().anyMatch(t -> t.getPressure() < 1))
                        .forEach(c -> System.out.println(c.getModel()));
                break;

            case FLAMABLE_COMMAND:
                cars.stream()
                        .filter(c -> c.getCargo().getType().equals("flamable")
                                && c.getEngine().getPower() > 250)
                        .forEach(c -> System.out.println(c.getModel()));
                break;
        }
    }

    private static void carSalesman(BufferedReader reader) throws IOException {
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        // Create engines.
        int engineCount = Integer.parseInt(reader.readLine());

        while (engineCount-- > 0) {
            Engine engine;
            String[] engineInputArgs = reader.readLine().split("\\s+");
            String model = engineInputArgs[0];
            int power = Integer.parseInt(engineInputArgs[1]);

            switch (engineInputArgs.length) {
                case 3:
                    if (engineInputArgs[2].matches("\\d+")) {
                        int displacement = Integer.parseInt(engineInputArgs[2]);
                        engine = new Engine(model, power, displacement);
                    } else {
                        String efficiency = engineInputArgs[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;
                case 4:
                    int displacement = Integer.parseInt(engineInputArgs[2]);
                    String efficiency = engineInputArgs[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
                default:
                    // case 2:
                    engine = new Engine(model, power);
                    break;
            }

            engines.add(engine);
        }
        // Create cars
        int carsCount = Integer.parseInt(reader.readLine());

        while (carsCount-- > 0) {
            Car car;
            String[] carInputArgs = reader.readLine().split("\\s+");
            String model = carInputArgs[0];
            String engineModel = carInputArgs[1];
            Engine engine = engines.stream()
                    .filter(e -> e.getModel().equalsIgnoreCase(engineModel))
                    .findAny()
                    .get(); // Not using isPresent() because there will be no wrong data in the input / faster and easier code..

            switch (carInputArgs.length) {
                case 3:
                    if (carInputArgs[2].matches("\\d+")) {
                        int weight = Integer.parseInt(carInputArgs[2]);
                        car = new Car(model, engine, weight);
                    } else {
                        String color = carInputArgs[2];
                        car = new Car(model, engine, color);
                    }
                    break;
                case 4:
                    int weight = Integer.parseInt(carInputArgs[2]);
                    String color = carInputArgs[3];
                    car = new Car(model, engine, weight, color);
                    break;
                default:
                    car = new Car(model, engine);
                    break;
            }

            cars.add(car);
        }

        cars.forEach(c -> System.out.println(c.withEngineDetailsToString()));
    }

    private static void pokemonTrainer(BufferedReader reader) throws IOException {
        List<Trainer> trainers = new ArrayList<>();
        String[] input = reader.readLine().split("\\W+");
        // Create trainers and pokemons.
        while (!TOURNAMENT_COMMAND.equalsIgnoreCase(input[0])) {
            String trainerName = input[0];
            String pokemonName = input[1];
            String pokemonElement = input[2];
            int pokemonHealth = Integer.parseInt(input[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            var currentTrainer = trainers.stream()
                    .filter(t -> t.getName().equalsIgnoreCase(trainerName)).findFirst();

            if (currentTrainer.isPresent()) {
                // Find existing trainer and add pokemon to his collection.
                currentTrainer.get().catchPokemon(pokemon);
                input = reader.readLine().split("\\W+");
                continue;
            }
            // Create new trainer.
            Trainer trainer = new Trainer(trainerName);
            trainers.add(trainer);
            trainer.catchPokemon(pokemon);

            input = reader.readLine().split("\\W+");
        }

        String command = reader.readLine();

        while (!END_COMMAND.equalsIgnoreCase(command)) {
            switch (command.toLowerCase()) {
                case POKEMON_ELEMENT_ELECTRICITY:
                    pokemonTournament(trainers, POKEMON_ELEMENT_ELECTRICITY);
                    break;
                case POKEMON_ELEMENT_FIRE:
                    pokemonTournament(trainers, POKEMON_ELEMENT_FIRE);
                    break;
                case POKEMON_ELEMENT_WATER:
                    pokemonTournament(trainers, POKEMON_ELEMENT_WATER);
                    break;
            }

            command = reader.readLine();
        }

        trainers.forEach(Trainer::removeDeadPokemon);

        trainers.stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                .forEach(t -> System.out.println(t.toString()));
    }

    private static void pokemonTournament(List<Trainer> trainers, String pokemonElement) {
        trainers.stream()
                .filter(t -> t.getPokemons().stream()
                        .anyMatch(p -> p.getElement().equalsIgnoreCase(pokemonElement)))
                .forEach(Trainer::receiveBadge);

        trainers.stream()
                .filter(t -> t.getPokemons().stream()
                        .noneMatch(p -> p.getElement().equalsIgnoreCase(pokemonElement)))
                .forEach(t -> t.getPokemons().forEach(Pokemon::loseHealth));
    }


}
