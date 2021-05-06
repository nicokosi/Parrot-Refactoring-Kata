package parrot;

public class NorwegianBlueParrot extends Parrot {

    private double voltage;
    private boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return (isNailed) ? 0 : getVoltageSpeed();
    }

    private double getVoltageSpeed() {
        return Math.min(24.0, voltage * getBaseSpeed());
    }
}
