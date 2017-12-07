package perfkata.parrot.a20171207;

public class NorwegianBlueParrot extends Parrot {
    private final double voltage;
    private final boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        super(null, 0, 0, false);
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
