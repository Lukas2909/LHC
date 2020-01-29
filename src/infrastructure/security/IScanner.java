package infrastructure.security;

import human_ressources.Person;

public interface IScanner {
    public int[][] scanIris(Person person);
}
