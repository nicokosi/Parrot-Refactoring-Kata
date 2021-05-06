package parrot;

public class MovableNorwegianBlueParrot extends Parrot {

    private final double voltage;

    public MovableNorwegianBlueParrot(double voltage) {
        this.voltage = voltage;
    }

    public double getSpeed() {
        return Math.min(minSpeed(), voltage * baseSpeed());
    }

    private double minSpeed() {
        return 24.0;
    }

}
