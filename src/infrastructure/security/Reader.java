package infrastructure.security;

import cryptography.MD5;
import human_ressources.Employee;
import human_ressources.Person;

public class Reader {
    private String currentEmployeeIris;
    private Management management;

    public String scanIris(Employee employee)
    {
        return "Test zum Kompilieren!!!";
    }

    public String scanFingerprint(Person person){
        return MD5.generateMD5(person.getName());
    }

    public void insertIDCard(IDCard idCard)
    {

    }

    public void removeIDCard()
    {

    }
}
