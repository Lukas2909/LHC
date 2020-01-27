package human_ressources;

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
}
