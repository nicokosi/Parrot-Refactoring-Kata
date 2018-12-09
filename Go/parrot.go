package parrot

import (
	"errors"
	"math"
)

type parrotType int

const (
	TypeNorwegianBlue parrotType = 3
)

// Parrot has a Speed.
type Parrot interface {
	Speed() (float64, error)
}

type mixedParrot struct {
	_type            parrotType
	numberOfCoconuts int
	voltage          float64
	nailed           bool
}

type EuropeanParrot struct {
}

type AfricanParrot struct {
	numberOfCoconuts int
}

type NorwegianBlueParrot struct {
	voltage float64
	nailed  bool
}

func CreateParrot(t parrotType, numberOfCoconuts int, voltage float64, nailed bool) Parrot {
	return mixedParrot{t, numberOfCoconuts, voltage, nailed}
}

func (parrot mixedParrot) Speed() (float64, error) {
	switch parrot._type {

	case TypeNorwegianBlue:
		if parrot.nailed {
			return 0, nil
		}
		return parrot.computeBaseSpeedForVoltage(parrot.voltage), nil

	default:
		return 0, errors.New("should be unreachable")
	}
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

func (parrot mixedParrot) computeBaseSpeedForVoltage(voltage float64) float64 {
	return math.Min(24.0, voltage*parrot.baseSpeed())
}

func (parrot mixedParrot) baseSpeed() float64 {
	return 12.0
}
