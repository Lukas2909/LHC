package infrastructure.security;

import human_ressources.Employee;
import human_ressources.ISecurityOfficer;
import human_ressources.SecurityOfficer;

import java.util.ArrayList;
import java.util.Date;

public enum SecurityCenter implements ISecurityCenter{
    instance;
    private ISecurityOfficer securityOfficer;
    private IROEmployeeManagement iroEmployeeManagement = EmployeeManagement.instance;

    public void setSecurityOfficer(ISecurityOfficer securityOfficer) {
        this.securityOfficer = securityOfficer;
    }

    public void createIDCard (Technology technology, Employee employee, Date validFrom, Date validUntil, ArrayList<Permission> permissionsList){
        securityOfficer.createIDCard(technology, employee, validFrom, validUntil, permissionsList);
    }

    public void lockIDCard(IDCardEmployee idCard, Technology technology){
        securityOfficer.lockIDCard(idCard, technology);
    }

    public void unlockIDCard(IDCardEmployee idCard, Technology technology){
        securityOfficer.unlockIDCard(idCard, technology);
    }
}
