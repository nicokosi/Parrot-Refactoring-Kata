package perfkata.parrot.a20171207;

public class EuropeanParrot extends Parrot {
    public EuropeanParrot() {
        super(null, 0, 0, false);
    }

    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }


}
