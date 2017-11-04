package parrot;

public class Parrot {

    private ParrotTypeEnum type;

    public Parrot(ParrotTypeEnum _type, int numberOfCoconuts) {
        this.type = _type;
    }

    public double getSpeed() {
        switch (type) {
        case EUROPEAN:
            return getBaseSpeed();
        default:
            throw new RuntimeException("Should be unreachable");
        }
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

}
