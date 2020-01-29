package infrastructure.security;

import cryptography.ICryptorator;
import cryptography.MD5;
import human_ressources.Employee;
import human_ressources.Person;

import java.util.Date;

public class Reader {
    private String currentEmployeeIris;
    private Management management;
    private Touchpad touchpad;
    private ICryptorator cryptorator;

    public Reader(Touchpad touchpad, ICryptorator cryptorator){
        this.touchpad = touchpad;
        this.cryptorator = cryptorator;
    }
    public String scanFingerprint(Person person){
        return MD5.generateMD5(person.getName());
    }

    public Touchpad getTouchpad() {
        return touchpad;
    }

    public boolean verifyIDCard(IDCardVisitor idCard, Technology technology){
        boolean verified = true;
        Date now = new Date();
        if(!(touchpad.enteredPasswort().equals(cryptorator.decrypt(technology.getPassword(idCard))))){
            System.out.println("Falsches Passwort!");
            verified = false;
        }
        if(technology.getIsLocked(idCard)){
            System.out.println("Ihre IDCard ist gesperrt!");
            verified = false;
        }
        if(technology.getValidFrom(idCard).after(now)){
            System.out.println("Ihre IDCard ist noch nicht gültig!");
            verified = false;
        }
        if(technology.getValidUntil(idCard).before(now)){
            System.out.println("Ihre IDCard ist nicht mehr gültig!");
            verified = false;
        }

        return verified;
    }

    public boolean verifyIDCard(IDCardEmployee idCard, Technology technology){
        boolean verified = true;
        Date now = new Date();
        if(cryptorator.decrypt(technology.getPassword(idCard)).equals("helloLHC2020")){
            System.out.println("Sie loggen sich zum ersten Mal in das System ein, bitte ändern Sie ihr Passwort!");
            changePassword(idCard, technology, IDCardManagement.instance.getWriter());
        }
        if(!(touchpad.enteredPasswort().equals(cryptorator.decrypt(technology.getPassword(idCard))))){
            System.out.println("Falsches Passwort!");
            verified = false;
        }
        if(technology.getIsLocked(idCard)){
            System.out.println("Ihre IDCard ist gesperrt!");
            verified = false;
        }
        if(technology.getValidFrom(idCard).after(now)){
            System.out.println("Ihre IDCard ist noch nicht gültig!");
            verified = false;
        }
        if(technology.getValidUntil(idCard).before(now)){
            System.out.println("Ihre IDCard ist nicht mehr gültig!");
            verified = false;
        }
        return verified;
    }

    public void changePassword(IDCardEmployee idCard, Technology technology, Writer writer){
        while(true) {
            System.out.println("Bitte geben Sie zunächst Ihr altes Passwort ein!");
            if (touchpad.enteredPasswort().equals(cryptorator.decrypt(technology.getPassword(idCard)))) {
                System.out.println("Bitte geben Sie Ihr neues Passwort ein!");
                writer.writePasswordOnChip(idCard, technology, touchpad.enteredPasswort());
                System.out.println("Ihr Passwort wurde erfolgreich geändert!");
                return;
            }
            else{
                System.out.println("Falsches Passwort! Bitte versuchen Sie es erneut!");
            }
        }

    }
}
