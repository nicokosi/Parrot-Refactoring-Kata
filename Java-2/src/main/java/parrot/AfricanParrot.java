package parrot;

public class AfricanParrot extends Parrot {

    private final int numberOfCoconuts;

    public AfricanParrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(_type, numberOfCoconuts, voltage, isNailed);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }

    private double getLoadFactor() {
        return 9.0;
    }

}
