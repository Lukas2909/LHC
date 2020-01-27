package infrastructure.security;

public class IDCardEmployee extends IDCard {
    private Chip chipFingerPrint;


    public IDCardEmployee(String id){
        super(id);
        chipFingerPrint=new ChipFingerprint();
    }

    public Chip getChipFingerPrint() {
        return chipFingerPrint;
    }

}
