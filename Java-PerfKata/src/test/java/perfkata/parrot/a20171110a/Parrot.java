package perfkata.parrot.a20171110a;

public class Parrot {

    private ParrotTypeEnum type;
    protected double voltage;
    protected boolean isNailed;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.voltage = voltage;
        this.isNailed = isNailed;
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
