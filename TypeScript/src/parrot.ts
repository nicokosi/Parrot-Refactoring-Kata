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
    constructor(private voltage: number,
                private isNailed: boolean) {
    }

    public getSpeed(): number {
        const baseSpeedWithVoltage = Math.min(24, this.voltage * BASE_SPEED);
        return this.isNailed ? 0 : baseSpeedWithVoltage;
    }

}
