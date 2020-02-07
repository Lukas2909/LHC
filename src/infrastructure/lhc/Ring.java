package infrastructure.lhc;

import com.google.common.eventbus.Subscribe;

import java.util.UUID;

public class Ring extends Subscriber implements IRing{
    private boolean isActivated;
    private IExperiment currentExperiment;
    private int energy;
    private LargeHadronCollider largeHadronCollider;
    private IDetector detector;
    private IProtonTrap[] protonTraps ;
    private IMagnet[] magnets;

    public Ring(int id, LargeHadronCollider lhc, IProtonTrap protonTrap1, IProtonTrap protonTrap2){
        super(id);
        this.isActivated=false;
        this.energy =0;
        this.largeHadronCollider=lhc;
        this.protonTraps= new IProtonTrap[2];
        this.protonTraps[0]=protonTrap1;
        this.protonTraps[1]=protonTrap2;
        this.magnets= new Magnet[72];
        for(int i=0;i<72;i++){
            magnets[i]=new Magnet();
        }
    }

    public void addDetector(IDetector detector){
        this.detector = detector;
    }
    public void activate()
    {
        this.activate(0);
    }

    public void activate(int initialEnergy)
    {
        this.isActivated=true;
        this.energy=initialEnergy;
        System.out.println("Der Ring wurde mit einer Startenergie von "+ initialEnergy+" aktiviert!");
    }

    public void activateMagneticField()
    {
        for(int i=0;i<magnets.length; i++){
            magnets[i].activate();
        }
    }

    public void deactivateMagneticField()
    {
        for(int i=0;i<magnets.length; i++){
            magnets[i].deactivate();
        }
    }

    public IProton[] releaseProton()
    {
        IProton[] releasedProtons = new IProton[2];
        for(int i=0;i<2;i++){
            releasedProtons[i]=protonTraps[i].release();
        }
        return releasedProtons;
    }

    public void increaseEnergy(int delta)
    {
        this.energy+=delta;
    }

    public void collide(IProton proton01, IProton proton02)
    {
        String proton01Content = stringOutOfStructure(proton01.getStructure());
        String proton02Content = stringOutOfStructure(proton02.getStructure());

        for (int i = 0; i < 200000; i++) {
            currentExperiment.addBlock(new Block(UUID.randomUUID(),proton01Content.substring(i * 5, i * 5 + 5) + proton02Content.substring(i * 5, i * 5 + 5) ));
        }
    }

    public int decreaseEnergy()
    {
        this.energy = 0;
        return this.energy;
    }

    public void shutdown()
    {
        this.currentExperiment = null;

        this.decreaseEnergy();
        this.deactivateMagneticField();
        this.isActivated = false;
    }

    @Subscribe
    public void receive(RunExperimentFullEvent runExperimentFullEvent){
        for(int i=0; i<25; i++){
            this.executeExperiment(runExperimentFullEvent.getInitialEnergy());
        }
    }

    @Subscribe
    public void receive(RunExperimentPartialEvent runExperimentPartialEvent){
        int experimentIterations=0;
        switch (runExperimentPartialEvent.getScope()){
            case ES5: experimentIterations=5;break;
            case ES10: experimentIterations = 10; break;
            case ES20: experimentIterations=20; break;
            case ESFull: experimentIterations=25; break;
        }
        for(int i=0; i<25; i++){
            this.executeExperiment(runExperimentPartialEvent.getInitialEnergy());
        }
    }

    private String stringOutOfStructure(int[][][] structure) {
        StringBuilder retString = new StringBuilder();
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                for (int k = 0; k < structure[i][j].length; k++) {
                    retString.append((char) structure[i][j][k]);
                }
            }
        }
        return retString.toString();
    }

    private void executeExperiment(int initialEnergy){
        this.activate(initialEnergy);
        this.activateMagneticField();
        IProton[] releasedProtons = this.releaseProton();
        while(this.energy<300000){
            this.increaseEnergy(25000);
        }
        currentExperiment = new Experiment(UUID.randomUUID(), releasedProtons[0].getId(), releasedProtons[1].getId());
        this.collide(releasedProtons[0],releasedProtons[1]);

        detector.addExperimentToList(currentExperiment);
        this.shutdown();
    }
}
