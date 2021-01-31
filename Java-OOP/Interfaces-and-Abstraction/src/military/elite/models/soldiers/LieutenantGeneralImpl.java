package military.elite.models.soldiers;

import military.elite.interfaces.LieutenantGeneral;

import java.util.Set;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }

    public void addPrivate(PrivateImpl priv) {

    }
}
