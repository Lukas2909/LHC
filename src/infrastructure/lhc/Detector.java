package infrastructure.lhc;

import infrastructure.Configuration;
import infrastructure.security.Reader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;

public class Detector implements IRODetector{
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private List<Experiment> experimentList;
    private Reader reader;
    private Ring ring;
    private final ComponentLoader componentLoader;

    public Detector(Reader reader, Ring ring){
        this.experimentList = new LinkedList<Experiment>();
        this.reader = reader;
        this.ring = ring;
        this. componentLoader=new ComponentLoader();
    }

    public List<Experiment> getExperimentList(){
        return this.experimentList;
    }

    public void search(Experiment experiment){
        //new ComponentLoader().executeSearchMethod();
}


}
