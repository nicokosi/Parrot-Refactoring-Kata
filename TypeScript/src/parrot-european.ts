import { Parrot, ParrotTypes } from "./parrot";

export class EuropeanParrot extends Parrot {
  constructor(numberOfCoconuts: number, voltage: number, isNailed: boolean) {
    super(ParrotTypes.EUROPEAN, numberOfCoconuts, voltage, isNailed);
  }

  public getSpeed(): number {
    return this.getBaseSpeed();
  }
}
