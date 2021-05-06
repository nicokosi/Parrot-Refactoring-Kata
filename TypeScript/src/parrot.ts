export enum ParrotTypes {
    AFRICAN,
    NORWEGIAN_BLUE,
}

const BASE_SPEED = 12;

export class Parrot {

    public getSpeed(): number {
        throw new Error("Should be unreachable");
    }

}

export class AfricanParrot extends Parrot {

    private static readonly LOAD_FACTOR = 9;

    constructor(protected numberOfCoconuts: number,
                protected voltage: number,
                protected isNailed: boolean) {
        super();
    }

    public getSpeed(): number {
        return Math.max(0, BASE_SPEED - AfricanParrot.LOAD_FACTOR * this.numberOfCoconuts);
    }
}

export class EuropeanParrot {

    public getSpeed(): number {
        return BASE_SPEED;
    }
}

export class NorwegianParrot extends Parrot {

    private static getBaseSpeedWithVoltage(voltage: number): number {
        return Math.min(24, voltage * BASE_SPEED);
    }

    constructor(protected parrotType: ParrotTypes,
                protected numberOfCoconuts: number,
                protected voltage: number,
                protected isNailed: boolean) {
        super();
    }

    public getSpeed(): number {
        return this.isNailed ? 0 : NorwegianParrot.getBaseSpeedWithVoltage(this.voltage);
    }

}
