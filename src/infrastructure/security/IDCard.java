package infrastructure.security;

import human_ressources.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public abstract class IDCard {
    protected final String id;
    protected Date validFrom;
    protected Date validUntil;
    protected int[][] irisStructure = new int[10][10];
    protected ArrayList<Permission> permissionList;
    protected boolean isLocked;
    protected Person person;
    protected Chip chipPassword; //Composition

    public IDCard(String id){
        this.id = id;
        this.permissionList = new ArrayList<Permission>();
        this.isLocked = true;
        this.chipPassword= new ChipPassword();
    }

    public Chip getChipPassword() {
        return chipPassword;
    }

    public void addPermission(Permission permission){
        if(!permissionList.contains(permission)){
            permissionList.add(permission);
        }
    }

    public void setIDCardInformation(Person person, Date validFrom, Date validUntil, ArrayList<Permission> permissionList){
        this.person = person;
        this.irisStructure = person.getIris();
        this.isLocked=false;
        this.validFrom= validFrom;
        this.validUntil = validUntil;
        this.permissionList = permissionList;
    }
}
