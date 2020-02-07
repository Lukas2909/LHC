package infrastructure.lhc;

public class Magnet implements IMagnet{
    private boolean isActivated;
    private MagneticDirection direction;
    private int fieldStrength;

    public Magnet(){
        this.isActivated=false;
        this.direction = MagneticDirection.N;
        this.fieldStrength=0;
    }

    public void activate()
    {
        this.isActivated = true;
    }

    public void deactivate()
    {
        this.isActivated=false;
    }
}
