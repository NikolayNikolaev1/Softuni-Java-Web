package military.elite.models.soldiers;

import military.elite.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);

    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    private void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }
}
