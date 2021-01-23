package animals.models;

public class Tomcat extends Cat {
    private static final String DEFAULT_TOMCAT_GENDER = "Male";
    private static final String DEFAULT_TOMCAT_SOUND = "MEOW";

    public Tomcat(String name, int age, String gender) {
        super(name, age, DEFAULT_TOMCAT_GENDER);
    }

    @Override
    public String produceSound() {
        return DEFAULT_TOMCAT_SOUND;
    }
}
