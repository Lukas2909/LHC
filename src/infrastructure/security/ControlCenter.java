package infrastructure.security;

import human_ressources.Workplace;
import infrastructure.lhc.*;
import com.google.common.eventbus.EventBus;

public enum ControlCenter {
    instance;
    private final String roomID = "CO1";
    private Workplace[] workplaces = new Workplace[3];
    private EventBus eventBus = new EventBus("ControlCenter");
    private int eventIDCount= 0;

    public void addSubscriber(Subscriber subscriber){
        eventBus.register(subscriber);
    }


    public void startExperiment(){
        eventBus.post(new RunExperimentFullEvent(eventIDCount++,50000));
    }

    public void startExperiment(ExperimentScope scope, int initialEnergy){
        switch (scope){
            case ES5: case ES10: case ES20:eventBus.post(new RunExperimentPartialEvent(eventIDCount++,initialEnergy,scope));
            break;
            case ESFull:eventBus.post(new RunExperimentFullEvent(eventIDCount++,initialEnergy));
            break;
            default: break;
        }
    }

    public void analyseExperiment(){
        eventBus.post(new AnalyseEvent(eventIDCount++));
    }
}
