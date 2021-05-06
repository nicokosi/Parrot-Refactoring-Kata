const BASE_SPEED = 12;

export abstract class Parrot {

    public abstract getSpeed(): number;

}

export class AfricanParrot extends Parrot {

    private static readonly LOAD_FACTOR = 9;

    constructor(private numberOfCoconuts: number) {
        super();
    }

    public getSpeed(): number {
        return Math.max(0, BASE_SPEED - AfricanParrot.LOAD_FACTOR * this.numberOfCoconuts);
    }
}

export class EuropeanParrot extends Parrot {

    public getSpeed(): number {
        return BASE_SPEED;
    }
}

export class NorwegianParrot extends Parrot {

    private static getBaseSpeedWithVoltage(voltage: number): number {
        return Math.min(24, voltage * BASE_SPEED);
    }

    constructor(private voltage: number,
                private isNailed: boolean) {
        super();
    }

    public getSpeed(): number {
        return this.isNailed ? 0 : NorwegianParrot.getBaseSpeedWithVoltage(this.voltage);
    }

}
