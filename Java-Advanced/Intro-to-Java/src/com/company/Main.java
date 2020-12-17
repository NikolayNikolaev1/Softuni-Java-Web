package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rectangleArea(scanner);

    }

    private static void rectangleArea(Scanner scanner) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        double sum = a * b;

        System.out.printf("%.2f%n", sum);
    }

    private static void triangleArea(Scanner scanner) {
        
    }
}
