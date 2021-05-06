export enum ParrotTypes {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE,
}

export class Parrot {
    private static readonly BASE_SPEED = 12;

    private static readonly LOAD_FACTOR = 9;


    constructor(private parrotType: ParrotTypes,
                private numberOfCoconuts: number,
                private voltage: number,
                private isNailed: boolean) {
    }

    public getSpeed(): number {
        switch (this.parrotType) {
            case ParrotTypes.EUROPEAN:
                return Parrot.BASE_SPEED;
            case ParrotTypes.AFRICAN:
                return Math.max(0, Parrot.BASE_SPEED - this.getLoadFactor() * this.numberOfCoconuts);
            case ParrotTypes.NORWEGIAN_BLUE:
                return (this.isNailed) ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
        }
        throw new Error("Should be unreachable");
    }

    private getLoadFactor(): number {
        return Parrot.LOAD_FACTOR;
    }

    private getBaseSpeedWithVoltage(voltage: number): number {
        return Math.min(24, voltage * Parrot.BASE_SPEED);
    }

}
