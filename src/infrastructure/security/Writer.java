package infrastructure.security;

import cryptography.AES;
import cryptography.Cryptorator;
import human_ressources.Person;

import java.util.ArrayList;
import java.util.Date;

public class Writer {

    public void writeOnIDCard(IDCard idCard, Person person, Date validFrom, Date validUntil, ArrayList<Permission> permissionList){
        idCard.setIDCardInformation(person, validFrom,validUntil,permissionList);
    }

    public void writePasswordOnChip(IDCard idCard, String password){
        Cryptorator cryptorator = new AES();
        ((ChipPassword)idCard.getChipPassword()).setPassword(cryptorator.encrypt(password));
    }

    public void writeFingerprintOnChip(IDCardEmployee idcard, String fingerprint){
        ((ChipFingerprint)idcard.getChipFingerPrint()).setFingerprint(fingerprint);
    }
}
