package vehicles;

import vehicles.interfaces.Vehicle;
import vehicles.models.Car;
import vehicles.models.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String carInput = reader.readLine();
        String truckInput = reader.readLine();

        Vehicle car = new Car(getVehicleProperties(carInput)[0], getVehicleProperties(carInput)[1]);
        Vehicle truck = new Truck(getVehicleProperties(truckInput)[0], getVehicleProperties(truckInput)[1]);

        int numberOfCommands = Integer.parseInt(reader.readLine());

        while (numberOfCommands-- != 0) {
            String[] commandArgs = reader.readLine().split(" ");

            if (commandArgs[0].equalsIgnoreCase("drive")) {
                if (commandArgs[1].equalsIgnoreCase("car")) {
                    System.out.println(car.drive(Double.parseDouble(commandArgs[2])));
                } else {
                    System.out.println(truck.drive(Double.parseDouble(commandArgs[2])));
                }
            } else {
                if (commandArgs[1].equalsIgnoreCase("car")) {
                    car.refuel(Double.parseDouble(commandArgs[2]));
                } else {
                    truck.refuel(Double.parseDouble(commandArgs[2]));
                }
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());

    }

    private static double[] getVehicleProperties(String vehicleInput) {
        String[] inputArgs = vehicleInput.split(" ");
        return new double[]{ Double.parseDouble(inputArgs[1]), Double.parseDouble(inputArgs[2])};
    }
}
