package perfkata.parrot.a20171119;

public class AfricanParrot extends Parrot {

    private final int numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
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
