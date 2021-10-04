import { Parrot } from "./parrot";

export class EuropeanParrot extends Parrot {
  constructor() {
    super();
  }

  public get speed(): number {
    return this.baseSpeed;
  }
}
