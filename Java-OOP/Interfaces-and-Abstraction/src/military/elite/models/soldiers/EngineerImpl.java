package military.elite.models.soldiers;

import military.elite.interfaces.Engineer;
import military.elite.models.Repair;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class EngineerImpl extends SoldierImpl implements Engineer {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public void addRepair(Repair repair) {

    }

    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }
}
