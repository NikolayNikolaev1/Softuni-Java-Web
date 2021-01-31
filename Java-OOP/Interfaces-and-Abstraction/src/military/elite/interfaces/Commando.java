package military.elite.interfaces;

import military.elite.models.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);

    Collection<Mission> getMissions();
}
