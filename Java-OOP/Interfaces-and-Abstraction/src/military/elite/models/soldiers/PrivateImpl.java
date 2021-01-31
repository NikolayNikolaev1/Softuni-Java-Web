package military.elite.models.soldiers;

import military.elite.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
}
