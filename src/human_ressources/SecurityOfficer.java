package human_ressources;

import infrastructure.security.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SecurityOfficer extends Employee implements ISecurityOfficer{
    private boolean hasWeapon;

    public SecurityOfficer(int id, String name,boolean isManager, boolean isMentor, boolean hasBudgetResponsibility, boolean hasWeapon){
        super(id, name, isManager, isMentor, hasBudgetResponsibility);
        this.hasWeapon = hasWeapon;
    }

    public void createIDCard(Technology technology, Employee employee, Date validFrom, Date validUntil, ArrayList<Permission> permissionList){
        IDCardEmployee idCard = (IDCardEmployee) IDCardManagement.instance.getNextBlankIDCard(IDCardType.Employee);
        Writer writer = IDCardManagement.instance.getWriter();
        writer.writeOnIDCard(idCard, technology, employee, validFrom, validUntil, permissionList);
        writer.writePasswordOnChip(idCard, technology, "helloLHC2020");

        writer.writeFingerprintOnChip(idCard, technology, IDCardManagement.instance.getReader().scanFingerprint(employee));
        IDCardManagement.instance.assignIDCard(idCard, employee);
    }

    public void lockIDCard(IDCardEmployee idCard, Technology technology){
        IDCardManagement.instance.getWriter().writeIsLocked(idCard, technology, true);
    }

    public void unlockIDCard(IDCardEmployee idCard, Technology technology){
        IDCardManagement.instance.getWriter().writeIsLocked(idCard, technology, false);
    }
}
