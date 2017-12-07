package perfkata.parrot.a20171207b;

public class Parrot {

    private ParrotTypeEnum type;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
    }

    public double getSpeed() {
        switch (type) {
            default:
                throw new RuntimeException("Should be unreachable");
        }
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

}
