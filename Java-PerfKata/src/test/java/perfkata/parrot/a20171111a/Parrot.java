package perfkata.parrot.a20171111a;

public abstract class Parrot {

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
    }

    public abstract double getSpeed();

    protected double getBaseSpeed() {
        return 12.0;
    }

}
