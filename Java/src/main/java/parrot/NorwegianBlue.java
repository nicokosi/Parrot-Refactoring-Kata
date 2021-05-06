package parrot;

public class NorwegianBlue extends Parrot{
    private final boolean isNailed;

    public NorwegianBlue(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(type, numberOfCoconuts, voltage, isNailed);
        this.isNailed = isNailed;
    }
}
