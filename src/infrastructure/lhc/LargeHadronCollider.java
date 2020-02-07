package infrastructure.lhc;

import infrastructure.Building;
import infrastructure.energy.IUSP;
import infrastructure.energy.USP;
import infrastructure.lhc.Ring;

public class LargeHadronCollider {
    private Building building;
    private Ring ring;
    private IUSP[] usps;

    public LargeHadronCollider(){
        this.usps = new USP[2];
    }
}
