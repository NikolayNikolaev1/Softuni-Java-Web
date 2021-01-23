package animals.models;

public class Kitten extends Cat {
    private static final String DEFAULT_KITTEN_GENDER = "Female";
    private static final String DEFAULT_KITTEN_SOUND = "Meow";

    public Kitten(String name, int age, String gender) {
        super(name, age, DEFAULT_KITTEN_GENDER);
    }

    @Override
    public String produceSound() {
        return DEFAULT_KITTEN_SOUND;
    }
}
