package military.elite.models.soldiers;

import military.elite.enums.Corps;
import military.elite.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends SoldierImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
