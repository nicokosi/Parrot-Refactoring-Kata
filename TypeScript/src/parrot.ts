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
    private readonly MIN_SPEED = 24;

    private readonly NAILED_SPEED = 0;

    constructor(private voltage: number,
                private isNailed: boolean) {
    }

    public getSpeed(): number {
        if (this.isNailed) {
            return this.NAILED_SPEED;
        }

        return Math.min(this.MIN_SPEED, this.voltage * BASE_SPEED);
    }

}
