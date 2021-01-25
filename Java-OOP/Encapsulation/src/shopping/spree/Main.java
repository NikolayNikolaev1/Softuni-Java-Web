package shopping.spree;

import shopping.spree.models.Person;
import shopping.spree.models.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleInput = reader.readLine().split(";");
        String[] productsInput = reader.readLine().split(";");

        List<Person> people = createAllPeople(peopleInput);
        List<Product> products = createAllProducts(productsInput);

        runBuyCommands(reader, products, people);

        people.forEach(p -> System.out.println(p.toString()));
    }

    private static List<Person> createAllPeople(String... peopleInput) {
        List<Person> personList = Arrays.stream(peopleInput)
                .map(Main::tryCreatePerson)
                .collect(Collectors.toList());
        personList.remove(null);

        return personList;
    }

    private static List<Product> createAllProducts(String... productsInput) {
        List<Product> productList = Arrays.stream(productsInput)
                .map(Main::tryCreateProduct)
                .collect(Collectors.toList());
        productList.remove(null);

        return productList;
    }

    private static void runBuyCommands(BufferedReader reader,
                                       List<Product> productList, List<Person> personList) throws IOException {
        String[] commandArgs = reader.readLine().split("\\s+");

        while (!END_COMMAND.equalsIgnoreCase(commandArgs[0])) {
            String personName = commandArgs[0];
            String productName = commandArgs[1];



            Optional<Product> currentProduct = productList
                    .stream()
                    .filter(p -> p.getName().equalsIgnoreCase(productName))
                    .findFirst();

            if (currentProduct.isPresent()) {
                Product product = currentProduct.get();

                boolean currentPerson = personList
                        .stream()
                        .anyMatch(p -> p.getName().equalsIgnoreCase(personName));

                if (currentPerson) {
                    personList
                            .stream()
                            .filter(p -> p.getName().equalsIgnoreCase(personName))
                            .forEach(p -> p.buyProduct(product));
                }
            }

            commandArgs = reader.readLine().split("\\s+");
        }
    }

    private static Person tryCreatePerson(String person) {
        String[] personArgs = person.split("=");
        String name = personArgs[0];
        double money = Double.parseDouble(personArgs[1]);

        try {
            return new Person(name, money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Product tryCreateProduct(String product) {
        String[] productArgs = product.split("=");
        String name = productArgs[0];
        double cost = Double.parseDouble(productArgs[1]);

        try {
            return new Product(name, cost);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
