package infrastructure.lhc;

import java.util.Date;
import java.util.UUID;

public class Experiment {
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;
    private Block[] blocks;//Composition

    public Experiment(UUID uuid){
        this.uuid = uuid;
        dateTimeStamp= new Date().toString();
        this.blocks =new Block[200000];
    }
}
