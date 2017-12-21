/* global module */

function Parrot() {
}

Parrot.prototype.getBaseSpeed = function() {
    'use strict';
    return 12;
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

AfricanParrot.prototype.getSpeed = function() {
    'use strict';
    return Math.max(0, this.getBaseSpeed() - this.slowdownDueCoconuts());
};

AfricanParrot.prototype.slowdownDueCoconuts = function() {
    'use strict';
    return this.getLoadFactor() * this.numberOfCoconuts;
};

AfricanParrot.prototype.getLoadFactor = function() {
    'use strict';
    return 9;
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
    return (this.isNailed) ? 0 : this.speedForVoltage();
};

NorwegianBlueParrot.prototype.speedForVoltage = function() {
    'use strict';
    return Math.min(this.maxSpeed(), this.voltage * this.getBaseSpeed());
};

NorwegianBlueParrot.prototype.maxSpeed = function() {
    'use strict';
    return 24;
};

module.exports = {};
module.exports.EuropeanParrot = EuropeanParrot;
module.exports.AfricanParrot = AfricanParrot;
module.exports.NorwegianBlueParrot = NorwegianBlueParrot;
