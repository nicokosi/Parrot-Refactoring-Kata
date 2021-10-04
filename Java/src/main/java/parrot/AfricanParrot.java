package parrot;

public class AfricanParrot extends Parrot {

    private int numberOfCoconuts;

    public AfricanParrot(ParrotTypeEnum african, int numberOfCoconuts, int i1, boolean b) {
        super(ParrotTypeEnum.AFRICAN, numberOfCoconuts, i1, b);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }
}
