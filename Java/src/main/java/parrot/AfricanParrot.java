package parrot;

public class AfricanParrot extends Parrot {

    private final int numberOfCoconuts;

    public AfricanParrot(ParrotTypeEnum _type, int numberOfCoconuts) {
        super(_type, numberOfCoconuts);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }

    private double getLoadFactor() {
        return 9.0;
    }

}
