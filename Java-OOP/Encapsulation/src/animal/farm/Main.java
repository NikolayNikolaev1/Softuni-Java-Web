package animal.farm;

import animal.farm.models.Chicken;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        try {
            createChicken(name, age);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createChicken(String name, int age) throws IllegalArgumentException {
        Chicken chicken = new Chicken(name, age);
        System.out.println(chicken.toString());
    }
}
