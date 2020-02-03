package infrastructure.lhc;

import infrastructure.Configuration;
import infrastructure.security.Reader;
import com.google.common.eventbus.Subscribe;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Detector implements IRODetector, IDetector{
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
        this.isActivated=false;
    }

    public void activate(){
        this.isActivated=true;
    }

    public void deactivate(){
        this.isActivated=false;
    }

    public List<Experiment> getExperimentList(){
        return this.experimentList;
    }


    public void addExperimentToList(Experiment experiment){
        this.experimentList.add(experiment);
    }

    public void search(Experiment experiment){          //Blockstrukturausgabe noch implementieren!!!
        Date started = new Date();
        Block[] blocks=experiment.getBlocks();
        for (Block b:blocks) {
            int position = componentLoader.executeSearchMethod(b.getStructure(),higgsBosonStructure);
            if(position>-1){
                Date found = new Date();
                long searchTime = found.getTime()-started.getTime();
                experiment.setHiggsBosonFound(true);
                System.out.println("[i] Experiment ID: "+experiment.getUuid());
                System.out.println("[ii] Zeitstempel: "+experiment.getDateTimeStamp());
                System.out.println("[iii] ID Proton 1: "+ experiment.getProtonID1()+ " ID Proton 2: "+ experiment.getProtonID2());
                System.out.println("[iv] ID Block: "+ b.getUuid());
                System.out.println("[v] Blockstruktur: ???");
                System.out.println("[vi] Laufzeit der Analyse: "+ searchTime + "ms");
            }
        }

    }

    @Subscribe
    public void receive(AnalyseEvent analyseEvent){
        for(Experiment e : experimentList){
            if(!e.getCheckedBefore()){
                search(e);
            }
        }
    }


}
