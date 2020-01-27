package human_ressources;

public class Researcher extends Employee {
    private boolean isSenior;

    public Researcher(int id, String name, int[][] iris, boolean isManager, boolean isMentor, boolean hasBudgetResponsibility){
        super(id, name, iris, isManager, isMentor, hasBudgetResponsibility);
    }
}
