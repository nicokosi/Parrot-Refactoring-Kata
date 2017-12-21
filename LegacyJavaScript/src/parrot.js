/* global module */

function Parrot() {
}

Parrot.prototype.getBaseSpeed = function() {
    'use strict';
    return 12;
};

Parrot.prototype.getSpeed = function() {
    'use strict';
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
    Parrot.call(this);
    this.voltage = voltage;
    this.isNailed = isNailed;
}

NorwegianBlueParrot.prototype = Object.create(Parrot.prototype);

NorwegianBlueParrot.prototype.getSpeed = function() {
    'use strict';
    return (this.isNailed) ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
};

NorwegianBlueParrot.prototype.getBaseSpeedWithVoltage = function(voltage) {
    'use strict';
    return Math.min(24, this.voltage * this.getBaseSpeed());
};


module.exports = Parrot;
module.exports.EuropeanParrot = EuropeanParrot;
module.exports.AfricanParrot = AfricanParrot;
module.exports.NorwegianBlueParrot = NorwegianBlueParrot;
