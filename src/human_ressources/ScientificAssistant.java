package human_ressources;

import java.util.Date;

public class ScientificAssistant extends Employee {
    private Date periodFrom;
    private Date periodUntil;

    public ScientificAssistant(int id, String name, int[][] iris, boolean isManager, boolean isMentor, boolean hasBudgetResponsibility){
        super(id, name, iris, isManager, isMentor, hasBudgetResponsibility);
    }
}
