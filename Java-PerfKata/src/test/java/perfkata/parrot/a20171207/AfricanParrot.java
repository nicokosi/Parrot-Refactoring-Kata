package perfkata.parrot.a20171207;

public class AfricanParrot extends Parrot {
    private final int numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
        super(null, 0, 0, false);
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
