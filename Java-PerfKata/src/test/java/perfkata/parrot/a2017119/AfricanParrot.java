package perfkata.parrot.a2017119;

public class AfricanParrot extends Parrot {

    private final int numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
        super(null, 0, 0, false);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - slowdownDueToCoconuts());
    }

    private double slowdownDueToCoconuts() {
        return getLoadFactor() * numberOfCoconuts;
    }

    private double getLoadFactor() {
        return 9.0;
    }

}
