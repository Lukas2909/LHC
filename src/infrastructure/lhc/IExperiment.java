package infrastructure.lhc;

import java.util.UUID;

public interface IExperiment {
    public boolean getCheckedBefore();
    public void setCheckedBefore(boolean checkedBefore);
    public void addBlock(Block block);
    public Block[] getBlocks();
    public void setHiggsBosonFound(boolean b);
    public UUID getUuid();
    public String getDateTimeStamp();
    public int getProtonID1();
    public int getProtonID2();
}
