package parrot;

public class Parrot {

    private ParrotTypeEnum type;

    public Parrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = _type;
    }

    public double getSpeed() {
        throw new RuntimeException("Should be unreachable");
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

}
