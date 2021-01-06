package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PoisonousPlants {
    private static final int MAX_PLANT_PESTICIDE = 1000000000;

    public static void main(String[] args)  {
        // Not using arrays and lists for this exercise..
        Scanner scanner = new Scanner(System.in);
        int plantsCount = Integer.parseInt(scanner.nextLine());
        Deque<Integer> plants = new ArrayDeque<>();
        int daysCount = 0;
        boolean isPlantDead = true;

        for (int i = 0; i < plantsCount; i++) {
            plants.offer(scanner.nextInt());
        }

        while (isPlantDead) {
            isPlantDead = false;
//            int leftPlantPesticide = MAX_PLANT_PESTICIDE;
            int leftPlantPesticide = 0;
            int initialPlantsCount = plants.size();

            for (int i = 0; i < initialPlantsCount; i++) {
                if (i == 0) {
                    leftPlantPesticide = plants.poll();
                    plants.offer(leftPlantPesticide);
                    continue;
                }

                leftPlantPesticide = plants.poll();
                int rightPlantPesticide = plants.getLast();

                if (rightPlantPesticide >= leftPlantPesticide) {
                    plants.offer(leftPlantPesticide);
                } else {
                    isPlantDead = true;
                }
            }

            daysCount++;
        }

        System.out.println(daysCount);
    }
}
