package infrastructure.security;

public class Touchpad {

    //GGF ändern, wenn mit Unittests
    public String enteredPasswort(){
        System.out.println("Geben Sie ihr Passwort ein!");
        return new java.util.Scanner(System.in).next();
        //return "Testpasswort123";
    }
}
