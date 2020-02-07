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

    public void addResearcher(Researcher researcher){
        researcherList.add(researcher);
        researcher.getResearchGroups().add(this);
    }
    public void removeResearcher(Researcher researcher){
        researcherList.remove(researcher);
        researcher.getResearchGroups().remove(this);
    }
    public void addScientificAssistant(ScientificAssistant scientificAssistant){
        scientificAssistantList.add(scientificAssistant);
        scientificAssistant.getResearchGroups().add(this);
    }
    public void removeScientificAssistant(ScientificAssistant scientificAssistant){
        scientificAssistantList.remove(scientificAssistant);
        scientificAssistant.getResearchGroups().remove(this);
    }
}
