package perfkata.parrot.a20171207b;

public class NorwegianBlueParrot extends Parrot {

    private final double voltage;
    private final boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        super();
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return isNailed ? 0 : speedForVoltage();
    }

    private double speedForVoltage() {
        return Math.min(maxSpeed(), voltage * getBaseSpeed());
    }

    private double maxSpeed() {
        return 24.0;
    }

}
