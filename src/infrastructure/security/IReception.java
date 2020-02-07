package infrastructure.security;

import human_ressources.IReceptionStaff;
import human_ressources.Visitor;

import java.util.ArrayList;
import java.util.Date;

public interface IReception {
    public void createVisitorIDCard(Technology technology, Visitor visitor, Date validFrom, Date validUntil, ArrayList<Permission> permissionsList);
    public void setReceptionStaff(IReceptionStaff receptionStaff);
}
