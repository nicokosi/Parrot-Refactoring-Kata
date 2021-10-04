import { Parrot } from "./parrot";

export class NorwegianBlueParrot extends Parrot {
  constructor(protected voltage: number, protected isNailed: boolean) {
    super();
  }
  private get baseSpeedWithVoltage() {
    return Math.min(24, this.voltage * this.baseSpeed);
  }
  public getSpeed(): number {
      return this.isNailed ? 0 : this.baseSpeedWithVoltage;
  }
}
