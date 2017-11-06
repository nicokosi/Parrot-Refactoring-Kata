class Parrot:

    def speed(self):
        raise ValueError("should be unreachable")

    def _base_speed(self):
        return 12.0


class EuropeanParrot(Parrot):

    def speed(self):
        return self._base_speed()


class AfricanParrot(Parrot):

    def __init__(self, number_of_coconuts):
        self._number_of_coconuts = number_of_coconuts

    def speed(self):
        return max(0, self._base_speed() - self._slowdown_due_coconuts())

    def _slowdown_due_coconuts(self):
        return self._load_factor() * self._number_of_coconuts

    def _load_factor(self):
        return 9.0


class NorwegianBlueParrot(Parrot):

    def __init__(self, voltage, nailed):
        self._voltage = voltage
        self._nailed = nailed

    def speed(self):
        if self._nailed:
            return 0
        else:
            return self._speed_for_voltage()

    def _speed_for_voltage(self):
        return min(24.0, self._voltage * self._base_speed())
