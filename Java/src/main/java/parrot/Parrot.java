package parrot;

public class Parrot {

    private ParrotTypeEnum type;
    protected int numberOfCoconuts;

    public Parrot(ParrotTypeEnum _type, int numberOfCoconuts) {
        this.type = _type;
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

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

}
