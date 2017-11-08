package parrot;

public class EuropeanParrot extends Parrot {
    public EuropeanParrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(_type, numberOfCoconuts, voltage, isNailed);
    }

    public double getSpeed() {
        return getBaseSpeed();
    }

}
