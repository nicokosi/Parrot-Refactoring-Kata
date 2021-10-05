package parrot;

public class NorwegianParrot extends Parrot {

    public NorwegianParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(type, numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return (isNailed()) ? 0 : getBaseSpeed(getVoltage());
    }
}
