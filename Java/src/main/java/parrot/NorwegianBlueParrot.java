package parrot;

public class NorwegianBlueParrot extends Parrot {

    private double voltage;
    private boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        super(ParrotTypeEnum.NORWEGIAN_BLUE, 0, voltage, isNailed);
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    private double getBaseSpeed() {
        return 12.0;
    }

}
