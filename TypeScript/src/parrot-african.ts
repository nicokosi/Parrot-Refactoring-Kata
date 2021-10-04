import { Parrot } from "./parrot";

export class AfricanParrot extends Parrot {
  constructor(numberOfCoconuts: number, voltage: number) {
    super(numberOfCoconuts, voltage);
  }
  public getSpeed(): number {
    return Math.max(
      0,
      this.getBaseSpeed() - this.getLoadFactor() * this.numberOfCoconuts
    );
  }
}
