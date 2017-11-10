package perfkata.parrot.a20171110a;

public class EuropeanParrot extends Parrot {
    public EuropeanParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(null, 0, 0, false);
    }

    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }

}
