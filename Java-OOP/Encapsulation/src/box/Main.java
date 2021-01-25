package box;

import box.models.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Box box = createBox(scanner);
            calculateBoxFormulas(box);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Box createBox(Scanner scanner) throws IllegalArgumentException {
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        return new Box(length, width, height);
    }

    private static void calculateBoxFormulas(Box box) {
        System.out.printf("Surface Area - %.2f%s", box.calculateSurfaceArea(), System.lineSeparator());
        System.out.printf("Lateral Surface Area - %.2f%s", box.calculateLateralSurfaceArea(), System.lineSeparator());
        System.out.printf("Volume - %.2f%s", box.calculateVolume(), System.lineSeparator());
    }
}
