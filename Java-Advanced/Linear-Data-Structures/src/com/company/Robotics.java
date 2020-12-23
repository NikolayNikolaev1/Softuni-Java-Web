package com.company;

import java.util.*;

public class Robotics {
    private static final String END_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsInput = scanner.nextLine().split(";");
        String currentTime = scanner.nextLine();
        Deque<String> availableRobots = new ArrayDeque<>();
        List<String> processingRobots = new ArrayList<>();
        Deque<String> productQueue = new ArrayDeque<>();
        boolean hasInputEnded = false;

        for (String robot : robotsInput) {
            availableRobots.offer(robot);
        }

        String product = scanner.nextLine();

        while (product != null) {
            currentTime = processTime(currentTime, 1); // Moves time by 1 second.
            oneSecondWorkLoop(currentTime, product, processingRobots, availableRobots, productQueue);


            if (!hasInputEnded) {
                product = scanner.nextLine();
                if (END_COMMAND.equalsIgnoreCase(product)) {
                    hasInputEnded = true;
                    product = productQueue.poll();
                }
            } else {
                product = productQueue.poll();
            }
        }
    }

    private static void oneSecondWorkLoop(String currentTime,
                                          String currentProduct,
                                          List<String> processingRobots,
                                          Deque<String> availableRobots,
                                          Deque<String> productQueue) {
        List<String> finishedProcessRobots = new ArrayList<String>();
        for (String robot : processingRobots) {
            if (robot.split("-")[2].equals(currentTime)) {
                availableRobots.offer(robot);
                finishedProcessRobots.add(robot);
            }
        }
        processingRobots.removeAll(finishedProcessRobots);

        if (!availableRobots.isEmpty()) {
            String[] robot = availableRobots.pop().split("-");
            String robotName = robot[0];
            String robotProcessTime = robot[1];

            // Add a robot that is currently processing with calculated process finish time.
            String estimatedRobotFinishProcessTime = processTime(currentTime, Integer.parseInt(robotProcessTime));
            processingRobots.add(robotName + "-" + robotProcessTime + "-" + estimatedRobotFinishProcessTime);


            System.out.printf("%s - %s [%s]%n", robotName, currentProduct, currentTime);
        } else {
            // Queues products if there are no available robots at the moment.
            productQueue.offer(currentProduct);
        }

    }

    private static String processTime(String startingTime, int processSeconds) {
        int hours = Integer.parseInt(startingTime.split(":")[0]);
        int minutes = Integer.parseInt(startingTime.split(":")[1]);
        int seconds = Integer.parseInt(startingTime.split(":")[2]);

        int secondsToAdd = (seconds + processSeconds) % 60;
        int minutesToAdd = (seconds + processSeconds) / 60;
        int newMinutes = minutes + minutesToAdd;
        int hoursToAdd = (minutes + minutesToAdd) / 60;

        if (hoursToAdd > 0) {
            newMinutes = (minutes + minutesToAdd) % 60;
        }

        return String.format("%s:%s:%s",
                leadingZero(hours + hoursToAdd),
                leadingZero(newMinutes),
                leadingZero(secondsToAdd));
    }

    private static String leadingZero(int number) {
        if (number < 10) {
            return String.format("0%d", number);
        }

        return String.valueOf(number);
    }
}
