export abstract class Parrot {
  public abstract getSpeed(): number;

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
