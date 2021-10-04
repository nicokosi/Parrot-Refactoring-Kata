import { Parrot } from "./parrot";

export class NorwegianBlueParrot extends Parrot {
  constructor(numberOfCoconuts: number, protected voltage: number, protected isNailed: boolean) {
    super(numberOfCoconuts);
  }
  public getSpeed(): number {
      return this.isNailed ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
  }
}
