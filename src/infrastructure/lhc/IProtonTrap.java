package infrastructure.lhc;

public interface IProtonTrap {
    public void loadData(int id, String dataFilePath);
    public IProton release();
}
