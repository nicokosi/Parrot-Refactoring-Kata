package perfkata.parrot.a20171110a;

public class Parrot {

    public Parrot() {
    }

    public double getSpeed() {
        throw new RuntimeException("Should be unreachable");
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

}
