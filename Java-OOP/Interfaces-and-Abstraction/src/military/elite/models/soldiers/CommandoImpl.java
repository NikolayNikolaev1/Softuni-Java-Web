package military.elite.models.soldiers;

import military.elite.interfaces.Commando;
import military.elite.models.Mission;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class CommandoImpl extends SoldierImpl implements Commando {
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public void addMission(Mission mission) {

    }

    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }
}
