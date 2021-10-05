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

    public abstract double getSpeed();

    protected double getBaseSpeed() {
        return 12.0;
    }

    protected int getNumberOfCoconuts() {
        return numberOfCoconuts;
    }

    protected boolean isNailed() {
        return isNailed;
    }

    protected double getVoltage() {
        return voltage;
    }
}
