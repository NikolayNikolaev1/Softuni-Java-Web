package com.company;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = setName(name);
        this.age = setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private String setName(String name) {
        return name;
    }

    private int setAge(int age) {
        return age;
    }
}
