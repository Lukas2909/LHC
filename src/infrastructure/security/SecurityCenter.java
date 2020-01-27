package infrastructure.security;

import human_ressources.SecurityOfficer;

public enum SecurityCenter{
    instance;
    private SecurityOfficer securityOfficer;

    public void setSecurityOfficer(SecurityOfficer securityOfficer) {
        this.securityOfficer = securityOfficer;
    }
}
