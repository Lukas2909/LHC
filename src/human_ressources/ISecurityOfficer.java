package human_ressources;

import infrastructure.security.IDCardEmployee;
import infrastructure.security.Permission;
import infrastructure.security.Technology;

import java.util.ArrayList;
import java.util.Date;

public interface ISecurityOfficer {
    public void createIDCard(Technology technology, Employee employee, Date validFrom, Date validUntil, ArrayList<Permission> permissionList);
    public void lockIDCard(IDCardEmployee idCard, Technology technology);
    public void unlockIDCard(IDCardEmployee idCard, Technology technology);
}
