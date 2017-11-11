package perfkata.parrot.a20171111a;

public class AfricanParrot extends Parrot {
    public AfricanParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(type, numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
            return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }

}
