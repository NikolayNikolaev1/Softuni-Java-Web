package person.models;

import person.interfaces.Birthable;

public class Pet implements Birthable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.setName(name);
        this.setBirthDate(birthDate);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
