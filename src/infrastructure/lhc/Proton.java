package infrastructure.lhc;

public class Proton implements IProton{
    private int id;
    private int[][][] structure;
    private char[][][] content;
    private double weight;

    public int getId() {
        return id;
    }

    public Proton(int id, int[][][] structure) {
        this.structure = structure;
        this.id = id;
    }

    public int[][][] getStructure() {
        return this.structure;
    }
}
