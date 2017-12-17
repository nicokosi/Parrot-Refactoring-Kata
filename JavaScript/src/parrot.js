export const PARROT_TYPES = {
    NORWEGIAN_BLUE: 'NORWEGIAN_BLUE',
};

export class Parrot {
    constructor(type, numberOfCoconuts, voltage, isNailed) {
        this.type = type;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    getSpeed() {
        switch (this.type) {
            case PARROT_TYPES.NORWEGIAN_BLUE:
                return (this.isNailed) ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
        }
        throw new Error("Should be unreachable");
    }

    getBaseSpeedWithVoltage(voltage) {
        return Math.min(24, voltage * this.getBaseSpeed());
    }

    getBaseSpeed() {
        return 12;
    }
}

export class EuropeanParrot extends Parrot {
    constructor() {
        super(null, 0, 0, false);
    }

    getSpeed() {
        return this.getBaseSpeed();
    }

}

export class AfricanParrot extends Parrot {
    constructor(numberOfCoconuts) {
        super(null, 0, 0, false);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    getSpeed() {
        return Math.max(0, this.getBaseSpeed() - this.getLoadFactor() * this.numberOfCoconuts);
    }

    getLoadFactor() {
        return 9;
    }

}

export class NorwegianBlueParrot extends Parrot {

}