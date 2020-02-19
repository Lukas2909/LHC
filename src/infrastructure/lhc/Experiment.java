package infrastructure.lhc;

import java.util.Date;
import java.util.UUID;

public class Experiment implements IExperiment{
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;
    private int[] protonIDs;
    private boolean checkedBefore;
    private Block[] blocks;//Composition
    private int internalBlockCount;

    public UUID getUuid() {
        return uuid;
    }

    public String getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setHiggsBosonFound(boolean higgsBosonFound) {
        isHiggsBosonFound = higgsBosonFound;
    }
    public boolean getIsHiggsFound(){
        return this.isHiggsBosonFound;
    }

    public int getInternalBlockCount() {
        return internalBlockCount;
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



    public boolean getCheckedBefore() {
        return checkedBefore;
    }

    public void setCheckedBefore(boolean checkedBefore) {
        this.checkedBefore = checkedBefore;
    }

    private Experiment(UUID uuid, int protonID1, int protonID2){
        this.uuid = uuid;
        this.dateTimeStamp= new Date().toString();
        this.isHiggsBosonFound=false;
        this.blocks =new Block[200000];
        this.internalBlockCount=0;
        this.protonIDs=new int[2];
        this.protonIDs[0]=protonID1;
        this.protonIDs[1]=protonID2;
        this.checkedBefore = false;
    }

    private Experiment(UUID uuid, String dateTimeStamp, boolean isHiggsFound, int protonID1, int protonID2, boolean checkedBefore, Block[] blocks, int internalBlockCount){
        this.uuid = uuid;
        this.dateTimeStamp= dateTimeStamp;
        this.isHiggsBosonFound=isHiggsFound;
        this.blocks =blocks;
        this.internalBlockCount=internalBlockCount;
        this.protonIDs=new int[2];
        this.protonIDs[0]=protonID1;
        this.protonIDs[1]=protonID2;
        this.checkedBefore = checkedBefore;
    }

    public void addBlock(Block block){
        if(internalBlockCount<200000){
            this.blocks[internalBlockCount++]=block;
        }
        else{
            System.out.println("Block kann nicht hinzugefügt werden, ein Experiment umfasst nur 200.000 Blöcke!!");
        }
    }


    public static class ExperimentFactory{
        public static Experiment createExperiment(UUID uuid, int protonID1, int protonID2){
            return new Experiment(uuid, protonID1, protonID2);
        }

        public static Experiment createExperimentDatabase(UUID uuid, String dateTimeStamp, boolean isHiggsFound, int protonID1, int protonID2, boolean checkedBefore, Block[] blocks, int internalBlockCount){
            return new Experiment(uuid, dateTimeStamp, isHiggsFound, protonID1, protonID2, checkedBefore, blocks, internalBlockCount);
        }
    }
}
