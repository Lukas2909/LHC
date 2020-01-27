package infrastructure.security;

import human_ressources.ReceptionStaff;
import infrastructure.security.IDCard;

import java.util.Stack;

public enum Reception{
    instance;

    private ReceptionStaff receptionStaff;


    public void setReceptionStaff(ReceptionStaff receptionStaff) {
        this.receptionStaff = receptionStaff;
    }

    public void createVisitorIDCard()
    {

    }



}
