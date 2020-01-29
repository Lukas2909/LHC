import cryptography.AES;
import human_ressources.*;
import infrastructure.Configuration;
import infrastructure.lhc.Detector;
import infrastructure.lhc.Experiment;
import infrastructure.lhc.Ring;
import infrastructure.security.*;

import java.awt.*;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ParseException {
        Reader reader = new Reader(new Touchpad(), new AES(Configuration.instance.getAesMasterPassword()));

        // Personen erstellen
        ReceptionStaff steve = new ReceptionStaff(1, "Steve", new int[10][10],false, false, false);
        SecurityOfficer klaas = new SecurityOfficer(2, "Klaas", new int[10][10],false, false, false, true);
        Visitor peter = new Visitor(3, "Peter", new int[10][10]);
        Researcher albert = new Researcher(4, "Albert", new int[10][10], false, false,false, false, new Detector(reader, new Ring()));
        HRAssistant max = new HRAssistant(5, "Max", new int[10][10], false, false, false, EmployeeManagement.instance);

        // Rezeption und SecurityCenter Mitarbeiter zuweisen
        Reception.instance.setReceptionStaff(steve);
        SecurityCenter.instance.setSecurityOfficer(klaas);

        // Blankokarten anlegen
        IDCardManagement.instance.generateIDCards(187, 33);

        // Date für ValidFrom und Valid Until definieren
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:m:ss");
        Date validFrom = new Date();
        Date validUntil = (Date)simpleDateFormat.parse("31.12.2020 12:00:00");

        ArrayList<Permission> permissionsList = new ArrayList<Permission>();
        permissionsList.add(Permission.Visitor);

        // I. Erstellung einer ID-Karte für Besucher durch Reception
        System.out.println("Erstellung einer ID-Karte für Besucher durch Reception:");
        steve.createIDCard(new RFID(), peter, validFrom, validUntil, permissionsList);
        permissionsList = new ArrayList<Permission>();
        permissionsList.add(Permission.Security);
        System.out.println("Erfolgreich!");

        // II. Erstellung einer ID-Karte für Mitarbeiter durch Security
        System.out.println("");
        System.out.println("II. Erstellung einer ID-Karte für Mitarbeiter durch Security:");
        klaas.createIDCard(new Slot(), steve, validFrom, validUntil, permissionsList);
        System.out.println("Erfolgreich!");

        // III. Reader prüft Zutritt für einen Besucher
        System.out.println("");
        System.out.println("III. Reader prüft Zutritt für einen Besucher:");
        if(reader.verifyIDCard(peter.getIDCard(), new Slot())){
            System.out.println("Dem Besucher wurde der Zutritt gewährt!");
        }
        else{
            System.out.println("Dem Besucher wurde der Zutritt nicht gewährt!");
        }

        // IV. Reader prüft Zutritt für einen Mitarbeiter
        System.out.println("");
        System.out.println("IV. Reader prüft Zutritt für einen Mitarbeiter:");
        if(reader.verifyIDCard(steve.getIDCard(), new Slot())){
            System.out.println("Dem Mitarbeiter wurde der Zutritt gewährt!");
        }
        else{
            System.out.println("Dem Mitarbeiter wurde der Zutritt nicht gewährt!");
        }

        // V. Forscher greift lesend auf die im Detector gespeicherten Experimente zu
        System.out.println("");
        System.out.println("V. Forscher greift lesend auf die im Detector gespeicherten Experimente zu:");
        List<Experiment> experimentList = albert.getIroDetector().getExperimentList();
        if(experimentList!=null){
            System.out.println("Erfolgreich!");
        }
        else{
            System.out.println("Fehlgeschlagen!");
        }

        // VI. HRAssistant hat lesenden Zugriff auf die Daten der Mitarbeiter
        System.out.println("");
        System.out.println("VI. HRAssistant hat lesenden Zugriff auf die Daten der Mitarbeiter:");
        Map<Integer, Employee> employeeMap = max.getIroEmployeeManagement().getEmployeeInformationMap();
        if(employeeMap!=null){
            System.out.println("Erfolgreich!");
        }
        else{
            System.out.println("Fehlgeschlagen!");
        }

        // VII. SecurityCenter sperrt eine ID-Karte
        System.out.println("");
        System.out.println("VII. SecurityCenter sperrt eine ID-Karte:");
        klaas.lockIDCard(steve.getIDCard(), new RFID());

        if(steve.getIDCard().isLocked()){
            System.out.println("Die Karte wurde gesperrt!");
        }
        else{
            System.out.println("Die Karte wurde nicht gesperrt!");
        }


        System.out.println("");
        System.out.println("Drücke Enter zum Beenden!");
        new Touchpad().enteredPasswort();
        System.out.println("Ende des Programms!");
    }
}
