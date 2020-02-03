package infrastructure.lhc;

import com.google.common.eventbus.Subscribe;

import java.util.UUID;

public class Ring extends Subscriber{
    private boolean isActivated;
    private Experiment currentExperiment;
    private int energy;
    private LargeHadronCollider largeHadronCollider;
    private IDetector detector;
    private ProtonTrap[] protonTraps = new ProtonTrap[2];
    private Magnet[] magnets = new Magnet[72];

    public Ring(int id, LargeHadronCollider lhc, Detector detector, ProtonTrap protonTrap1, ProtonTrap protonTrap2){
        super(id);
        this.isActivated=false;
        this.energy =0;
        this.largeHadronCollider=lhc;
        this.detector=detector;
        this.protonTraps[0]=protonTrap1;
        this.protonTraps[1]=protonTrap2;
        for(int i=0;i<72;i++){
            magnets[i]=new Magnet();
        }


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

    public Proton[] releaseProton()
    {
        Proton[] releasedProtons = new Proton[2];
        for(int i=0;i<2;i++){
            releasedProtons[i]=protonTraps[i].release();
        }
        return releasedProtons;
    }

    public void increaseEnergy(int delta)
    {
        this.energy+=delta;
    }

    public void collide(Proton proton01, Proton pronton02)
    {

    }

    public int decreaseEnergy()
    {
        return 1; // NUR ZUM KOMPILIEREN!!!!!!!!!!!!!!!!!!!!!!!!
    }

    public void shutdown()
    {

    }

    @Subscribe
    public void receive(RunExperimentFullEvent runExperimentFullEvent){

        this.activate(runExperimentFullEvent.getInitialEnergy());
        this.activateMagneticField();
        Proton[] releasedProtons = this.releaseProton();
        while(this.energy<300000){
            this.increaseEnergy(25000);
        }
        currentExperiment = new Experiment(UUID.randomUUID(), releasedProtons[0].getId(), releasedProtons[1].getId());
        this.collide(releasedProtons[0],releasedProtons[1]);

        detector.addExperimentToList(currentExperiment);
        currentExperiment = null;
    }

    @Subscribe
    public void receive(RunExperimentPartialEvent runExperimentPartialEvent){
        this.activate(runExperimentPartialEvent.getInitialEnergy());
    }
}
