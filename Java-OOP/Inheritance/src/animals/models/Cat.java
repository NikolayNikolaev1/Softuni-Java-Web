package animals.models;

public class Cat extends Animal {
    private static final String DEFAULT_CAT_SOUND = "Meow meow";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return DEFAULT_CAT_SOUND;
    }
}
