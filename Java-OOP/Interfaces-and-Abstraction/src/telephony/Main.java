package telephony;

import telephony.models.Smartphone;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> phoneNumbers = Arrays.asList(scanner.nextLine().split("\\s+"));
        List<String> sites = Arrays.asList(scanner.nextLine().split("\\s+"));

        Smartphone smartphone = new Smartphone(phoneNumbers, sites);
        System.out.println(smartphone.call() + smartphone.browse());
    }
}
