package human_ressources;

import infrastructure.security.IDCard;

import java.util.Random;

public class Person {
    protected int id;
    protected String name;
    protected final int[][] iris;
    protected IDCard idCard;



    public Person(int id, String name){
        this.id = id;
        this.name=name;
        this.iris = new int[10][10];

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.iris[i][j] = random.nextInt();
            }
        }
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
