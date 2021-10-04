export enum ParrotTypes {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE,
}

export class Parrot {
    // @ts-ignore
    constructor(private parrotType: ParrotTypes,
                protected numberOfCoconuts: number,
                protected voltage: number,
                protected isNailed: boolean) {
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
