package human_ressources;

import infrastructure.security.Permission;
import infrastructure.security.Technology;

import java.util.ArrayList;
import java.util.Date;

public interface IReceptionStaff {
    public void createIDCard(Technology technology, Visitor visitor, Date validFrom, Date validUntil, ArrayList<Permission> permissionList);
}
