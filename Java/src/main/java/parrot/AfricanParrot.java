package parrot;

public class AfricanParrot extends Parrot {

    private final int numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, baseSpeed() - load());
    }

    private double load() {
        return loadFactor() * numberOfCoconuts;
    }

    private double loadFactor() {
        return 9.0;
    }

}
