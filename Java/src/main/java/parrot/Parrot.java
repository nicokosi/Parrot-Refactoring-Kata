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
            case AFRICAN:
                return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);

            default:
                throw new RuntimeException("Should be unreachable");
        }
    }

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    private double getLoadFactor() {
        return 9.0;
    }

    private double getBaseSpeed() {
        return 12.0;
    }

}
