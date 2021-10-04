from enum import Enum  # Enum is introduced in Python 3.4.


class ParrotType(Enum):  # If it is not available, just remove it.
    EUROPEAN = 1
    AFRICAN = 2
    NORWEGIAN_BLUE = 3


class EuropeanParrot(object):
    def speed(self):
        return 12.0


class NorvegianBlueParrot(object):
    def __init__(self, nailed, voltage, base_speed):
        self.nailed = nailed
        self.voltage = voltage
        self.base_speed = base_speed

    def speed(self):
        if self.nailed:
            return 0
        else:
            return min([24.0, self.voltage * self.base_speed])


class Parrot:

    def __init__(self, type_of_parrot, number_of_coconuts, voltage, nailed):
        self._type = type_of_parrot
        self._number_of_coconuts = number_of_coconuts
        self._voltage = voltage
        self._nailed = nailed

    def speed(self):
        if self._type == ParrotType.EUROPEAN:
            return EuropeanParrot().speed()
        if self._type == ParrotType.AFRICAN:
            return max(0, self._base_speed() - self._load_factor() * self._number_of_coconuts)
        if self._type == ParrotType.NORWEGIAN_BLUE:
            return self.norvegian_blue_speed(self._nailed, self._voltage, self._base_speed())

        raise ValueError("should be unreachable")

    def norvegian_blue_speed(self, nailed, voltage, base_speed):
        return NorvegianBlueParrot(nailed, voltage, base_speed).speed()


    def _load_factor(self):
        return 9.0

    def _base_speed(self):
        return 12.0
