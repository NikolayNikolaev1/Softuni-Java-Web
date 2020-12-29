package com.company;

import java.util.*;

public class PopulationCounter {
    private static final String END_COMMAND = "report";
    // Doesn't pass in softuni judge, but can't find the bugs..
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> countryAggregatedData = new LinkedHashMap<>();
        Map<String, Integer> countryTotalPopulation = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();

        while (!END_COMMAND.equalsIgnoreCase(inputLine)) {
            String city = inputLine.split("\\|")[0];
            String country = inputLine.split("\\|")[1];
            int population = Integer.parseInt(inputLine.split("\\|")[2]);

            if (!countryAggregatedData.containsKey(country)) {
                // Creates a new country entry if current country does not exist.
                Map<String, Integer> cityData = new LinkedHashMap<>();
                cityData.put(city, population);
                countryAggregatedData.put(country, cityData);

                inputLine = scanner.nextLine();
                continue;
            }

            // Adds city population to an existing country.
            Map<String, Integer> countryCities = countryAggregatedData.get(country);
            countryCities.put(city, population);
            countryAggregatedData.put(country, countryCities);

            inputLine = scanner.nextLine();
        }

        // Saves country with their total population in descending order.
        for (Map.Entry<String, Map<String, Integer>> countryEntry : countryAggregatedData.entrySet()) {
            int totalPopulation = 0;

            for (Map.Entry<String, Integer> cityPopulationsEntry : countryEntry.getValue().entrySet()) {
                // Don't want to use stream..
                totalPopulation += cityPopulationsEntry.getValue();
            }

            countryTotalPopulation.put(countryEntry.getKey(), totalPopulation);
        }


        Map<String, Integer> reverseSortedMap = new LinkedHashMap<>();

        countryTotalPopulation.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));



        for (Map.Entry<String, Integer> countryPopulationEntry : reverseSortedMap.entrySet()) {
            String country = countryPopulationEntry.getKey();
            System.out.printf("%s (total population: %d)%n", country, countryPopulationEntry.getValue());


            Map<String, Integer> reverseCountryMap = new LinkedHashMap<>();

            countryAggregatedData.get(country).entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseCountryMap.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Integer> cityPopulationEntry : reverseCountryMap.entrySet()) {
                System.out.printf("=>%s: %d%n", cityPopulationEntry.getKey(), cityPopulationEntry.getValue());
            }
        }

    }
}
