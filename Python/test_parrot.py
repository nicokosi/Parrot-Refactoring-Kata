from parrot import Parrot, ParrotType, EuropeanParrot, NorvegianBlueParrot


def test_speedOfEuropeanParrot():
    parrot = EuropeanParrot()
    assert parrot.speed() == 12.0


def test_speedOfAfricanParrot_With_One_Coconut():
    parrot = Parrot(ParrotType.AFRICAN, 1, 0, False)
    assert parrot.speed() == 3.0


def test_speedOfAfricanParrot_With_Two_Coconuts():
    parrot = Parrot(ParrotType.AFRICAN, 2, 0, False)
    assert parrot.speed() == 0.0


def test_speedOfAfricanParrot_With_No_Coconuts():
    parrot = Parrot(ParrotType.AFRICAN, 0, 0, False)
    assert parrot.speed() == 12.0


def test_speedNorwegianBlueParrot_nailed():
    parrot = NorvegianBlueParrot(voltage=1.5)
    assert parrot.speed(nailed=True) == 0.0


def test_speedNorwegianBlueParrot_not_nailed():
    parrot = NorvegianBlueParrot(voltage=1.5)
    assert parrot.speed(nailed=False) == 18.0


def test_speedNorwegianBlueParrot_not_nailed_high_voltage():
    parrot = Parrot(ParrotType.NORWEGIAN_BLUE, 0, 4, False)
    assert parrot.speed() == 24.0
