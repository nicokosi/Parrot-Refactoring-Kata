package parrot;

public class Parrot {

    private ParrotTypeEnum type;
    protected double voltage;

    public Parrot(ParrotTypeEnum type, double voltage) {
        this.type = type;
        this.voltage = voltage;
    }

    public double getSpeed() {
        throw new RuntimeException("Should be unreachable");
    }

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

}
