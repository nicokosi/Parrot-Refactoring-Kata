package parrot;

public class EuropeanParrot extends Parrot {
    public EuropeanParrot() {
        super();
    }

    @Override
    public double getSpeed() {
        return europeanSpeed();
    }

    private double europeanSpeed() {
        return getBaseSpeed();
    }
}
