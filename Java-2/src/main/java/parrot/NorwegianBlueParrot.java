package parrot;

public class NorwegianBlueParrot extends Parrot {
    public NorwegianBlueParrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(_type, numberOfCoconuts, voltage, isNailed);
    }

    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeedForVoltage(voltage);
    }

    private double getBaseSpeedForVoltage(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }
}
