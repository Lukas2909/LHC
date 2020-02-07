package infrastructure.security;

import human_ressources.IReceptionStaff;
import human_ressources.ReceptionStaff;
import human_ressources.Visitor;
import infrastructure.security.IDCard;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public enum Reception implements IReception{
    instance;

    private IReceptionStaff receptionStaff;


    public void setReceptionStaff(IReceptionStaff receptionStaff) {
        this.receptionStaff = receptionStaff;
    }

    public void createVisitorIDCard(Technology technology, Visitor visitor, Date validFrom, Date validUntil, ArrayList<Permission> permissionsList)
    {
        receptionStaff.createIDCard(technology, visitor, validFrom, validUntil, permissionsList);
    }



}
