package infrastructure.lhc;



public class Proton {
    private int id;
    private int[][][] structure = new int[100][100][100];
    private char[][][] content= new char[100][100][100];
    private double weight;

    public int getId() {
        return id;
    }

    public Proton(int id, String input){
        this.id = id;
    }


}
