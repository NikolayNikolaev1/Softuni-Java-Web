package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        setName(name);
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void catchPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void receiveBadge() {
        this.numberOfBadges += 1;
    }

    public void removeDeadPokemon() {
        List<Pokemon> deadPokemons = this.getPokemons().stream()
                .filter(p -> p.getHealth() <= 0)
                .collect(Collectors.toList());

        this.getPokemons().removeAll(deadPokemons);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.getPokemons().size());
    }
}
