import human_ressources.ReceptionStaff;
import human_ressources.SecurityOfficer;
import human_ressources.Visitor;
import infrastructure.security.IDCardManagement;
import infrastructure.security.Permission;
import infrastructure.security.Reception;
import infrastructure.security.SecurityCenter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Application {

    public static void main(String[] args){


        ReceptionStaff steve = new ReceptionStaff(1, "Steve", new int[10][10],false, false, false);
        SecurityOfficer klaas = new SecurityOfficer(2, "Klaas", new int[10][10],false, false, false, true);

        Visitor peter = new Visitor(3, "Peter", new int[10][10]);
        Reception.instance.setReceptionStaff(steve);
        SecurityCenter.instance.setSecurityOfficer(klaas);

        IDCardManagement.instance.generateIDCards(187, 33);

        ArrayList<Permission> permissionsList = new ArrayList<Permission>();
        permissionsList.add(Permission.Visitor);

        // I. Erstellung einer ID-Karte für Besucher durch Reception
        steve.createIDCard(peter, new Date(), new Date(), permissionsList);
        permissionsList = new ArrayList<Permission>();
        permissionsList.add(Permission.Security);

        // II. Erstellung einer ID-Karte für Mitarbeiter durch Security
        klaas.createIDCard(steve, new Date(), new Date(), permissionsList);
        System.out.println("Stop!");
    }
}
