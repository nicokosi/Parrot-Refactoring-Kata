package parrot;

public class AfricanParrot extends Parrot {

    public AfricanParrot(ParrotTypeEnum _type, int numberOfCoconuts) {
        super(_type, numberOfCoconuts);
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }

}
