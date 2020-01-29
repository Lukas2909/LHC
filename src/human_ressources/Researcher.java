package human_ressources;

import infrastructure.lhc.IRODetector;

public class Researcher extends Employee {
    private boolean isSenior;
    private IRODetector iroDetector;

    public IRODetector getIroDetector() {
        return iroDetector;
    }

    public Researcher(int id, String name, int[][] iris, boolean isManager, boolean isMentor, boolean hasBudgetResponsibility, boolean isSenior, IRODetector iroDetector){
        super(id, name, iris, isManager, isMentor, hasBudgetResponsibility);
        this.isSenior = isSenior;
        this.iroDetector = iroDetector;
    }
}
