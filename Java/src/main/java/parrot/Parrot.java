package parrot;

public class Parrot {

    private ParrotTypeEnum type;
    private int numberOfCoconuts;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
    }

    public double getSpeed() {
        switch (type) {
            case EUROPEAN:
                return getBaseSpeed();

            default:
                throw new RuntimeException("Should be unreachable");
        }
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

}
