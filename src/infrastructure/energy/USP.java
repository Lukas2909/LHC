package infrastructure.energy;

public class USP implements IUSP {
    private boolean isStandBy;
    private boolean isActivated;
    private Battery[] batteries; //Aggregation

    public USP() {
        this.batteries=new Battery[25];
    }

    public void determineChargeState()
    {

    }

    public void charge(ThreePinPlug plug)
    {

    }

    public int takeOut()
    {
        // NUR ZUM KOMPILIEREN!
        return 0;
    }

}
