package parrot;

public class ParrotNorwegian extends Parrot {
    private final double voltage;
    private final boolean isNailed;

    public ParrotNorwegian(ParrotTypeEnum norwegianBlue, double voltage, boolean isNailed) {
        super(norwegianBlue, voltage, isNailed);
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return super.getSpeed();
    }
}
