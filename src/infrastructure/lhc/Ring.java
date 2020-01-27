package infrastructure.lhc;

public class Ring {
    private boolean isActivated;
    private Experiment currentExperiment;
    private int energy;
    private LargeHadronCollider largeHadronCollider;
    private Detector detector;
    private ProtonTrap[] protonTraps = new ProtonTrap[2];
    private Magnet[] magnets = new Magnet[72];

    public void activate()
    {

    }

    public void activate(int initialEnergy)
    {

    }

    public void activateMagneticField()
    {

    }

    public void releaseProton()
    {

    }

    public void increaseEnergy(int delta)
    {

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
}
