import { Parrot } from "./parrot";

export class EuropeanParrot extends Parrot {
  constructor(numberOfCoconuts: number) {
    super(numberOfCoconuts);
  }

  public getSpeed(): number {
    return this.getBaseSpeed();
  }
}
