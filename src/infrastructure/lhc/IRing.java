package infrastructure.lhc;

public interface IRing {
    public void activate();
    public void activate(int initialEnergy);
    public void activateMagneticField();
    public IProton[] releaseProton();
    public void increaseEnergy(int delta);
    public void collide(IProton proton1, IProton proton2);
    public int decreaseEnergy();
    public void shutdown();

}
