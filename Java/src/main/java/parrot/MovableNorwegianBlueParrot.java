package parrot;

public class MovableNorwegianBlueParrot extends NorwegianBlueParrot {

    private final double voltage;

    public MovableNorwegianBlueParrot(double voltage) {
        super(voltage, false);
        this.voltage = voltage;
    }

    public double getSpeed() {
        return voltageSpeed();
    }

    private double voltageSpeed() {
        return Math.min(24.0, voltage * baseSpeed());
    }
}
