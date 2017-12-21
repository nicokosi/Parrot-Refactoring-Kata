/* global module */

var PARROT_TYPES = {
    EUROPEAN:       'EUROPEAN',
    AFRICAN:        'AFRICAN',
    NORWEGIAN_BLUE: 'NORWEGIAN_BLUE'
};

function Parrot(parrotType, numberOfCoconuts, voltage, isNailed) {
    'use strict';
    var self = this;

    function getLoadFactor() {
        return 9;
    }

    function getBaseSpeedWithVoltage(voltage) {
        return Math.min(24, voltage * self.getBaseSpeed());
    }

    this.getSpeed = function() {
        switch (parrotType) {
        case PARROT_TYPES.EUROPEAN:
            return self.getBaseSpeed();
        case PARROT_TYPES.AFRICAN:
            return Math.max(0, self.getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
        case PARROT_TYPES.NORWEGIAN_BLUE:
            return (isNailed) ? 0 : getBaseSpeedWithVoltage(voltage);
        }
        throw new Error("Should be unreachable");
    };

    return this;
}

Parrot.prototype.getBaseSpeed = function() {
    'use strict';
    return 12;
};

module.exports = Parrot;
module.exports.TYPES = PARROT_TYPES;
