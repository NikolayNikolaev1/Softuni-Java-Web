package military.elite.models.soldiers;

import military.elite.interfaces.Soldier;

public abstract class SoldierImpl implements Soldier {
    private int id;
    private String firstName;
    private String lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
