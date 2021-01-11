package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {
    private static final String MISSING_NULL_STAT = "null";
    private static final String STAT_TYPE_HEALTH = "health";
    private static final int DEFAULT_HEALTH = 250;
    private static final String STAT_TYPE_DAMAGE = "damage";
    private static final int DEFAULT_DAMAGE = 45;
    private static final String STAT_TYPE_ARMOR = "armor";
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, List<Integer>>> dragons = new LinkedHashMap<>();
        int inputLength = Integer.parseInt(reader.readLine());

        for (int i = 0; i < inputLength; i++) {
            String[] input = reader.readLine().split(" ");
            String type = input[0];
            String name = input[1];
            int damage = assignStat(input[2], STAT_TYPE_DAMAGE);
            int health = assignStat(input[3], STAT_TYPE_HEALTH);
            int armor = assignStat(input[4], STAT_TYPE_ARMOR);
            // Check if dragon type already exists.
            if (dragons.containsKey(type)) {
                List<Integer> stats = Arrays.asList(damage, health, armor);
                dragons.get(type).put(name, stats);
                continue;
            }
            // Create new dragon type.
            List<Integer> stats = Arrays.asList(damage, health, armor);
            Map<String, List<Integer>> dragon = new TreeMap<>();
            dragon.put(name, stats);
            dragons.put(type, dragon);
        }

        dragons.forEach((dragonType, dragon) -> {
            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;
            // Get average of every stat.
            for (List<Integer> stats : dragon.values()) {
                avgDamage += stats.get(0);
                avgHealth += stats.get(1);
                avgArmor += stats.get(2);
            }

            avgDamage /= dragon.size();
            avgHealth /= dragon.size();
            avgArmor /= dragon.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    dragonType, avgDamage, avgHealth, avgArmor);

            dragon.forEach((dragonName, dragonStats) -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragonName, dragonStats.get(0), dragonStats.get(1), dragonStats.get(2));
            });
        });

    }

    private static int assignStat(String stat, String statType) {
        // Assigns default values to stats if they are missing.
        if (MISSING_NULL_STAT.equalsIgnoreCase(stat)) {
            switch (statType) {
                case STAT_TYPE_HEALTH:
                    return DEFAULT_HEALTH;
                case STAT_TYPE_DAMAGE:
                    return DEFAULT_DAMAGE;
                case STAT_TYPE_ARMOR:
                    return DEFAULT_ARMOR;
            }
        }

        return Integer.parseInt(stat);
    }
}
