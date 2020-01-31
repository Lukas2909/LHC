package human_ressources;

import java.util.ArrayList;
import java.util.List;

public class ResearchGroup {
    private Workplace workplace;
    private List<Researcher> researcherList;
    private List<ScientificAssistant> scientificAssistantList;

    public ResearchGroup(ArrayList<Researcher> researcherList,List<ScientificAssistant> scientificAssistantList){
        this.researcherList = researcherList;
        this.scientificAssistantList=scientificAssistantList;
    }
}
