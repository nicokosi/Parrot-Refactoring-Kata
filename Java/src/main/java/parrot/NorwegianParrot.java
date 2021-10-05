package parrot;

public class NorwegianParrot extends Parrot {

    public NorwegianParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        super(numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return (isNailed()) ? 0 : getBaseSpeed(getVoltage());
    }

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

}
