package infrastructure.security;

import human_ressources.Employee;

import java.util.ArrayList;
import java.util.Date;

public interface ISecurityCenter {
    public void createIDCard (Technology technology, Employee employee, Date validFrom, Date validUntil, ArrayList<Permission> permissionsList);
    public void lockIDCard(IDCardEmployee idCard, Technology technology);
    public void unlockIDCard(IDCardEmployee idCard, Technology technology);
}
