/* global module */

var PARROT_TYPES = {
    AFRICAN : 'AFRICAN',
    NORWEGIAN_BLUE : 'NORWEGIAN_BLUE'
};

function Parrot(parrotType, numberOfCoconuts, voltage, isNailed) {
    'use strict';
    this.parrotType = parrotType;
    this.numberOfCoconuts = numberOfCoconuts;
    this.voltage = voltage;
    this.isNailed = isNailed;
}

Parrot.prototype.getBaseSpeed = function() {
    'use strict';
    return 12;
};

Parrot.prototype.getBaseSpeedWithVoltage = function(voltage) {
    'use strict';
    return Math.min(24, this.voltage * this.getBaseSpeed());
};

Parrot.prototype.getSpeed = function() {
    'use strict';
    switch (this.parrotType) {
    case PARROT_TYPES.NORWEGIAN_BLUE:
        return (this.isNailed) ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
    }
    throw new Error("Should be unreachable");
};

function EuropeanParrot() {
    'use strict';
    Parrot.call(this);
}

EuropeanParrot.prototype = Object.create(Parrot.prototype);

EuropeanParrot.prototype.getSpeed = function() {
    'use strict';
    return this.getBaseSpeed();
};

function AfricanParrot(numberOfCoconuts) {
    'use strict';
    Parrot.call(this);
    this.numberOfCoconuts = numberOfCoconuts;
}

AfricanParrot.prototype = Object.create(Parrot.prototype);

AfricanParrot.prototype.getLoadFactor = function() {
    'use strict';
    return 9;
};

AfricanParrot.prototype.getSpeed = function() {
    'use strict';
    return Math.max(0, this.getBaseSpeed() - this.getLoadFactor() * this.numberOfCoconuts);
};

function NorwegianBlueParrot(voltage, isNailed) {
    'use strict';
    Parrot.call(this, PARROT_TYPES.NORWEGIAN_BLUE, 0, voltage, isNailed);
    this.voltage = voltage;
    this.isNailed = isNailed;
}

NorwegianBlueParrot.prototype = Object.create(Parrot.prototype);

module.exports = Parrot;
module.exports.TYPES = PARROT_TYPES;
module.exports.EuropeanParrot = EuropeanParrot;
module.exports.AfricanParrot = AfricanParrot;
module.exports.NorwegianBlueParrot = NorwegianBlueParrot;
