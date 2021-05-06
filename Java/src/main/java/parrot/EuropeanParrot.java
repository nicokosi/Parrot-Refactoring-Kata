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

    private double getBaseSpeed() {
        return 12.0;
    }

}
