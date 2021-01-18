package com.company;

public class Child {
    private String name;
    private String birthday;

    public Child(String name, String birthday) {
        setName(name);
        setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.getName(), this.getBirthday());
    }
}
