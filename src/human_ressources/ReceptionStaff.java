package human_ressources;

import infrastructure.security.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReceptionStaff extends Employee {

    public ReceptionStaff(int id, String name, int[][] iris, boolean isManager, boolean isMentor, boolean hasBudgetResponsibility){
        super(id, name, iris, isManager, isMentor, hasBudgetResponsibility);
    }
    public void createIDCard(Technology technology, Visitor visitor, Date validFrom, Date validUntil, ArrayList<Permission> permissionList){
        IDCardVisitor idCard = (IDCardVisitor)IDCardManagement.instance.getNextBlankIDCard(IDCardType.Visitor);
        Writer writer = IDCardManagement.instance.getWriter();
        writer.writeOnIDCard(idCard,technology, visitor, validFrom, validUntil, permissionList);
        writer.writePasswordOnChip(idCard, technology, IDCardManagement.instance.getReader().getTouchpad().enteredPasswort());
        visitor.setIdCard(idCard);
    }

}
