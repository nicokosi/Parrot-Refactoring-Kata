export class Parrot {
  constructor(
    protected numberOfCoconuts: number
  ) {}

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
