import { Parrot } from "./parrot";

export class NorwegianBlueParrot extends Parrot {
  constructor(numberOfCoconuts: number, voltage: number, protected isNailed: boolean) {
    super(numberOfCoconuts, voltage);
  }
  public getSpeed(): number {
      return this.isNailed ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
  }
}
