package infrastructure.lhc;

public class RunExperimentFullEvent {
    private int id;
    private int initialEnergy;

    public int getInitialEnergy() {
        return initialEnergy;
    }

    public RunExperimentFullEvent(int id, int initialEnergy){
        this.id=id;
        this.initialEnergy=initialEnergy;
    }

}
