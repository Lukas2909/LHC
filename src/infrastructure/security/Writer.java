package infrastructure.security;

import cryptography.AES;
import cryptography.ICryptorator;
import human_ressources.Person;

import java.util.ArrayList;
import java.util.Date;

public class Writer {
    private Touchpad touchpad;
    private ICryptorator cryptorator;

    public Writer(Touchpad touchpad, ICryptorator cryptorator){
        this.touchpad = touchpad;
        this.cryptorator = cryptorator;
    }


    public void writeOnIDCard(IDCard idCard, Technology technology, Person person, Date validFrom, Date validUntil, ArrayList<Permission> permissionList){
        technology.setIDCardInformation(idCard,person,validFrom,validUntil,permissionList);
    }

    public void writeIsLocked(IDCard idCard, Technology technology, boolean isLocked){
        technology.setIsLocked(idCard, isLocked);
    }

    public void writePasswordOnChip(IDCard idCard, Technology technology, String password){
        technology.setPassword(idCard, cryptorator.encrypt(password));
    }

    public void writeFingerprintOnChip(IDCardEmployee idCard, Technology technology,String fingerprint){
        ((ChipFingerprint)idCard.getChipFingerPrint()).setFingerprint(fingerprint);
    }
}
