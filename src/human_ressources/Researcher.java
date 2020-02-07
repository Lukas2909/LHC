package human_ressources;

import infrastructure.lhc.IRODetector;

import java.util.ArrayList;
import java.util.List;

public class Researcher extends Employee {
    private boolean isSenior;
    private IRODetector iroDetector;
    private List<ResearchGroup> researchGroups;

    public IRODetector getIroDetector() {
        return iroDetector;
    }

    public Researcher(int id, String name,  boolean isManager, boolean isMentor, boolean hasBudgetResponsibility, boolean isSenior, IRODetector iroDetector){
        super(id, name, isManager, isMentor, hasBudgetResponsibility);
        this.isSenior = isSenior;
        this.iroDetector = iroDetector;
        this.researchGroups = new ArrayList<ResearchGroup>();
    }

    public List<ResearchGroup> getResearchGroups() {
        return researchGroups;
    }
}
