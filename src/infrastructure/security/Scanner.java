package infrastructure.security;

import human_ressources.Person;

public class Scanner implements IScanner{
    public int[][] scanIris(Person person){
        return person.getIris();
    }
}
