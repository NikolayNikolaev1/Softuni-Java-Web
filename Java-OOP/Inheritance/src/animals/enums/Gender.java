package animals.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String capitalizedValue;

    Gender(String capitalizedValue) {
        this.capitalizedValue = capitalizedValue;
    }

    public String getCapitalizedValue() {
        return capitalizedValue;
    }
}
