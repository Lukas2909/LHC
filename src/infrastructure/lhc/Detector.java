package infrastructure.lhc;

import infrastructure.Configuration;
import infrastructure.DataBaseManager;
import infrastructure.security.Reader;
import com.google.common.eventbus.Subscribe;

import javax.xml.crypto.Data;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Detector implements IRODetector, IDetector{
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private List<IExperiment> experimentList;
    private Reader reader;
    private IRing ring;
    private final ComponentLoader componentLoader;

    public Detector(Reader reader, IRing ring){
        if(Configuration.instance.LoadDataFromDatabase){
            DataBaseManager.instance.setupConnection();
            this.experimentList=DataBaseManager.instance.selectExperiments();
            DataBaseManager.instance.shutdown();
        }
        else{
            this.experimentList = new LinkedList<IExperiment>();
        }
        this.experimentList = new LinkedList<IExperiment>();
        this.reader = reader;
        this.ring = ring;
        this.componentLoader=new ComponentLoader();
        this.isActivated=false;
    }

    public void activate(){
        this.isActivated=true;
    }

    public void deactivate(){
        this.isActivated=false;
    }

    public List<IExperiment> getExperimentList(){
        return this.experimentList;
    }


    public void addExperimentToList(IExperiment experiment){
        this.experimentList.add(experiment);
    }

    public void search(IExperiment experiment){          //Blockstrukturausgabe noch implementieren!!!
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
                System.out.println("[v] Blockstruktur: "+b.getStructure());
                System.out.println("[vi] Laufzeit der Analyse: "+ searchTime + "ms");
            }
        }

    }

    @Subscribe
    public void receive(AnalyseEvent analyseEvent){
        for(IExperiment e : experimentList){
            if(!e.getCheckedBefore()){
                search(e);
            }
        }
    }

    public void safeToDataBase(){
        DataBaseManager.instance.setupConnection();
        if(Configuration.instance.LoadDataFromDatabase){
            DataBaseManager.instance.dropTables();
        }
        DataBaseManager.instance.createTableBlocks();
        DataBaseManager.instance.createTableExperiments();
        for (IExperiment experiment:experimentList
             ) {
            DataBaseManager.instance.insert(experiment);

        }
        DataBaseManager.instance.shutdown();
    }


}
