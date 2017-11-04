package parrot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParrotTest {

    @Test
    public void getSpeedOfEuropeanParrot() {
        Parrot parrot = new Parrot(ParrotTypeEnum.EUROPEAN);
        assertEquals(parrot.getSpeed(), 12.0, 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_One_Coconut() {
        Parrot parrot = new AfricanParrot(ParrotTypeEnum.AFRICAN, 1);
        assertEquals(parrot.getSpeed(), 3.0, 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_Two_Coconuts() {
        Parrot parrot = new AfricanParrot(ParrotTypeEnum.AFRICAN, 2);
        assertEquals(parrot.getSpeed(), 0.0, 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_No_Coconuts() {
        Parrot parrot = new AfricanParrot(ParrotTypeEnum.AFRICAN, 0);
        assertEquals(parrot.getSpeed(), 12.0, 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_nailed() {
        Parrot parrot = new NorwegianBlueParrot(ParrotTypeEnum.NORWEGIAN_BLUE, 1.5, true);
        assertEquals(parrot.getSpeed(), 0.0, 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed() {
        Parrot parrot = new NorwegianBlueParrot(ParrotTypeEnum.NORWEGIAN_BLUE, 1.5, false);
        assertEquals(parrot.getSpeed(), 18.0, 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed_high_voltage() {
        Parrot parrot = new NorwegianBlueParrot(ParrotTypeEnum.NORWEGIAN_BLUE, 4, false);
        assertEquals(parrot.getSpeed(), 24.0, 0.0);
    }
}
