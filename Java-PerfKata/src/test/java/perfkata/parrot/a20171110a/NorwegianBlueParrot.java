package perfkata.parrot.a20171110a;

public class NorwegianBlueParrot extends Parrot {

    private final double voltage;
    private final boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return isNailed ? 0 : speedForVoltage(voltage);
    }

    private double speedForVoltage(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

}
