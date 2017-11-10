package perfkata.parrot.a20171110a;

public class EuropeanParrot extends Parrot {
    public EuropeanParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(type, numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }

}
