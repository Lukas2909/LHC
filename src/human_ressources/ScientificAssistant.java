package human_ressources;

import java.util.ArrayList;
import java.util.Date;

public class ScientificAssistant extends Employee {
    private Date periodFrom;
    private Date periodUntil;

    private ArrayList<ResearchGroup> researchGroups;

    public ArrayList<ResearchGroup> getResearchGroups() {
        return researchGroups;
    }

    public ScientificAssistant(int id, String name, boolean isManager, boolean isMentor, boolean hasBudgetResponsibility){
        super(id, name, isManager, isMentor, hasBudgetResponsibility);
        this.researchGroups = new ArrayList<>();
    }
}
