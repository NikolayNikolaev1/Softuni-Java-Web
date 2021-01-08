package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {
    private static final String SHARDS_MATERIAL = "shards";
    private static final String FRAGMENTS_MATERIAL = "fragments";
    private static final String MOTES_MATERIAL = "motes";
    private static final int MATERIAL_QUANTITY_NEEDED = 250;
    private static final int DEFAULT_QUANTITY = 0;
    private static final String LEGENDARY_ITEM_SHADOWMOURNE = "Shadowmourne";
    private static final String LEGENDARY_ITEM_VALANYR = "Valanyr";
    private static final String LEGENDARY_ITEM_DRAGONWRATH = "Dragonwrath";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> keyMaterials = new TreeMap<>();
        // Adding default key materials with 0 quantity for printing missing materials in output.
        obtainMaterial(keyMaterials, SHARDS_MATERIAL, DEFAULT_QUANTITY);
        obtainMaterial(keyMaterials, FRAGMENTS_MATERIAL, DEFAULT_QUANTITY);
        obtainMaterial(keyMaterials, MOTES_MATERIAL, DEFAULT_QUANTITY);

        Map<String, Integer> junkMaterials = new TreeMap<>();
        Optional<String> enoughMaterialsObtained = Optional.empty();

        // isEmpty() doesn't work in judge, switch with !isPresent() for tests..
        while (enoughMaterialsObtained.isEmpty()) {
            String[] input = reader.readLine().split(" ");

            for (int i = 0; i < input.length; i += 2) {
                int materialQuantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase(Locale.ROOT);
                // Checks for legendary item material.
                if (SHARDS_MATERIAL.equalsIgnoreCase(material) ||
                        FRAGMENTS_MATERIAL.equalsIgnoreCase(material) ||
                        MOTES_MATERIAL.equalsIgnoreCase(material)) {
                    // Get key material.
                    obtainMaterial(keyMaterials, material, materialQuantity);

                    // Checks if there are enough materials collected after every key material added.
                    enoughMaterialsObtained = keyMaterials.entrySet().stream()
                            .filter(e -> e.getValue() >= MATERIAL_QUANTITY_NEEDED)
                            .map(Map.Entry::getKey)
                            .findFirst();

                    if (enoughMaterialsObtained.isPresent()) {
                        break;
                    }
                    continue;
                }
                // Get junk material.
                obtainMaterial(junkMaterials, material, materialQuantity);
            }
        }

        switch (enoughMaterialsObtained.get().toLowerCase(Locale.ROOT)) {
            case SHARDS_MATERIAL:
                obtainLegendaryItem(keyMaterials, enoughMaterialsObtained.get(), LEGENDARY_ITEM_SHADOWMOURNE);
                break;
            case FRAGMENTS_MATERIAL:
                obtainLegendaryItem(keyMaterials, enoughMaterialsObtained.get(), LEGENDARY_ITEM_VALANYR);
                break;
            case MOTES_MATERIAL:
                obtainLegendaryItem(keyMaterials, enoughMaterialsObtained.get(), LEGENDARY_ITEM_DRAGONWRATH);
                break;
        }

        keyMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey().toLowerCase(Locale.ROOT), e.getValue()));

        junkMaterials.forEach((material, quantity) -> System.out.printf("%s: %d%n", material.toLowerCase(Locale.ROOT), quantity));

    }

    private static void obtainMaterial(Map<String, Integer> allMaterials, String material, int materialQuantity) {
        // Checks if material already exists.
        if (!allMaterials.containsKey(material)) {
            allMaterials.put(material, materialQuantity);
        } else {
            // Creates new material.
            int currentQuantity = allMaterials.get(material);
            allMaterials.put(material, currentQuantity + materialQuantity);
        }
    }

    private static void obtainLegendaryItem(Map<String, Integer> keyMaterials, String material, String legendaryItem) {
        // Removes the needed materials for the legendary item and prints output.
        int currentQuantity = keyMaterials.get(material);
        keyMaterials.put(material, currentQuantity - MATERIAL_QUANTITY_NEEDED);
        System.out.println(legendaryItem + " obtained!");
    }
}
