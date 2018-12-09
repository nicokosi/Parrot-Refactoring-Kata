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

func CreateEuropeanParrot() europeanParrot {
	return europeanParrot{baseParrot{}}
}

func (parrot europeanParrot) Speed() (float64, error) {
	return parrot.base.baseSpeed(), nil
}

type africanParrot struct {
	base             baseParrot
	numberOfCoconuts int
}

func CreateAfricanParrot(numberOfCoconuts int) africanParrot {
	return africanParrot{baseParrot{}, numberOfCoconuts}
}

func (parrot africanParrot) Speed() (float64, error) {
	return math.Max(0, parrot.base.baseSpeed()-parrot.loadFactor()*float64(parrot.numberOfCoconuts)), nil
}

func (parrot africanParrot) loadFactor() float64 {
	return 9.0
}

type norwegianBlueParrot struct {
	base    baseParrot
	voltage float64
	nailed  bool
}

func CreateNorwegianBlueParrot(voltage float64, nailed bool) norwegianBlueParrot {
	return norwegianBlueParrot{baseParrot{}, voltage, nailed}
}

func (parrot norwegianBlueParrot) Speed() (float64, error) {
	if parrot.nailed {
		return 0, nil
	}
	return parrot.computeBaseSpeedForVoltage(parrot.voltage), nil
}

func (parrot norwegianBlueParrot) computeBaseSpeedForVoltage(voltage float64) float64 {
	return math.Min(24.0, voltage*parrot.base.baseSpeed())
}
