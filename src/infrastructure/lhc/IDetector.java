package infrastructure.lhc;

import java.util.List;

public interface IDetector extends IRODetector {
    public void addExperimentToList(IExperiment experiment);
}
