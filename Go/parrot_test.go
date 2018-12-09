package parrot

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestSpeedOfEuropeanParrot(t *testing.T) {
	parrot := EuropeanParrot{baseParrot{}}
	speed, err := parrot.Speed()
	assert.Equal(t, 12.0, speed)
	assert.NoError(t, err)
}

func TestSpeedOfAfricanParrot_With_One_Coconut(t *testing.T) {
	parrot := AfricanParrot{baseParrot{}, 1}
	speed, err := parrot.Speed()
	assert.Equal(t, 3.0, speed)
	assert.NoError(t, err)
}

func TestSpeedOfAfricanParrot_With_Two_Coconuts(t *testing.T) {
	parrot := AfricanParrot{baseParrot{}, 2}
	speed, err := parrot.Speed()
	assert.Equal(t, 0.0, speed)
	assert.NoError(t, err)
}

func TestSpeedOfAfricanParrot_With_No_Coconuts(t *testing.T) {
	parrot := AfricanParrot{baseParrot{}, 0}
	speed, err := parrot.Speed()
	assert.Equal(t, 12.0, speed)
	assert.NoError(t, err)
}

func TestSpeedNorwegianBlueParrot_nailed(t *testing.T) {
	parrot := NorwegianBlueParrot{baseParrot{}, 1.5, true}
	speed, err := parrot.Speed()
	assert.Equal(t, 0.0, speed)
	assert.NoError(t, err)
}

func TestSpeedNorwegianBlueParrot_not_nailed(t *testing.T) {
	parrot := NorwegianBlueParrot{baseParrot{}, 1.5, false}
	speed, err := parrot.Speed()
	assert.Equal(t, 18.0, speed)
	assert.NoError(t, err)
}

func TestSpeedNorwegianBlueParrot_not_nailed_high_voltage(t *testing.T) {
	parrot := NorwegianBlueParrot{baseParrot{}, 4, false}
	speed, err := parrot.Speed()
	assert.Equal(t, 24.0, speed)
	assert.NoError(t, err)
}
