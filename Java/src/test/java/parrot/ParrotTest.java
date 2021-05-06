package parrot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParrotTest {

    @Test
    public void getSpeedOfEuropeanParrot() {
        Parrot parrot = newEuropeanParrot();
        assertEquals(12.0, parrot.getSpeed(), 0.0);
    }

    private Parrot newEuropeanParrot() {
        return new EuropeanParrot();
    }

    @Test
    public void getSpeedOfAfricanParrot_With_One_Coconut() {
        Parrot parrot = newAfricanParrot(1);
        assertEquals(3.0, parrot.getSpeed(), 0.0);
    }

    private Parrot newAfricanParrot(int numberOfCoconuts) {
        return new AfricanParrot(numberOfCoconuts);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_Two_Coconuts() {
        Parrot parrot = newAfricanParrot(2);
        assertEquals(0.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_No_Coconuts() {
        Parrot parrot = newAfricanParrot(0);
        assertEquals(12.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_nailed() {
        Parrot parrot = newNorwegianBlueParrot(1.5, true);
        assertEquals(0.0, parrot.getSpeed(), 0.0);
    }

    private Parrot newNorwegianBlueParrot(double voltage, boolean isNailed) {
        return new NorwegianBlueParrot(voltage, isNailed);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed() {
        Parrot parrot = newNorwegianBlueParrot(1.5, false);
        assertEquals(18.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed_high_voltage() {
        Parrot parrot = newNorwegianBlueParrot(4, false);
        assertEquals(24.0, parrot.getSpeed(), 0.0);
    }
}
