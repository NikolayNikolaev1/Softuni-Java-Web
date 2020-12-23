package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Robotics {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsInput = scanner.nextLine().split(";");
        String currentTime = scanner.nextLine();
        ArrayDeque<String> availableRobots = new ArrayDeque<>();
        List<String> processingRobots = new ArrayList<>();
        ArrayDeque<String> productQueue = new ArrayDeque<>();

        for (String robot : robotsInput) {
            availableRobots.offer(robot);
        }

        String product = scanner.nextLine();

        while (!END_COMMAND.equalsIgnoreCase(product)) {
            for (String robot : processingRobots) {
                if (robot.split("-")[2] == currentTime) {

                }
            }

            if (availableRobots.size() != 0) {
                String[] robot = availableRobots.pop().split("-");
                String robotName = robot[0];
                String robotProcessTime = robot[1];
                currentTime = processTime(currentTime, 1);

                // Add a robot that is currently processing with calculated process finish time.
                String estimatedRobotFinishProcessTime = processTime(currentTime, Integer.parseInt(robotProcessTime));
                processingRobots.add(robotName + "-" + robotProcessTime + "-" + estimatedRobotFinishProcessTime);


                System.out.printf("%s - %s [%s]", robotName, product, estimatedRobotFinishProcessTime);
            } else {
                // Queues products if there are no available moments at the moment.
                productQueue.offer(product);
            }


            product = scanner.nextLine();
        }
    }

    private static void productProcessing(ArrayDeque<String> robots) {

    }

    private static String processTime(String startingTime, int processSeconds) {
        int hours = Integer.parseInt(startingTime.split(":")[0]);
        int minutes = Integer.parseInt(startingTime.split(":")[1]);
        int seconds = Integer.parseInt(startingTime.split(":")[2]);

        //test
        int secondsToAdd = (seconds + processSeconds) % 60;
        int minutesToAdd = (seconds + processSeconds) / 60;
        int hoursToAdd = (minutes + minutesToAdd) / 60;

        if (hoursToAdd > 0) {
            minutesToAdd = (minutes + minutesToAdd) % 60;
        }
        //test

//        if (seconds + processSeconds > 59) {
//            int hoursToAdd = 0;
//            int minutesToAdd = (seconds + processSeconds) / 60;
//            int secondsToAdd = (seconds + processSeconds) % 60;
//
//            if (minutesToAdd > 59) {
//                // If seconds ot process are more than 3600'.
//                hoursToAdd = minutesToAdd / 60;
//                minutesToAdd %= 60;
//            }
//
//
//            if (minutes == 59) {
//                if (hours == 23) {
//
//                    return String.format("%s:%s:%s",
//                            leadingZero(0), leadingZero(0), leadingZero(0));
//                }
//
//                return String.format("%s:%s:%s",
//                        leadingZero(hours + 1), leadingZero(0), leadingZero(0));
//            }
//
//            return String.format("%s:%s:%s",
//                    leadingZero(hours + hoursToAdd),
//                    leadingZero(minutes + minutesToAdd),
//                    leadingZero(seconds + secondsToAdd));
//        }

        return String.format("%s:%s:%s",
                leadingZero(hours + hoursToAdd),
                leadingZero(minutes + minutesToAdd),
                leadingZero(secondsToAdd));
    }

    private static String leadingZero(int number) {
        if (number < 10) {
            return String.format("0%d", number);
        }

        return String.valueOf(number);
    }

}
