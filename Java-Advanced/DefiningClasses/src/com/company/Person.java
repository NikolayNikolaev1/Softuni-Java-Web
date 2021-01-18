package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;
    private String birthdate;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public Person(String name) {
        setName(name);
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getBirthdate() {
        return birthdate;
    }

    private void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        children.add(child);
    }

    @Override
    public String toString() {
        String pokemons = this.getPokemons().stream()
                .map(Pokemon::toString)
                .collect(Collectors.joining(""));
        String parents = this.getParents().stream()
                .map(Parent::toString)
                .collect(Collectors.joining(""));
        String children = this.getChildren().stream()
                .map(Child::toString)
                .collect(Collectors.joining(""));

        String company = "";
        if (this.getCompany() != null) {
            company = this.getCompany().toString();
        }

        String car = "";
        if (this.getCar() != null) {
            car = this.getCar().toStringModelSpeed();
        }

        return String.format("%s%nCompany:%n%sCar:%n%sPokemon:%n%sParents:%n%sChildren:%n%s",
                this.getName(), company, car, pokemons, parents, children);
    }
}
