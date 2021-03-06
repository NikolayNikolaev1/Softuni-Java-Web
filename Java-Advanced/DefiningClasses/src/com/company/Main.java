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
    private static final String COMPANY_INFORMATION = "company";
    private static final String POKEMON_INFORMATION = "pokemon";
    private static final String PARENTS_INFORMATION = "parents";
    private static final String CHILDREN_INFORMATION = "children";
    private static final String CAR_INFORMATION = "car";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Each exercise has its own method. Call the method name to do the exercise.
        familyTree((reader));
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

    private static void google(BufferedReader reader) throws IOException {
        List<Person> people = new ArrayList<>();
        String[] input = reader.readLine().split("\\s+");

        while (!END_COMMAND.equalsIgnoreCase(input[0])) {
            String personName = input[0];
            Person person;

            Optional<Person> doesPersonExists = people.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(personName))
                    .findFirst();

            if (doesPersonExists.isPresent()) {
                // Search if person already exists.
                person = doesPersonExists.get();
            } else {
                // Create new person.
                person = new Person(personName);
                people.add(person);
            }

            String informationData = input[1];

            switch (informationData) {
                case COMPANY_INFORMATION:
                    String companyName = input[2];
                    String department = input[3];
                    double salary = Double.parseDouble(input[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case POKEMON_INFORMATION:
                    String pokemonName = input[2];
                    String pokemonType = input[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person.addPokemon(pokemon);
                    break;
                case PARENTS_INFORMATION:
                    String parentName = input[2];
                    String parentBirthday = input[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    person.addParent(parent);
                    break;
                case CHILDREN_INFORMATION:
                    String childName = input[2];
                    String childBirthday = input[3];
                    Child child = new Child(childName, childBirthday);
                    person.addChild(child);
                    break;
                case CAR_INFORMATION:
                    String carModel = input[2];
                    int carSpeed = Integer.parseInt(input[3]);
                    Car car = new Car(carModel, carSpeed);
                    person.setCar(car);
                    break;
            }

            input = reader.readLine().split("\\s+");
        }

        String searchPersonName = reader.readLine();

        people.stream()
                .filter(p -> p.getName().equalsIgnoreCase(searchPersonName))
                .forEach(p -> System.out.println(p.toString()));
    }

    private static void familyTree(BufferedReader reader) throws IOException {
        // FIXME: 19-Jan-21 
        List<FamilyTreePerson> people = new ArrayList<>();
        String[] personInput = reader.readLine().split("\\s+");
        FamilyTreePerson mainPerson;

        if (personInput.length == 2) {
            // Get main person first and last names.
            String firstName = personInput[0];
            String lastName = personInput[1];
            mainPerson = new FamilyTreePerson(firstName, lastName);
        } else {
            // Get main person birthdate.
            String birthdate = personInput[0];
            mainPerson = new FamilyTreePerson(birthdate);
        }

        people.add(mainPerson);

        String[] inputLine = reader.readLine().split("-");

        while (!END_COMMAND.equalsIgnoreCase(inputLine[0])) {
            if (inputLine.length == 2) {
                // Get parent <-> child connection.
                String[] parentArg = inputLine[0].split("\\s+");
                String[] childArg = inputLine[1].split("\\s+");

                FamilyTreePerson parent = parseFamilyTreePerson(parentArg, people);
                FamilyTreePerson child = parseFamilyTreePerson(childArg, people);

                parent.addFamilyMember(child, "child");
                child.addFamilyMember(parent, "parent");
            } else {
                // Get name <-> birthdate connection.
                String personFirstName = inputLine[0].split("\\s+")[0];
                String personLastName = inputLine[0].split("\\s+")[1];
                String personBirthdate = inputLine[0].split("\\s+")[2];

                Optional<FamilyTreePerson> currentPerson = people.stream()
                        .filter(p -> p.getFirstName().equals(personFirstName) && p.getLastName().equals(personLastName)
                                || p.getBirthdate().equals(personBirthdate))
                        .findFirst();

                if (currentPerson.isPresent()) {
                    currentPerson.get().setFirstName(personFirstName);
                    currentPerson.get().setLastName(personLastName);
                    currentPerson.get().setBirthdate(personBirthdate);
                }
            }


            inputLine = reader.readLine().split("-");
        }

        System.out.println(mainPerson.toString());
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

    private static FamilyTreePerson parseFamilyTreePerson(String[] personArg, List<FamilyTreePerson> people) {
        FamilyTreePerson person;

        if (personArg.length == 2) {
            // Find/Create person with name.
            String parentFirstName = personArg[0];
            String parentLastName = personArg[1];

            Optional<FamilyTreePerson> doesPersonExists = people.stream()
                    .filter(p -> p.getFirstName().equals(parentFirstName) && p.getLastName().equals(parentLastName))
                    .findFirst();

            if (doesPersonExists.isPresent()) {
                // Search if person already exists.
                person = doesPersonExists.get();
            } else {
                // Create new person.
                person = new FamilyTreePerson(parentFirstName, parentLastName);
                people.add(person);
            }
        } else {
            // Find/Create person with birthdate
            String parentBirthdate = personArg[0];

            Optional<FamilyTreePerson> doesPersonExists = people.stream()
                    .filter(p -> p.getBirthdate().equals(parentBirthdate))
                    .findFirst();

            if (doesPersonExists.isPresent()) {
                // Search if person already exists.
                person = doesPersonExists.get();
            } else {
                // Create new person.
                person = new FamilyTreePerson(parentBirthdate);
                people.add(person);
            }
        }

        return person;
    }

}
