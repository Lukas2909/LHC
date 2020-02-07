package human_ressources;

import infrastructure.security.IEmployeeManagement;

public class HRHoD extends Employee {
    private IEmployeeManagement iEmployeeManagement;

    public HRHoD(int id, String name,  boolean isManager, boolean isMentor, boolean hasBudgetResponsibility, IEmployeeManagement iEmployeeManagement){
        super(id, name, isManager, isMentor, hasBudgetResponsibility);
        this.iEmployeeManagement = iEmployeeManagement;
    }

    public IEmployeeManagement getiEmployeeManagement() {
        return iEmployeeManagement;
    }
}
