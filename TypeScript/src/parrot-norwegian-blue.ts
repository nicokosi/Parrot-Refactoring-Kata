import { Parrot, ParrotTypes } from "./parrot";

export class NorwegianBlueParrot extends Parrot {
  constructor(numberOfCoconuts: number, voltage: number, isNailed: boolean) {
    super(ParrotTypes.NORWEGIAN_BLUE, numberOfCoconuts, voltage, isNailed);
  }
  public getSpeed(): number {
      return this.isNailed ? 0 : this.getBaseSpeedWithVoltage(this.voltage);
  }
}
