package pizza.calories;

import pizza.calories.models.Dough;
import pizza.calories.models.Pizza;
import pizza.calories.models.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            runCommands(reader);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runCommands(BufferedReader reader) throws IOException {
        String[] pizzaArgs = reader.readLine().split("\\s+");
        String[] doughArgs = reader.readLine().split("\\s+");

        Pizza pizza = createPizza(pizzaArgs);
        Dough dough = createDough(doughArgs);
        pizza.setDough(dough);

        String[] commandArgs = reader.readLine().split("\\s+");

        while (!END_COMMAND.equalsIgnoreCase(commandArgs[0])) {
            Topping topping = createTopping(commandArgs);
            pizza.addTopping(topping);

            commandArgs = reader.readLine().split("\\s+");
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }

    private static Pizza createPizza(String... pizzaArgs) {
        String name = pizzaArgs[1];
        int numberOfToppings = Integer.parseInt(pizzaArgs[2]);

        return new Pizza(name, numberOfToppings);
    }

    private static Dough createDough(String... doughArgs) {
        String flourType = doughArgs[1];
        String bakingTechnique = doughArgs[2];
        double weight = Double.parseDouble(doughArgs[3]);

        return new Dough(flourType, bakingTechnique, weight);
    }

    private static Topping createTopping(String... toppingArgs) {
        String toppingType = toppingArgs[1];
        double weigh = Double.parseDouble(toppingArgs[2]);

        return new Topping(toppingType, weigh);
    }
}
