package infrastructure.security;

import human_ressources.SecurityOfficer;

public enum SecurityCenter{
    instance;
    private SecurityOfficer securityOfficer;
    private IROEmployeeManagement iroEmployeeManagement = EmployeeManagement.instance;

    public void setSecurityOfficer(SecurityOfficer securityOfficer) {
        this.securityOfficer = securityOfficer;
    }
}
