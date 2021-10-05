package parrot;

public abstract class Parrot {

    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public Parrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    double getSpeed() {
        return 0;
    }

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

    protected int getNumberOfCoconuts() {
        return numberOfCoconuts;
    }

    boolean isNailed() {
        return isNailed;
    }

    protected double getVoltage() {
        return voltage;
    }
}
