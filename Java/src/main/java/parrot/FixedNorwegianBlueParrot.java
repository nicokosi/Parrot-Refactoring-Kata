package parrot;

public class FixedNorwegianBlueParrot extends NorwegianBlueParrot {
    public FixedNorwegianBlueParrot() {
        super(0, true);
    }

    public double getSpeed() {
        return 0;
    }
}
