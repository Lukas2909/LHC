package infrastructure.security;

import infrastructure.lhc.ExperimentScope;
import infrastructure.lhc.Subscriber;

public interface IControlCenter {
    public void addSubscriber(Subscriber subscriber);
    public void startExperiment();
    public void startExperiment(ExperimentScope scope, int initialEnergy);
    public void analyseExperiment();
}
