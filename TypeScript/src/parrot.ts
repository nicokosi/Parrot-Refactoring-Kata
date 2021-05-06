const BASE_SPEED = 12;

export interface IParrot {

    getSpeed(): number;

}

export class AfricanParrot implements IParrot {

    private static readonly LOAD_FACTOR = 9;

    constructor(private numberOfCoconuts: number) {
    }

    public getSpeed(): number {
        return Math.max(0, BASE_SPEED - AfricanParrot.LOAD_FACTOR * this.numberOfCoconuts);
    }
}

export class EuropeanParrot implements IParrot {

    public getSpeed(): number {
        return BASE_SPEED;
    }
}

export class NorwegianParrot implements IParrot {

    private static getBaseSpeedWithVoltage(voltage: number): number {
        return Math.min(24, voltage * BASE_SPEED);
    }

    constructor(private voltage: number,
                private isNailed: boolean) {
    }

    public getSpeed(): number {
        return this.isNailed ? 0 : NorwegianParrot.getBaseSpeedWithVoltage(this.voltage);
    }

}
