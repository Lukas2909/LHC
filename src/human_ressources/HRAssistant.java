package human_ressources;

import infrastructure.security.IEmployeeManagement;
import infrastructure.security.IROEmployeeManagement;

public class HRAssistant extends Employee {
    private IROEmployeeManagement iroEmployeeManagement;

    public IROEmployeeManagement getIroEmployeeManagement() {
        return iroEmployeeManagement;
    }

    public HRAssistant(int id, String name, int[][] iris, boolean isManager, boolean isMentor, boolean hasBudgetResponsibility, IROEmployeeManagement iroEmployeeManagement){
        super(id, name, iris, isManager, isMentor, hasBudgetResponsibility);
        this.iroEmployeeManagement = iroEmployeeManagement;
    }
}