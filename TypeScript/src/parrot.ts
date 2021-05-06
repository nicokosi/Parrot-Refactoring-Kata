export enum ParrotTypes {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE,
}

export class Parrot {
    protected static readonly BASE_SPEED = 12;

    private static readonly LOAD_FACTOR = 9;

    private static getBaseSpeedWithVoltage(voltage: number): number {
        return Math.min(24, voltage * Parrot.BASE_SPEED);
    }

    constructor(private parrotType: ParrotTypes,
                private numberOfCoconuts: number,
                private voltage: number,
                private isNailed: boolean) {
    }

    public getSpeed(): number {
        switch (this.parrotType) {
            case ParrotTypes.AFRICAN:
                return Math.max(0, Parrot.BASE_SPEED - Parrot.LOAD_FACTOR * this.numberOfCoconuts);
            case ParrotTypes.NORWEGIAN_BLUE:
                return this.isNailed ? 0 : Parrot.getBaseSpeedWithVoltage(this.voltage);
        }
        throw new Error("Should be unreachable");
    }

}

export class AfricanParrot extends Parrot {

    public getSpeed(): number {
        return super.getSpeed();
    }
}

export class EuropeanParrot extends Parrot {

    public getSpeed(): number {
        return Parrot.BASE_SPEED;
    }
}

export class NorwegianParrot extends Parrot {

    public getSpeed(): number {
        return super.getSpeed();
    }
}
