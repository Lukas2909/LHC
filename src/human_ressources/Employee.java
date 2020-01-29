package human_ressources;

import infrastructure.security.IDCardEmployee;
import infrastructure.security.IDCardVisitor;

public abstract class Employee extends Person {
    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;

    public Employee(int id, String name, int[][] iris, boolean isManager, boolean isMentor, boolean hasBudgetResponsibility){
        super(id, name, iris);
        this.isManager = isManager;
        this.isMentor = isMentor;
        this.hasBudgetResponsibility = hasBudgetResponsibility;
    }

    public IDCardEmployee getIDCard(){
        return (IDCardEmployee) this.idCard;
    }
}
