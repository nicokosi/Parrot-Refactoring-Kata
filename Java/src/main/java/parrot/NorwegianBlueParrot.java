package parrot;

public class NorwegianBlueParrot extends Parrot {

    private final double voltage;
    private final boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return isNailed ? 0 : voltageSpeed();
    }

    private double voltageSpeed() {
        return Math.min(24.0, voltage * baseSpeed());
    }
}
