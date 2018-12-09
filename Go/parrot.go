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

type europeanParrot struct {
	base baseParrot
}

func EuropeanParrot() europeanParrot {
	return europeanParrot{baseParrot{}}
}

type africanParrot struct {
	base             baseParrot
	numberOfCoconuts int
}

func AfricanParrot(numberOfCoconuts int) africanParrot {
	return africanParrot{baseParrot{}, numberOfCoconuts}
}

type NorwegianBlueParrot struct {
	base    baseParrot
	voltage float64
	nailed  bool
}

func (parrot europeanParrot) Speed() (float64, error) {
	return parrot.base.baseSpeed(), nil
}

func (parrot africanParrot) Speed() (float64, error) {
	return math.Max(0, parrot.base.baseSpeed()-parrot.loadFactor()*float64(parrot.numberOfCoconuts)), nil
}

func (parrot africanParrot) loadFactor() float64 {
	return 9.0
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
