import { Parrot } from "./parrot";

export class AfricanParrot extends Parrot {
  constructor(protected numberOfCoconuts: number) {
    super();
  }
  public getSpeed(): number {
    return Math.max(
      0,
      this.getBaseSpeed() - this.getLoadFactor() * this.numberOfCoconuts
    );
  }
}
