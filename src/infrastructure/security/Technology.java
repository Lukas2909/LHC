package infrastructure.security;

import human_ressources.Person;

import java.util.ArrayList;
import java.util.Date;

public abstract class Technology {
    public String getPassword(IDCard idCard){
        return ((ChipPassword)idCard.getChipPassword()).getPassword();
    }

    public int[][] getIris(IDCard idCard){
        return idCard.getIrisStructure();
    }

    public Date getValidFrom(IDCard idCard){
        return idCard.getValidFrom();
    }

    public Date getValidUntil(IDCard idCard){
        return idCard.getValidUntil();
    }

    public boolean getIsLocked(IDCard idCard){
        return idCard.isLocked();
    }

    public String getFingerprint(IDCardEmployee idCard){
        return ((ChipFingerprint)idCard.getChipFingerPrint()).getFingerprint();
    }

    public void setIsLocked(IDCard idCard, boolean isLocked){
        idCard.setLocked(isLocked);
    }

    public void setIDCardInformation(IDCard idCard, Person person, Date validFrom, Date validUntil, ArrayList<Permission> permissionList){
        idCard.setIDCardInformation(person, validFrom, validUntil, permissionList);
    }

    public void setPassword(IDCard idCard, String password){
        ((ChipPassword)idCard.getChipPassword()).setPassword(password);
    }

    public void setFingerprint(IDCardEmployee idCard, String fingerprint){
        ((ChipFingerprint)idCard.getChipFingerPrint()).setFingerprint(fingerprint);
    }
}
