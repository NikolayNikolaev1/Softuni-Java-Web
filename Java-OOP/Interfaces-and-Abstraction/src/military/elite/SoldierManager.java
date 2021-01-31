package military.elite;

import military.elite.interfaces.Soldier;
import military.elite.models.soldiers.LieutenantGeneralImpl;
import military.elite.models.soldiers.PrivateImpl;

import java.util.ArrayList;
import java.util.List;

public class SoldierManager {
    private List<Soldier> soldiers;

    public SoldierManager() {
        this.soldiers = new ArrayList<>();
    }

    public void createPrivate(int id, String firstName, String lastName, double salary) {
        PrivateImpl privateImpl = new PrivateImpl(id, firstName, lastName, salary);
        this.soldiers.add(privateImpl);
    }

    public void createLieutenantGeneral(int id, String firstName, String lastName, double salary, List<Integer> privateIds) {
        LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

        for (Integer privateId : privateIds) {
            Soldier soldier = this.soldiers.stream()
                    .filter(s -> s.getId() == privateId)
                    .findFirst()
                    .get();

            // TODO
            // FIXME: 27-Jan-21 
            //lieutenantGeneral.addPrivate(soldier);  
        }
    }
}
