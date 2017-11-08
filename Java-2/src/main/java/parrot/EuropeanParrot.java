package parrot;

public class EuropeanParrot extends Parrot {
    public EuropeanParrot() {
        super(null, 0, 0, false);
    }

    public double getSpeed() {
        return getBaseSpeed();
    }

}
