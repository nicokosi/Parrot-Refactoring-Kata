import { Parrot } from "./parrot";

export class NorwegianBlueParrot extends Parrot {
  constructor(protected voltage: number, protected isNailed: boolean) {
    super();
  }
  protected getBaseSpeedWithVoltage(voltage: number): number {
    return Math.min(24, voltage * this.getBaseSpeed());
  }
  public getSpeed(): number {
      return this.isNailed ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
  }
}
