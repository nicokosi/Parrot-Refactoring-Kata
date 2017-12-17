export class Parrot {
    getSpeed() {
        throw new Error("Should be unreachable");
    }

    getBaseSpeed() {
        return 12;
    }
}

export class EuropeanParrot extends Parrot {
    getSpeed() {
        return this.getBaseSpeed();
    }
}

export class AfricanParrot extends Parrot {
    constructor(numberOfCoconuts) {
        super();
        this.numberOfCoconuts = numberOfCoconuts;
    }

    getSpeed() {
        return Math.max(0, this.getBaseSpeed() - this.slowdownDueCoconuts());
    }

    getLoadFactor() {
        return 9;
    }

    slowdownDueCoconuts() {
        return this.getLoadFactor() * this.numberOfCoconuts;
    }
}

export class NorwegianBlueParrot extends Parrot {
    constructor(voltage, isNailed) {
        super();
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    getSpeed() {
        return this.isNailed ? 0 : this.speedWithVoltage();
    }

    speedWithVoltage() {
        return Math.min(this.maxSpeed(), this.voltage * this.getBaseSpeed());
    }

    maxSpeed() {
        return 24;
    }
}
