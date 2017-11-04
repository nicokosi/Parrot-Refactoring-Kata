package parrot;

public class NorwegianBlueParrot extends Parrot {

    private final double voltage;
    private final boolean isNailed;
    protected int numberOfCoconuts;

    public NorwegianBlueParrot(ParrotTypeEnum _type, double voltage, boolean isNailed) {
        super(_type);
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeedForVoltage();
    }

    private double getBaseSpeedForVoltage() {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

}
