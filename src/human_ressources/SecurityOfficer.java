package human_ressources;

import infrastructure.security.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SecurityOfficer extends Employee {
    private boolean hasWeapon;

    public SecurityOfficer(int id, String name, int[][] iris, boolean isManager, boolean isMentor, boolean hasBudgetResponsibility, boolean hasWeapon){
        super(id, name, iris, isManager, isMentor, hasBudgetResponsibility);
        this.hasWeapon = hasWeapon;
    }

    public void createIDCard(Employee employee, Date validFrom, Date validUntil, ArrayList<Permission> permissionList){
        IDCardEmployee idCard = (IDCardEmployee) IDCardManagement.instance.getNextBlankIDCard(IDCardType.Employee);
        Writer writer = IDCardManagement.instance.getWriter();
        writer.writeOnIDCard(idCard,employee, validFrom, validUntil, permissionList);
        writer.writePasswordOnChip(idCard, new Scanner(System.in).next());

        writer.writeFingerprintOnChip(idCard, IDCardManagement.instance.getReader().scanFingerprint(employee));
        employee.idCard = idCard;
    }
}
