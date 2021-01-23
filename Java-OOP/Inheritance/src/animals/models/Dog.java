package animals.models;

public class Dog extends Animal {
    private static final String DEFAULT_DOG_SOUND = "Woof!";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return DEFAULT_DOG_SOUND;
    }
}
