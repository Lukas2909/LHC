package human_ressources;

import infrastructure.security.IDCard;

public class Person {
    protected int id;
    protected String name;
    protected final int[][] iris;
    protected IDCard idCard;



    public Person(int id, String name, int[][] iris){
        this.id = id;
        this.name=name;
        this.iris = iris;
    }

    public int[][] getIris() {
        return iris;
    }
    public String getName() {
        return name;
    }


    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
