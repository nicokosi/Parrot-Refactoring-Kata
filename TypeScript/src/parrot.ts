export enum ParrotTypes {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE,
}

export class Parrot {
    protected static readonly BASE_SPEED = 12;

    protected static readonly LOAD_FACTOR = 9;

    constructor(protected parrotType: ParrotTypes,
                protected numberOfCoconuts: number,
                protected voltage: number,
                protected isNailed: boolean) {
    }

    public getSpeed(): number {
        throw new Error("Should be unreachable");
    }

}

export class AfricanParrot extends Parrot {

    public getSpeed(): number {
        return Math.max(0, Parrot.BASE_SPEED - Parrot.LOAD_FACTOR * this.numberOfCoconuts);
    }
}

export class EuropeanParrot extends Parrot {

    public getSpeed(): number {
        return Parrot.BASE_SPEED;
    }
}

export class NorwegianParrot extends Parrot {

    private static getBaseSpeedWithVoltage(voltage: number): number {
        return Math.min(24, voltage * Parrot.BASE_SPEED);
    }

    public getSpeed(): number {
        return this.isNailed ? 0 : NorwegianParrot.getBaseSpeedWithVoltage(this.voltage);
    }

}
