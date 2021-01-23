package animals.models;

import animals.enums.ExceptionMessage;
import animals.enums.Gender;

public abstract class Animal {
    private String name;
    private int age;
    private Gender gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
        }

        this.age = age;
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
        }

        this.name = name;
    }

    private void setGender(String gender) {
        if (!gender.equalsIgnoreCase(Gender.FEMALE.name()) && !gender.equalsIgnoreCase(Gender.MALE.name())) {
            throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
        }

        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    protected abstract String produceSound();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + System.lineSeparator() +
                String.format("%s %s %s", this.name, this.age, this.gender.getCapitalizedValue()) + System.lineSeparator() +
                produceSound();
    }
}
