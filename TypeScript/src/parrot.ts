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
        switch (this.parrotType) {
            case ParrotTypes.AFRICAN:
                return Math.max(0, this.getBaseSpeed() - this.getLoadFactor() * this.numberOfCoconuts);
            case ParrotTypes.NORWEGIAN_BLUE:
                return (this.isNailed) ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
        }
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
}

export function createParrot(
    parrotType: ParrotTypes,
    numberOfCoconuts: number,
    voltage: number,
    nailed: boolean,
) {
    return parrotType === ParrotTypes.EUROPEAN
        ? new EuropeanParrot(numberOfCoconuts, voltage, nailed)
        : parrotType === ParrotTypes.AFRICAN
        ? new AfricanParrot(numberOfCoconuts, voltage, nailed)
        : new Parrot(parrotType, numberOfCoconuts, voltage, nailed);
}
