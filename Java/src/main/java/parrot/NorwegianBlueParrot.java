package parrot;

public class NorwegianBlueParrot extends Parrot {

    protected double voltage;
    protected boolean isNailed;

    public NorwegianBlueParrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(_type, numberOfCoconuts, voltage, isNailed);
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

}
