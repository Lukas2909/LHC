package infrastructure.lhc;

import infrastructure.security.Reader;

import java.util.LinkedList;
import java.util.List;

public class Detector implements IRODetector{
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private List<Experiment> experimentList;
    private Reader reader;
    private Ring ring;

    public Detector(Reader reader, Ring ring){
        this.experimentList = new LinkedList<Experiment>();
        this.reader = reader;
        this.ring = ring;
    }

    public List<Experiment> getExperimentList(){
        return this.experimentList;
    }
}
