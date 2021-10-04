export enum ParrotTypes {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE,
}

export class Parrot {
    constructor(
        protected parrotType: ParrotTypes,
        protected numberOfCoconuts: number,
        protected voltage: number,
        protected isNailed: boolean,
    ) {
    }

    public getSpeed(): number {
        throw new Error("Should be unreachable");
    }

    protected getBaseSpeed(): number {
        return 12;
    }

    protected getLoadFactor(): number {
        return 9;
    }

    protected getBaseSpeedWithVoltage(voltage: number): number {
        return Math.min(24, voltage * this.getBaseSpeed());
    }

}

class EuropeanParrot extends Parrot {
    constructor(
        numberOfCoconuts: number,
        voltage: number,
        isNailed: boolean,
    ) {
        super(ParrotTypes.EUROPEAN, numberOfCoconuts, voltage, isNailed);
    }

    public getSpeed(): number {
        return this.getBaseSpeed();
    }
}

class AfricanParrot extends Parrot {
    constructor(
        numberOfCoconuts: number,
        voltage: number,
        isNailed: boolean,
    ) {
        super(ParrotTypes.AFRICAN, numberOfCoconuts, voltage, isNailed);
    }

    public getSpeed(): number {
        return Math.max(0, this.getBaseSpeed() - this.getLoadFactor() * this.numberOfCoconuts);
    }
}

class NorvegianBlueParrot extends Parrot {
    constructor(
        numberOfCoconuts: number,
        voltage: number,
        isNailed: boolean,
    ) {
        super(ParrotTypes.NORWEGIAN_BLUE, numberOfCoconuts, voltage, isNailed);
    }

    public getSpeed(): number {
        return (this.isNailed) ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
    }
}

export function createParrot(
    parrotType: ParrotTypes,
    numberOfCoconuts: number,
    voltage: number,
    nailed: boolean,
) {
    if (parrotType === ParrotTypes.EUROPEAN) {
        return new EuropeanParrot(numberOfCoconuts, voltage, nailed);
    } else if (parrotType === ParrotTypes.AFRICAN) {
        return new AfricanParrot(numberOfCoconuts, voltage, nailed);
    } else {
        return parrotType === ParrotTypes.NORWEGIAN_BLUE
            ? new NorvegianBlueParrot(numberOfCoconuts, voltage, nailed)
            : new Parrot(parrotType, numberOfCoconuts, voltage, nailed);
    }
}
