export enum ParrotTypes {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE,
}

export class Parrot {
    protected static readonly BASE_SPEED = 12;

    protected static readonly LOAD_FACTOR = 9;

    private static readonly LOAD_FACTOR = 9;

    constructor(private parrotType: ParrotTypes,
                private numberOfCoconuts: number,
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

    public getSpeed(): number {
        return this.isNailed ? 0 : Parrot.getBaseSpeedWithVoltage(this.voltage);
    }
}
