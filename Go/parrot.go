package parrot

import (
	"math"
)

// Parrot has a Speed.
type Parrot interface {
	Speed() (float64, error)
}

type baseParrot struct {
}

func (parrot baseParrot) baseSpeed() float64 {
	return 12.0
}

type EuropeanParrot struct {
	base baseParrot
}

func CreateEuropeanParrot() EuropeanParrot {
	return EuropeanParrot{baseParrot{}}
}

func (parrot EuropeanParrot) Speed() (float64, error) {
	return parrot.base.baseSpeed(), nil
}

type AfricanParrot struct {
	base             baseParrot
	numberOfCoconuts int
}

func CreateAfricanParrot(numberOfCoconuts int) AfricanParrot {
	return AfricanParrot{baseParrot{}, numberOfCoconuts}
}

func (parrot AfricanParrot) Speed() (float64, error) {
	return math.Max(0, parrot.base.baseSpeed()-parrot.loadFactor()*float64(parrot.numberOfCoconuts)), nil
}

func (parrot AfricanParrot) loadFactor() float64 {
	return 9.0
}

type NorwegianBlueParrot struct {
	base    baseParrot
	voltage float64
	nailed  bool
}

func CreateNorwegianBlueParrot(voltage float64, nailed bool) NorwegianBlueParrot {
	return NorwegianBlueParrot{baseParrot{}, voltage, nailed}
}

func (parrot NorwegianBlueParrot) Speed() (float64, error) {
	if parrot.nailed {
		return 0, nil
	}
	return parrot.computeBaseSpeedForVoltage(parrot.voltage), nil
}

func (parrot NorwegianBlueParrot) computeBaseSpeedForVoltage(voltage float64) float64 {
	return math.Min(24.0, voltage*parrot.base.baseSpeed())
}
