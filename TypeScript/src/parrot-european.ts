import { Parrot } from "./parrot";

export class EuropeanParrot extends Parrot {
  constructor(numberOfCoconuts: number, voltage: number) {
    super(numberOfCoconuts, voltage);
  }

  public getSpeed(): number {
    return this.getBaseSpeed();
  }
}
