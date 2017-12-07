package perfkata.parrot.a20171207;

public class AfricanParrot extends Parrot {

    private final int numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - slowdownDueCoconuts());
    }

    private double slowdownDueCoconuts() {
        return getLoadFactor() * numberOfCoconuts;
    }

    private double getLoadFactor() {
        return 9.0;
    }

}
