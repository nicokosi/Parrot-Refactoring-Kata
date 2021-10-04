import { Parrot } from "./parrot";

export class NorwegianBlueParrot extends Parrot {
  constructor(protected voltage: number, protected isNailed: boolean) {
    super();
  }
  public getSpeed(): number {
      return this.isNailed ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
  }
}
