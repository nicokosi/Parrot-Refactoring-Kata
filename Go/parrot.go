package parrot

import (
	"errors"
	"math"
)

// Parrot has a Speed.
type Parrot interface {
	Speed() (float64, error)
}

type baseParrot struct {
}

type EuropeanParrot struct {
	base baseParrot
}

type AfricanParrot struct {
	base             baseParrot
	numberOfCoconuts int
}

type NorwegianBlueParrot struct {
	base    baseParrot
	voltage float64
	nailed  bool
}

func (parrot baseParrot) Speed() (float64, error) {
	return 0, errors.New("should be unreachable")
}

func (parrot baseParrot) baseSpeed() float64 {
	return 12.0
}

func (parrot EuropeanParrot) Speed() (float64, error) {
	return parrot.baseSpeed(), nil
}

func (parrot EuropeanParrot) baseSpeed() float64 {
	return 12.0
}

func (parrot AfricanParrot) Speed() (float64, error) {
	return math.Max(0, parrot.baseSpeed()-parrot.loadFactor()*float64(parrot.numberOfCoconuts)), nil
}

func (parrot AfricanParrot) loadFactor() float64 {
	return 9.0
}

func (parrot AfricanParrot) baseSpeed() float64 {
	return 12.0
}

func (parrot NorwegianBlueParrot) Speed() (float64, error) {
	if parrot.nailed {
		return 0, nil
	}
	return parrot.computeBaseSpeedForVoltage(parrot.voltage), nil
}

func (parrot NorwegianBlueParrot) computeBaseSpeedForVoltage(voltage float64) float64 {
	return math.Min(24.0, voltage*parrot.baseSpeed())
}

func (parrot NorwegianBlueParrot) baseSpeed() float64 {
	return 12.0
}
