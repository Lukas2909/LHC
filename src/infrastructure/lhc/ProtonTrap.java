package infrastructure.lhc;

public class ProtonTrap {
    private ProtonTrapID id;
    //private infrastructure.lhc.Ring ring;
    private Proton[] protons=new Proton[100];

    public void loadData(String dataFilePath)
    {

    }

    public Proton release()
    {
        return protons[1]; // Temporär so definiert!!
    }
}
