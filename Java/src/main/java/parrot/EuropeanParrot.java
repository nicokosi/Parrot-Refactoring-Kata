package parrot;

public class EuropeanParrot extends Parrot {

    public EuropeanParrot(ParrotTypeEnum _type) {
        super(ParrotTypeEnum.EUROPEAN);
    }

    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }

}
