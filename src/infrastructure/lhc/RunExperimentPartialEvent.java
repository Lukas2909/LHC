package infrastructure.lhc;

public class RunExperimentPartialEvent {
    private int id;
    private int initialEnergy;
    private ExperimentScope scope;

    public int getInitialEnergy() {
        return initialEnergy;
    }

    public ExperimentScope getScope() {
        return scope;
    }

    public RunExperimentPartialEvent(int id, int initialEnergy, ExperimentScope scope){
        this.id = id;
        this.initialEnergy=initialEnergy;
        this.scope=scope;
    }
}
