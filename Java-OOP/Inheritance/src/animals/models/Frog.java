package animals.models;

public class Frog extends Animal {
    private static final String DEFAULT_FROG_SOUND = "Ribbit";

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return DEFAULT_FROG_SOUND;
    }
}
