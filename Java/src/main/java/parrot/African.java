package parrot;

public class African extends Parrot {
    private final int numberOfCoconuts;

    public African(ParrotTypeEnum type, int numberOfCoconuts) {
        super(type, numberOfCoconuts);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return super.getSpeed();
    }
}
