package infrastructure.lhc;

import java.util.Date;
import java.util.UUID;

public class Experiment implements IExperiment{
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;
    private int[] protonIDs;
    private boolean checkedBefore;

    public UUID getUuid() {
        return uuid;
    }

    public String getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setHiggsBosonFound(boolean higgsBosonFound) {
        isHiggsBosonFound = higgsBosonFound;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public int getProtonID1(){
        return this.protonIDs[0];
    }

    public int getProtonID2(){
        return this.protonIDs[1];
    }

    private Block[] blocks;//Composition
    private int internalBlockCount;

    public boolean getCheckedBefore() {
        return checkedBefore;
    }

    public void setCheckedBefore(boolean checkedBefore) {
        this.checkedBefore = checkedBefore;
    }

    public Experiment(UUID uuid, int protonID1, int protonID2){
        this.uuid = uuid;
        dateTimeStamp= new Date().toString();
        this.blocks =new Block[200000];
        this.internalBlockCount=0;
        this.protonIDs=new int[2];
        this.protonIDs[0]=protonID1;
        this.protonIDs[1]=protonID2;
        this.checkedBefore = false;
    }

    public void addBlock(Block block){
        if(internalBlockCount<200000){
            this.blocks[internalBlockCount++]=block;
        }
        else{
            System.out.println("Block kann nicht hinzugefügt werden, ein Experiment umfasst nur 200.000 Blöcke!!");
        }
    }


}
